(defproject moxaj/seria "0.1.3"
  :description "Seria is a schema-based serialization library for Clojure / ClojureScript."
  :url "https://github.com/moxaj/seria"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [cljsjs/bytebuffer "5.0.1-0"]]
  :target-path "target/%s"
  :source-paths ["src/cljc" "src/clj"]
  :java-source-paths ["src/java"]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [org.clojure/java.classpath "0.2.3"]
                                  [criterium "0.4.3"]
                                  [com.taoensso/nippy "2.10.0"]
                                  [proto-repl-charts "0.2.0"]
                                  [com.google.protobuf/protobuf-java "3.0.0-beta-2"]
                                  [org.clojars.runa/clj-kryo "1.5.0"]
                                  [cheshire "5.5.0"]]
                   :plugins [[moxaj/lein-seria "0.1.2"]]
                   :seria {"cat" {:source        "src/seria-config/config1.cljc"
                                  :target        "src/seria-config/config1-compiled.cljc"
                                  :namespace     "config1-compiled"
                                  :pretty-print? false}}}})
