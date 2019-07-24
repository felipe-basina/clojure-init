(ns rest-demo.core-test
  (:require [clojure.test :refer :all]
            [rest-demo.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(defn request [resource web-app & params]
   (web-app {:request-method :get :uri resource :params (first params)}))

(deftest test-simple-body-page
  (is (= 200 (:status (request "/" app-routes))))
  (is (= "Hello World" (:body (request "/" app-routes))))
  (is (= {"Content-Type" "text/html"} (:headers (request "/" app-routes)))))

(deftest test-request-example
  (is (= 200 (:status (request "/request" app-routes))))
  (is (= {"Content-Type" "text/html"} (:headers (request "/request" app-routes)))))  

(deftest test-hello-name
  (is (= 200 (:status (request "/hello" app-routes))))
  (is (= "Hello there!!!" (:body (request "/hello" app-routes {:name "there!!!"}))))
  (is (= {"Content-Type" "text/html"} (:headers (request "/hello" app-routes)))))

(deftest test-not-found
  (is (= 404 (:status (request "/not" app-routes))))
  (is (= "Error, page not found!" (:body (request "/not" app-routes))))
  (is (= {"Content-Type" "text/html; charset=utf-8"} (:headers (request "/not" app-routes)))))