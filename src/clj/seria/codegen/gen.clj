(ns seria.codegen.gen
  "Generator generating functions."
  (:require [seria.type :as type]
            [seria.util :as util]
            [seria.common :as common]))

(def ^:dynamic *options*)

(def gen-size `(+ 2 (rand-int 4)))

(defmulti gen util/type-of :hierarchy #'type/*hierarchy*)

(defmethod gen :byte [_]
  `(common/random-integer 1 true))

(defmethod gen :ubyte [_]
  `(common/random-integer 1 false))

(defmethod gen :short [_]
  `(common/random-integer 2 true))

(defmethod gen :ushort [_]
  `(common/random-integer 2 false))

(defmethod gen :int [_]
  `(common/random-integer 4 true))

(defmethod gen :uint [_]
  `(common/random-integer 4 false))

(defmethod gen :long [_]
  `(common/random-integer 8 true))

(defmethod gen :float [_]
  `(float (rand)))

(defmethod gen :double [_]
  `(double (rand)))

(defmethod gen :char [_]
  `(char ~(gen :ushort)))

(defmethod gen :boolean [_]
  `(zero? (rand-int 2)))

(defmethod gen :varint [_]
  (gen :long))

(defmethod gen :string [_]
  `(->> (fn [] ~(gen :char))
        (repeatedly ~gen-size)
        (apply str)))

(defmethod gen :keyword [_]
  `(->> (fn [] (rand-nth common/symbol-chars))
        (repeatedly ~gen-size)
        (apply str)
        (keyword)))

(defmethod gen :symbol [_]
  `(->> (fn [] (rand-nth common/symbol-chars))
        (repeatedly ~gen-size)
        (apply str)
        (symbol)))

(defmethod gen :any [_]
  "TODO")

(defmethod gen :nil [_]
  nil)

(defmethod gen :list [[_ _ inner-schema]]
  `(repeatedly ~gen-size (fn [] ~(gen inner-schema))))

(defmethod gen :vector [[_ _ inner-schema]]
  `(vec ~(gen [:list {} inner-schema])))

(defmethod gen :set [[_ {:keys [sorted-by]} inner-schema]]
  (->> (gen [:list {} inner-schema])
       (util/as-set sorted-by)))

(defmethod gen :map [[_ {:keys [sorted-by]} key-schema val-schema]]
  (->> `(->> (repeatedly ~gen-size (fn [] ~[(gen key-schema) (gen val-schema)]))
             (into {}))
       (util/as-map sorted-by)))

(defmethod gen :tuple [[_ _ inner-schemas]]
  (mapv gen inner-schemas))

(defmethod gen :record [schema]
  (let [[_ {:keys [constructor]} record-map] (util/expand-record schema (:schemas *options*))]
    (->> record-map
         (map (fn [[key inner-schema]]
                [key (gen inner-schema)]))
         (into {})
         (util/as-record constructor))))

(defmethod gen :optional [[_ _ inner-schema]]
  `(when ~(gen :boolean)
     ~(gen inner-schema)))

(defmethod gen :multi [[_ _ _ multi-map]]
  `(rand-nth ~(mapv gen (vals multi-map))))

(defmethod gen :enum [[_ _ enum-values]]
  `(rand-nth ~enum-values))

(defmethod gen :custom [schema]
  `(~(util/processor-name :gen schema)))

;; private api

(defn make-generator [schema-name {:keys [schemas] :as options}]
  (binding [*options* options]
    `(~(with-meta (util/processor-name :gen schema-name)
                  {:private true})
      []
      ~(gen (schemas schema-name)))))

;; public api

(defn make-global-generator [{:keys [schemas]}]
  (util/with-gensyms [schema]
    `(~(util/processor-name :gen)
      [~schema]
      (~(util/select-processor :gen schema schemas)))))
