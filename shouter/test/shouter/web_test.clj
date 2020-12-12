(ns shouter.web-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [ring.util.response :as ring]
            [shouter.web :refer :all]
            [clojure.java.jdbc :as sql]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [shouter.views.shouts :as view]))

(deftest test-http-ok-for-root
  (testing "main route"
    (with-redefs [sql/query (fn [_ _] [{:id 1 :body "A mock message" :created_at "2020-01-01 10:00:00"}])]
        (let [response (application (mock/request :get "/"))]
          (is (= (:status response) 200))
          (println response)
          (is (.contains (:body response) "What do you want to SHOUT?"))
          (is (.contains (:body response) "A mock message"))
          (is (.contains (:body response) "/1"))))))

(deftest test-http-ok-for-delete
  (testing "delete route"
    (with-redefs [sql/delete! (fn [_ _ _] 1)
                  sql/query (fn [_ _] [])]
      (let [response (application (mock/request :get "/"))]
        (is (= (:status response) 200))
        (println response)
        (is (.contains (:body response) "What do you want to SHOUT?"))))))

; Disabling CSRF for testing
(def app
  (-> routes
      (wrap-defaults (assoc site-defaults :security false))))

(deftest test-http-ok-for-post
  (testing "post route"
    (with-redefs [sql/insert! (fn [_ _ _ _] 1)]
      (let [response (app (mock/request :post "/" {:shout "Creating a message"}))]
        (is (= (:status response) 302))))))

(deftest test-http-ok-for-post-with-redirect
  (testing "post route with-redirect"
    (with-redefs [sql/insert! (fn [_ _ _ _] 1)
                  ring/redirect (fn [_] (view/index [{:id 101 :body "Creating a message" :created_at "2020-01-01 10:00:00"}]))]
      (let [response (app (mock/request :post "/" {:shout "Creating a message"}))]
        (is (= (:status response) 200))
        (println response)
        (is (.contains (:body response) "What do you want to SHOUT?"))
        (is (.contains (:body response) "Creating a message"))
        (is (.contains (:body response) "/101"))))))

(deftest test-http-not-found
  (testing "not-found route"
     (let [response (application (mock/request :get "/invalid/"))]
      (is (= (:status response) 404)))))