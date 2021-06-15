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

(defn insert [table record id-key]
      (let [updated-db (update-in (read-db) [table :data] conj record)
            total-elements (count (get-in updated-db [table :data]))
            content-exists? (contains? (get-in updated-db [table :indexes :name]) (id-key record))]
           (if content-exists?
             (println (str "Record with :name " (id-key record) " already exists. Aborting"))
             (write-db (update-in updated-db [table :indexes id-key] assoc (id-key record) (dec total-elements))))))

(insert :fruits {:name "Lemon" :stock 10} :name)
(insert :fruits {:name "Grapefruit" :stock 12} :name)
(insert :fruits {:name "Apple" :stock 28} :name)
(insert :fruits {:name "Lemon" :stock 28} :name)
(println (read-db))

(defn select-* [table-name]
      (get-in (read-db) [table-name :data]))

(println (select-* :fruits))

(defn select-*-where [table-name field field-value]
      (let [element-index (get-in (read-db) [table-name :indexes field field-value])]
           (nth (get-in (read-db) [table-name :data]) element-index)))

(println (select-*-where :fruits :name "Lemon"))
(println (select-*-where :fruits :name "Grapefruit"))
(println (select-*-where :fruits :name "Apple"))