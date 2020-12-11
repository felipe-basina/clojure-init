(ns shouter.models.shout
    (:require [clojure.java.jdbc :as sql]))

; Add db-config as first parameter when generating local uberjar
(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://localhost:5432/shouter"))

(defn all []
  (into [] (sql/query spec ["select * from shouts order by id desc"])))

(defn create [shout]
  (sql/insert! spec :shouts [:body] [shout]))

(defn delete [id]
  (sql/delete! spec :shouts ["id = ?" (Integer/parseInt id)]))