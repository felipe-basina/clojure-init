(ns sample-in-mem-db)

(def memory-db (atom {}))

(defn read-db []
      @memory-db)

(defn write-db [new-db]
      (reset! memory-db new-db))