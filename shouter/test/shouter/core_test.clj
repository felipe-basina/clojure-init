(ns shouter.core-test
  (:require [clojure.test :refer :all]
            [shouter.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(defn my-sum [x y]
  (+ x y))

(deftest test-sum
  (testing "the sum"
    (is (= (my-sum 2 3) 5))))

(deftest test-sum-with-mock
  (testing "the sum with mock"
    (with-redefs [my-sum (fn [_ _] 5)]
      (is (= (my-sum 2 4) 5)))))