(ns sample-in-mem-db)

(def memory-db (atom {}))

(defn read-db []
      @memory-db)

(defn write-db [new-db]
      (reset! memory-db new-db))

(defn create-table [table-name]
      (let [updated-db (assoc (read-db) (keyword table-name) {:data [] :indexes {}})]
           (write-db updated-db)))

(create-table "person")
(create-table "fruits")
(println (read-db))

(defn drop-table [table-name]
      (let [updated-db (dissoc (read-db) (keyword table-name))]
           (write-db updated-db)))

(drop-table "person")
(println (read-db))