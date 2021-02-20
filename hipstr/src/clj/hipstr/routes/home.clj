(ns hipstr.routes.home
  (:require
   [hipstr.layout :as layout]
   [clojure.java.io :as io]
   [hipstr.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as http-response]
   [ring.util.response :as response]
   [hipstr.components.signup :as signup]))

(defn home-page [request]
  (layout/render request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [request]
  (layout/render request "about.html"))

(defn foo-response [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (str "<html><body><h1>Hello World!</h1><dt>Go bowling?</dt><dd>" (:go-bowling? request) "</dd></body></html>")})

(defn signup [request]
  (layout/render request "signup.html"))

(defn signup-page-submit [request]
  (let [errors (signup/validate-signup (:body request))]
    (if (empty? errors)
      (response/redirect "/signup-success")
      (layout/render request "signup.html" {:errors errors}))))

(defn success-signup [request]
  (println "on success-signup" request)
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Success!"})

;middleware/wrap-csrf
(defn home-routes []
  [""
   {:middleware [middleware/wrap-body-string
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/signup" {:get signup
               :post signup-page-submit}]
   ["/signup-success" {:get success-signup}]
   ["/about" {:get foo-response}]]) ; {:get about-page}

