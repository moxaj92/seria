(ns mikron.codegen.gen
  "Generator generating functions."
  (:require [mikron.schema :as schema]
            [mikron.compile-util :as compile-util]
            [mikron.util.schema :as util.schema]
            [mikron.util.coll :as util.coll]
            [mikron.util.math :as util.math]))

(def ^:const gen-length 4)

(defmulti gen schema/schema-name :hierarchy #'schema/hierarchy)

(defn gen-integer
  "Generates code for random integer generation."
  [bytes signed?]
  (compile-util/with-gensyms [r]
    `(let [~r (util.math/rand)]
       (-> (* ~r ~(util.math/upper-bound bytes signed?))
           (+ (* (- 1 ~r) ~(util.math/lower-bound bytes signed?)))
           (util.math/floor)
           (unchecked-long)))))

(defmethod gen :byte [_ _]
  (gen-integer 1 true))

(defmethod gen :ubyte [_ _]
  (gen-integer 1 false))

(defmethod gen :short [_ _]
  (gen-integer 2 true))

(defmethod gen :ushort [_ _]
  (gen-integer 2 false))

(defmethod gen :int [_ _]
  (gen-integer 4 true))

(defmethod gen :uint [_ _]
  (gen-integer 4 false))

(defmethod gen :long [_ _]
  (gen-integer 8 true))

(defmethod gen :varint [_ env]
  (gen [:long] env))

(defmethod gen :float [_ _]
  `(util.schema/double->float (util.math/rand)))

(defmethod gen :double [_ _]
  `(util.math/rand))

(defmethod gen :boolean [_ _]
  `(< 0.5 (util.math/rand)))

(defmethod gen :char [_ _]
  `(char (util.math/rand-long 500)))

(defmethod gen :string [_ env]
  `(apply str (util.coll/into! [] true ~gen-length ~(gen [:char] env))))

(defmethod gen :binary [_ _]
  `(-> (util.coll/into! [] true
                        (unchecked-add 2 (util.math/rand-long 30))
                        ~(gen-integer 1 true))
       (util.schema/byte-seq->binary)))

(defmethod gen :any [_ _]
  nil)

(defmethod gen :nil [_ _]
  nil)

(defmethod gen :coll [[_ _ schema'] env]
  `(util.coll/into! [] true ~gen-length ~(gen schema' env)))

(defmethod gen :set [[_ {:keys [sorted-by]} schema'] env]
  `(util.coll/into! ~(if sorted-by `(sorted-set-by ~sorted-by) #{})
                    ~(nil? sorted-by)
                    ~gen-length
                    ~(gen schema' env)))

(defmethod gen :map [[_ {:keys [sorted-by]} key-schema value-schema] env]
  `(util.coll/into-kv! ~(if sorted-by `(sorted-map-by ~sorted-by) {})
                       ~(nil? sorted-by)
                       ~gen-length
                       ~(gen key-schema env)
                       ~(gen value-schema env)))

(defmethod gen :tuple [[_ _ schemas] env]
  (let [fields (compile-util/tuple->fields schemas)]
    `(let [~@(mapcat (fn [[key' value']]
                       [value' (gen (schemas key') env)])
                     fields)]
       ~(compile-util/fields->tuple fields))))

(defmethod gen :record [[_ {:keys [type]} schemas] env]
  (let [fields (compile-util/record->fields schemas)]
    `(let [~@(mapcat (fn [[key' value']]
                       [value' (gen (schemas key') env)])
                     fields)]
       ~(compile-util/fields->record fields type))))

(defmethod gen :optional [[_ _ schema'] env]
  `(when ~(gen [:boolean] env)
     ~(gen schema' env)))

(defmethod gen :multi [[_ _ _ multi-map] env]
  `(case (util.math/rand-long ~(count multi-map))
     ~@(->> multi-map
            (map-indexed (fn [index [_ schema']]
                           [index (gen schema' env)]))
            (apply concat))))

(defmethod gen :enum [[_ _ enum-values] env]
  `(util.coll/rand-nth ~enum-values))

(defmethod gen :wrapped [[_ _ _ post schema'] env]
  `(~post ~(gen schema' env)))

(defmethod gen :aliased [[schema'] env]
  (gen (schema/aliased-schemas schema') env))

(defmethod gen :custom [schema env]
  `(~(compile-util/processor-name :gen schema)))

(defmethod compile-util/processor :gen [_ {:keys [schema] :as env}]
  `([]
    ~(gen schema env)))
