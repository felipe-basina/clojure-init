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