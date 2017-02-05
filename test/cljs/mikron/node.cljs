(ns mikron.node
  "Node test runner."
  (:require [cljs.nodejs :as nodejs]
            [clojure.test :as test]
            [mikron.test]))

(nodejs/enable-util-print!)

(defmethod test/report [::test/default :summary] [{:keys [fail error] :as summary}]
  (println "Test summary: " summary)
  (.exit nodejs/process (if (= 0 fail error) 0 1)))

(test/run-tests 'mikron.test)
