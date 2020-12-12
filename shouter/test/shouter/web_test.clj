(ns shouter.web-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [shouter.web :refer :all]
            [clojure.java.jdbc :as sql]))

(deftest test-http-ok-for-root
  (testing "main route"
    (with-redefs [sql/query (fn [_ _] {:id 1 :body "A message" :created_at "2020-01-01 10:00:00"})]
        (let [response (application (mock/request :get "/"))]
          (is (= (:status response) 200))
          (is (.contains (:body response) "What do you want to SHOUT?"))))))

(deftest test-http-not-found
  (testing "not-found route"
     (let [response (application (mock/request :get "/invalid/"))]
      (is (= (:status response) 404)))))