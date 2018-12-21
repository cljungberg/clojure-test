(ns test.core-test
  (:require [clojure.test :refer :all]
            [test.core :refer :all]
            [test.return-one :as r]))

(deftest day3-test
  (testing "Works fine"
    (is (= 1 (r/return-one)))))

