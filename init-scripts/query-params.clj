(require '[clojure.string :as str])

(def query-params "name=joe&last_name=doe")
(println "query-params" query-params)

(defn split-by [string split-value]
    (str/split string (re-pattern split-value)))

(def splited-by-& (split-by query-params "&"))
(println splited-by-& (count splited-by-&))

(defn create-map [param]
    (let [splited (split-by param "=")]
        (assoc {} (keyword (first splited)) (second splited))))

(def query-param-map (reduce merge (map create-map splited-by-&)))
(println "query param as map:" query-param-map 
    "\nis really a map?" (map? query-param-map)
    "\nthe map keys:" (keys query-param-map)
    "\nthe map values:" (vals query-param-map)
    "\nthe :name key value is:" (:name query-param-map)
    "\nthe :last_name key value is:" (:last_name query-param-map))