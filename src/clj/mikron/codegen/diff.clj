(ns mikron.codegen.diff
  "Differ and undiffer generating functions."
  (:require [mikron.type :as type]
            [mikron.codegen.common :as codegen.common]
            [mikron.compile-util :as compile-util]
            [mikron.util :as util]))

(defmulti diff compile-util/type-of :hierarchy #'type/hierarchy)

(defn diff* [schema route value-1 value-2 {:keys [processor-type] :as options}]
  (case processor-type
    :diff   `(if (= ~value-1 ~value-2)
               :mikron/dnil
               ~(diff schema route value-1 value-2 options))
    :undiff `(if (= :mikron/dnil ~value-2)
               ~value-1
               ~(diff schema route value-1 value-2 options))))

(defmethod diff :list [[_ _ schema'] route value-1 value-2 options]
  (compile-util/with-gensyms [vec-value-1]
    `(let [~vec-value-1 (vec ~value-1)]
       ~(diff [:vector {} schema'] route vec-value-1 value-2 options))))

(defmethod diff :vector [[_ _ schema'] route value-1 value-2 options]
  (compile-util/with-gensyms [index value-1' value-2']
    (let [route' (:all route)]
      (if-not route'
        (diff :default nil value-1 value-2 options)
        `(vec (map-indexed (fn [~index ~value-2']
                             (if-let [~value-1' (get ~value-1 ~index)]
                               ~(diff* schema' route' value-1' value-2' options)
                               ~value-2'))
                           ~value-2))))))

(defmethod diff :map [[_ {:keys [sorted-by]} _ val-schema] route value-1 value-2 options]
  (compile-util/with-gensyms [key val-1 val-2]
    (let [route' (:all route)]
      (if-not route'
        (diff :default nil value-1 value-2 options)
        (->> `(map (fn [[~key ~val-2]]
                     [~key (if-let [~val-1 (~value-1 ~key)]
                             ~(diff* val-schema route' val-1 val-2 options)
                             ~val-2)])
                   ~value-2)
             (compile-util/as-map sorted-by))))))

(defmethod diff :tuple [[_ _ schemas] route value-1 value-2 options]
  (compile-util/with-gensyms [value-1' value-2']
    (if-not (map? route)
      (diff :default nil value-1 value-2 options)
      (->> schemas
           (map-indexed (fn [index schema']
                          `(let [~value-1' (~value-1 ~index)
                                 ~value-2' (~value-2 ~index)]
                             ~(if-let [route' (route index)]
                                (diff* schema' route' value-1' value-2' options)
                                (diff :default nil value-1' value-2' options)))))
           (vec)))))

(defmethod diff :record [[_ {:keys [type]} schemas] route value-1 value-2 options]
  (compile-util/with-gensyms [value-1' value-2']
    (if-not (map? route)
      (diff :default nil value-1 value-2 options)
      (let [fields (compile-util/record->fields schemas)]
        `(let [~@(mapcat (fn [[index field]]
                           [field `(let [~value-1' ~(compile-util/record-lookup value-1 index type)
                                         ~value-2' ~(compile-util/record-lookup value-2 index type)]
                                     ~(if-let [route' (route index)]
                                        (diff* (schemas index) route' value-1' value-2' options)
                                        (diff :default nil value-1' value-2' options)))])
                         fields)]
           ~(compile-util/fields->record fields type))))))

(defmethod diff :optional [[_ _ schema'] route value-1 value-2 options]
  `(if (and ~value-1 ~value-2)
     ~(diff schema' route value-1 value-2 options)
     ~(diff :default nil value-1 value-2 options)))

(defmethod diff :multi [[_ _ selector multi-map] route value-1 value-2 options]
  (compile-util/with-gensyms [case-1 case-2]
    (if-not (map? route)
      (diff :default nil value-1 value-2 options)
      `(let [~case-1 (~selector ~value-1)
             ~case-2 (~selector ~value-2)]
         (if (not= ~case-1 ~case-2)
           ~(diff :default nil value-1 value-2 options)
           (condp = ~case-1
             ~@(mapcat (fn [[multi-case schema']]
                         [multi-case (if-let [route' (route multi-case)]
                                       (diff schema' route' value-1 value-2 options)
                                       (diff :default nil value-1 value-2 options))])
                       multi-map)))))))

(defmethod diff :wrapped [[_ _ pre post schema'] route value-1 value-2 options]
  (compile-util/with-gensyms [value-1' value-2']
    `(let [~value-1' (~pre ~value-1)
           ~value-2' (~pre ~value-2)]
       (~post ~(diff* schema' route value-1' value-2' options)))))

(defmethod diff :aliased [schema route value-1 value-2 options]
  (diff (type/aliases schema) route value-1 value-2 options))

(defmethod diff :custom [schema _ value-1 value-2 {:keys [processor-type]}]
  `(~(compile-util/processor-name processor-type schema) ~value-1 ~value-2))

(defmethod diff :default [_ _ _ value-2 _]
  value-2)

(defmethod codegen.common/fast-processors :diff [_ schema-name {:keys [schemas diff-routes] :as options}]
  (compile-util/with-gensyms [_ value-1 value-2]
    (let [schema (schemas schema-name)
          route  (diff-routes schema-name)]
      [`(~(compile-util/processor-name :diff schema-name)
         [~value-1 ~value-2]
         ~(diff* schema route value-1 value-2 (assoc options :processor-type :diff)))
       `(~(compile-util/processor-name :undiff schema-name)
         [~value-1 ~value-2]
         ~(diff* schema route value-1 value-2 (assoc options :processor-type :undiff)))])))

(defmethod codegen.common/processors :diff [_ schema-name options]
  (compile-util/with-gensyms [_ value-1 value-2]
    [`(defmethod util/process [:diff ~schema-name] [~_ ~_ ~value-1 ~value-2]
        (~(compile-util/processor-name :diff schema-name)
         ~value-1
         ~value-2))
     `(defmethod util/process [:undiff ~schema-name] [~_ ~_ ~value-1 ~value-2]
        (~(compile-util/processor-name :undiff schema-name)
         ~value-1
         ~value-2))]))
