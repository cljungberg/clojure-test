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
    (is (thrown? Exception (um/adult? "Christina" -47 2 "clojure")))))

(deftest user-adult-or-not-adult
  (testing "Validate that Christina is an adult but Lisa is not"
    (is (true? (um/adult? (um/get-user-model "Christina" 57 2 "clojure"))))
    (is (false? (um/adult? (um/get-user-model "Lisa" 17 2 "clojure"))))))

(deftest user-adult-or-not-adult-fluent
  (testing "Validate that Christina is an adult but Lisa is not, using fluent syntax"
    (is (true? (->> (um/get-user-model "Christina" 57 2 "clojure")
                    (um/adult?))))
    (is (false? (->> (um/get-user-model "Lisa" 17 2 "clojure")
                     (um/adult?))))))


; Run tests:
; (require 'test.user-model-test :reload-all)
; (in-ns 'test.user-model-test)
; (run-tests)