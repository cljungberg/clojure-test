(ns test.user-model-test
  (:require [clojure.test :refer :all]
            [test.core :refer :all]
            [test.user-model :as um]))

(defmacro is-not-thrown? [e expr]
  `(is (not ('thrown? ~e ~expr))))

(deftest user-model-gives-correct-name-back
  (testing "Validate that Christina is valid"
    (is (= "Christina" (:name (um/get-user-model "Christina" 47 2 "clojure"))))
    (is (= 47 (:age (um/get-user-model "Christina" 47 2 "clojure"))))))

(deftest user-model-not-ok-negative-age
  (testing "Validate that errors are thrown when age is negative"
    (is (thrown? Exception (um/get-user-model "Christina" -47 2 "clojure")))))
