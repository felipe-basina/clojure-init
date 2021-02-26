(ns hipstr.routes.test-routes-test
  (:require
    [clojure.test :refer :all]
    [ring.mock.request :refer :all]
    [hipstr.handler :refer :all]
    [hipstr.middleware.formats :as formats]
    [muuntaja.core :as m]
    [mount.core :as mount]))

(defn parse-json [body]
  (m/decode formats/instance "application/json" body))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'hipstr.config/env
                 #'hipstr.handler/app-routes)
    (f)))

(deftest test-print-request
  (testing "print-request"
    (let [response ((app) (request :get "/req" {:server "localhost" :port 8080}))]
      (is (= 200 (:status response)))))

  (testing "get-request-param-by-key"
    (let [response ((app) (request :get "/req/vielleicht"))]
      (is (= 200 (:status response)))
      (is (= "vielleicht" (:body response)))))

  (testing "not-found route"
    (let [response ((app) (request :get "/req4"))]
      (is (= 404 (:status response))))))