(ns mikron.compiler.util
  "Compile time utility functions."
  (:require [clojure.spec.alpha :as s]
            [mikron.compiler.util-specs :as util-specs])
  #?(:cljs (:require-macros [mikron.compiler.util])))

(defn enforce-spec
  "Returns `value` conformed to `spec`, or throws an exception if the conformation fails."
  [spec value]
  (let [value' (s/conform spec value)]
    (if (s/invalid? value')
      (throw (ex-info "Value does not conform to spec" (s/explain-data spec value)))
      value')))

(defmacro cljs?
  "Returns `true` if compiled for cljs, `false` otherwise."
  []
  `(boolean (:ns ~'&env)))

(defmacro with-gensyms
  "Executes each expression of `body` in the context of each symbol in `syms`
   bound to a generated symbol."
  [& args]
  (let [{:keys [syms body]} (enforce-spec ::util-specs/with-gensyms-args args)]
    `(let [~@(mapcat (fn [sym]
                       (let [gensym-expr `(gensym ~(str sym))]
                         [sym (if-some [sym-meta (meta sym)]
                                `(vary-meta ~gensym-expr merge ~(meta sym))
                                gensym-expr)]))
                     syms)]
       ~@body)))

(defmacro with-evaluated
  "Executes each expression of `body` in the context of each symbol in `syms`
   bound to an **evaluated** value. Can be used to prevent accidental multiple evaluation
   in macros."
  [& args]
  (let [{:keys [syms body]} (enforce-spec ::util-specs/with-evaluated-args args)]
    (let [sym-map (into {} (map (juxt identity gensym) syms))]
      `(let [~@(mapcat (fn [[sym temp-sym]]
                         [temp-sym `(gensym '~sym)])
                       sym-map)]
         `(let [~~@(mapcat reverse sym-map)]
            ~(let [~@(mapcat identity sym-map)]
               ~@body))))))

(defmacro syntax-cond->
  "Combination of `cond->` and `as->`."
  [& args]
  (let [{:keys [expr alias cond+exprs]} (enforce-spec ::util-specs/syntax-cond->-args args)]
    `(let [~alias ~expr
           ~@(mapcat (fn [{:keys [cond expr]}]
                       [alias `(if ~cond ~expr ~alias)])
                     cond+exprs)]
       ~alias)))

(defmacro macro-context
  "Macro helper function, the equivalent of `with-gensyms` + `with-evaluated`."
  [& args]
  (let [{:keys [context body]}       (enforce-spec ::util-specs/macro-context-args args)
        {:keys [gen-syms eval-syms]} context]
    (syntax-cond-> `(do ~@body) expr
      (not (empty? gen-syms))  `(with-gensyms ~gen-syms ~expr)
      (not (empty? eval-syms)) `(with-evaluated ~eval-syms ~expr))))
