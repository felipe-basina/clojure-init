(ns hipstr.routes.home
  (:require
   [hipstr.layout :as layout]
   [clojure.java.io :as io]
   [hipstr.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [request]
  (layout/render request "about.html"))

(defn foo-response [request]
  ;(println request)
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (str "<html><body><h1>Hello World!</h1><dt>Go bowling?</dt><dd>" (:go-bowling? request) "</dd></body></html>")})

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/about" {:get foo-response}]]) ; {:get about-page}

