(ns mikron.browser
  "Browser test runner."
  (:require [clojure.test :as test]
            [mikron.test]))

(enable-console-print!)

(defmethod test/report [::test/default :summary] [summary]
  (println "Test summary: " summary))

(test/run-tests 'mikron.test)
