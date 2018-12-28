(ns test.user-model
  (:gen-class)
  (:require [clojure.spec.alpha :as s]))

(defrecord UserModel [name age id language]) ;{:name "Matt" :age 36 :id 2 :language "clojure"}
(s/def ::positive-int (s/and int? #(> % 0)))
(s/def ::full-string (s/and string? #(> (count %) 0)))
(s/def ::name ::full-string)
(s/def ::age ::positive-int)
(s/def ::id ::positive-int)
(s/def ::language ::full-string)
(s/def ::user-model (s/keys :req-un [::name ::age ::id ::language]))

(defn get-user-model [name age id language]
  (let [model (->UserModel name age id language)]
    (if (s/valid? ::user-model model) model
        (throw (Exception. (str (s/explain ::user-model model)))))))

(defn adult? [user]
  (> (:age user) 18))

(defn language-fan? [user]
  (= "clojure" (:language user)))
