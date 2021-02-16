(ns hipstr.routes.test-routes
  (:require
    [hipstr.layout :as layout]
    [clojure.java.io :as io]
    [hipstr.middleware :as middleware]
    [ring.util.response]
    [ring.util.http-response :as response]))

(defn print-request [request]
  (println "NEW ROUTE :: test-routes")
  (println "request" (:name (:query-string request)))
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (if (not-empty (:query-string request))
           (str "the query string: " (:query-string request))
           (str request))})

(defn get-request-param-by-key [request]
  ;(println "request" (:val (:path-params request)))
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (:val (:path-params request))})

(defn get-request-param-by-key2 [{:keys [:path-params :val] :as request}]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (:val (:path-params request))})

(defn test-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/req" {:get print-request}]
   ["/req/:val" {:get get-request-param-by-key}]
   ["/req2/:val" {:get get-request-param-by-key2}]])
