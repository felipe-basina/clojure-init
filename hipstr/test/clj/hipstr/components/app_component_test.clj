(ns hipstr.components.app-component-test
  (:require [clojure.test :refer :all]
            [hipstr.components.app-component :as app-comp]
            [clojure.string :as str]))

;; convert-query-param-to-map
(deftest test-convert-query-param-to-map
  (testing "convert query param to map"
    (let [query-param "name=joe&lastname=doe"
          param-as-map (app-comp/convert-query-param-to-map query-param)]
      (is (map? param-as-map))
      (is (= 2 (count param-as-map)))
      (is (contains? param-as-map :name))
      (is (contains? param-as-map :lastname))
      (is (= "joe" (:name param-as-map)))
      (is (= "doe" (:lastname param-as-map)))))

  (testing "convert query param to map :: single query param"
    (let [query-param "name=joe"
          param-as-map (app-comp/convert-query-param-to-map query-param)]
      (is (map? param-as-map))
      (is (= 1 (count param-as-map)))
      (is (contains? param-as-map :name))
      (is (= "joe" (:name param-as-map)))))

  (testing "convert query param to map :: returning empty map"
    (let [query-param {}
          param-as-map (app-comp/convert-query-param-to-map query-param)]
      (is (map? param-as-map))
      (is (empty? param-as-map)))))

;; render-request-val
(deftest test-render-request-val
  (testing "render request val :: port"
    (let [request-map {:port 8080 :server "localhost" :path-params {:val "port"}}
          content (app-comp/render-request-val request-map)]
      (is (not (str/includes? content "not a valid key")))
      (is (= "8080" content))))

  (testing "render request val :: server"
    (let [request-map {:port 8080 :server "localhost" :path-params {:val "server"}}
          content (app-comp/render-request-val request-map)]
      (is (not (str/includes? content "not a valid key")))
      (is (= "localhost" content))))

  (testing "render request val :: proxy (not found on map)"
    (let [request-map {:port 8080 :server "localhost" :path-params {:val "proxy"}}
          content (app-comp/render-request-val request-map)]
      (is (str/includes? content "not a valid key"))
      (is (= "proxy is not a valid key." content))))

  (testing "render request val :: without param"
    (let [request-map {:port 8080 :server "localhost"}
          content (app-comp/render-request-val request-map)]
      (is (string? content))
      (is (str/includes? content ":port"))
      (is (str/includes? content ":server")))))