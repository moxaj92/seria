(ns seria.core-test
  (:require [seria.config :refer [make-test-config]]
            [seria.core :refer [pack unpack diff undiff with-config]]
            [seria.generate :refer [sample]]
            [midje.sweet :refer [facts]]
            [criterium.core :refer [with-progress-reporting quick-bench]]
            [taoensso.nippy :refer [freeze]]))

(defn pack-roundtrip [value config]
  (with-config config
    (unpack (pack value))))

(defn test-pack [schemas]
  (facts
    (let [config (make-test-config :schemas schemas
                                   :schema-selector (constantly :x))]
      (doseq [value (sample 100 :x (:schemas config))]
        (pack-roundtrip value config) => [:x value]))))

(defn test-packs [arg]
  (every? true? (map test-pack arg)))

(def pack-test-cases
  [
   ; Primitive
   {:x :byte}
   {:x :ubyte}
   {:x :short}
   {:x :ushort}
   {:x :int}
   {:x :uint}
   {:x :long}
   {:x :float}
   {:x :double}
   {:x :char}
   {:x :boolean}

   ; Advanced
   {:x :string}
   {:x :keyword}
   {:x :symbol}
   {:x :any}

   ; Composite
   {:x [:list :byte]}
   {:x [:vector :int]}

   {:x [:set :short]}
   {:x [:set {:sorted-by :default} :short]}
   {:x [:set {:sorted-by >} :short]}

   {:x [:map :byte :string]}
   {:x [:map {:sorted-by :default} :byte :string]}
   {:x [:map {:sorted-by >} :byte :string]}

   ; Complex
   {:x [:list :y] :y [:tuple [:int :int]]}
   {:x [:optional :byte]}
   {:x [:enum [:cat :dog :measurement :error]]}
   {:x [:tuple [:int :float [:tuple [:int :int]]]]}
   {:x [:record {:a :int :b :string :c [:tuple [:int :int]]}]}
   {:x [:multi number? {true :int false [:tuple [:int :int]]}]}

   ; Custom
   {:x [:list :y]
    :y [:record {:a :int
                 :b :string
                 :c [:tuple [:float :float :float]]
                 :d [:list :int]}]}
   ; Box2d
   {:body     [:record {:delta {:enabled true}}
               {:user-data [:record {:id :int}]
                :position  :coord
                :angle     :float
                :body-type [:enum [:dynamic :static :kinetic]]
                :fixtures  [:list :fixture]}]
    :fixture  [:record {:delta {:enabled true}}
               {:user-data [:record {:color :int}]
                :coords    [:list :coord]}]
    :coord    [:tuple [:float :float]]
    :snapshot [:record {:delta {:enabled true}}
               {:time   :int
                :bodies [:list :body]}]
    :x        :snapshot}])


(defn diff-roundtrip [value-1 value-2 config]
  (with-config config
    (undiff value-1 (diff value-1 value-2))))

(defn test-diff [schemas]
  (facts
    (let [config (make-test-config :schemas schemas
                                   :schema-selector (constantly :x))]
      (doseq [[value-1 value-2] (partition 2 (sample 100 :x (:schemas config)))]
        (diff-roundtrip value-1 value-2 config) => value-2))))

(defn test-diffs [arg]
  (every? true? (map test-diff arg)))

(def diff-test-cases
  [{:x [:record {:delta {:enabled true}}
        {:a :int
         :b [:tuple {:delta {:enabled true}}
             [:y :y :y :y]]}]
    :y [:enum [1 2 3 4]]}

   {:x [:record {:delta {:enabled true
                         :ignored [:a]}}
        {:a :byte
         :b [:tuple [:byte :byte]]
         :c [:vector {:delta {:enabled true}}
             [:enum [:cat :dog]]]}]}])

;;;; Run tests

(let [config (make-test-config :schemas {:x [:tuple {:delta {:enabled true}}
                                             (vec (repeat 100 :y))]
                                         :y [:enum [:cat :dog]]}
                               :schema-selector (constantly :x)
                               :delta-strategy (constantly [:incremental 4]))]
  (with-config config
    (dotimes [_ 100]
      (let [value        (first (sample 1 :x (:schemas config)))
            packed-value (pack value :delta-group :main)]
        (if-not (= value (second (unpack packed-value)))
          (println "ERROR"))))))

#_(let [config (make-test-config :schemas {:body     [:record {:delta {:enabled true}}
                                                      {:user-data [:record {:id :int}]
                                                       :position  :coord
                                                       :angle     :float
                                                       :body-type [:enum [:dynamic :static :kinetic]]
                                                       :fixtures  [:list :fixture]}]
                                           :fixture  [:record {:delta {:enabled true}}
                                                      {:user-data [:record {:color :int}]
                                                       :coords    [:list :coord]}]
                                           :coord    [:tuple [:float :float]]
                                           :snapshot [:record {:delta {:enabled true}}
                                                      {:time   :int
                                                       :bodies [:list :body]}]
                                           :x        :snapshot}
                                 :schema-selector (constantly :x))
        value  (first (sample 1 :x (:schemas config)))]
    #_(with-config config
        (with-progress-reporting
          (quick-bench
            (pack value))))
    (with-config config
      (println (format "%d %d"
                       (count (pack value))
                       (count (freeze value))))))

#_(let [config (make-test-config :schemas {:x [:wrapped {:pre  (fn [values]
                                                                 (mapv #(Integer/parseInt %) values))
                                                         :post (fn [values]
                                                                 (mapv str values))}
                                               [:tuple [:int :int :int]]]}
                                 :schema-selector (constantly :x))]
    (with-config config
      (println (unpack (pack ["1" "2" "3"])))))

(test-packs pack-test-cases)
(test-diffs diff-test-cases)