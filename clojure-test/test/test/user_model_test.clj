(ns test.user-model-test
  (:require [clojure.test :refer :all]
            [test.core :refer :all]
            [test.user-model :as um]))

(deftest user-model-gives-correct-name-back
  (testing "Validate that Christina's name and are are valid"
    (is (= "Christina" (:name (um/get-user-model "Christina" 47 2 "clojure"))))
    (is (= 47 (:age (um/get-user-model "Christina" 47 2 "clojure"))))))

(deftest user-model-not-ok-negative-age
  (testing "Validate that errors are thrown when age is negative"
    (is (thrown? Exception (um/get-user-model "Christina" -47 2 "clojure")))))



; Run tests:
; (require 'test.user-model-test :reload-all)
; (in-ns 'test.user-model-test)
; (run-tests)