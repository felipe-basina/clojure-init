(ns hipstr.components.app-component
  (:require
    [clojure.string :as str]))

(defn split-by [string split-value]
  (str/split string (re-pattern split-value)))

(defn create-map [param]
  (let [split (split-by param "=")]
    (assoc {} (keyword (first split)) (second split))))

(defn convert-query-param-to-map [query-params]
  (reduce merge
          (map create-map
               (split-by query-params "&"))))

(defn render-request-val [request]
  "Simply returns the value of request-key in request-map,
  if request-key is provided; Otherwise return the request-map.
  If request-key is provided, but not found in the request-map,
  a message indicating as such will be returned."
  (let [request-map request
        request-key (:val (:path-params request))]
    (str (if request-key
         (if-let [result ((keyword request-key) request-map)]
           result
           (str request-key " is not a valid key."))
         request-map))))