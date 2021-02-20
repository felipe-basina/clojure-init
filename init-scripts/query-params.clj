(require '[clojure.string :as str])

(def query-params "name=joe&last_name=doe&age=21")

(defn split-by [string split-value]
    (str/split string (re-pattern split-value)))

(defn create-map [param]
    (let [splited (split-by param "=")]
        (assoc {} (keyword (first splited)) (second splited))))

(defn print-map-content [map-content]
    (loop [content map-content]
        (if (not-empty content)
            (let [element (first content)]
                (println "key" (first element) ", value" (second element))
                (recur (rest content))))))

(def query-param-map (reduce merge (map create-map (split-by query-params "&"))))
(println "query param as map:" query-param-map "\nis really a map?" (map? query-param-map))
(print-map-content query-param-map)