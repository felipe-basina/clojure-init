(ns shouter.models.shout
    (:require [clojure.java.jdbc :as sql]))

; Add db-config as first parameter when generating local uberjar
(def spec (or {:dbtype "postgresql" :dbname "shouter" :user "postgres" :password "Acesso#123" :classname "org.postgresql.Driver"}
              (System/getenv "DATABASE_URL")
              "postgresql://localhost:5432/shouter"))

(defn all []
  (let [db-response (sql/query spec ["select * from shouts order by id desc"])]
   (println "db-response" db-response)
   (into [] db-response)))

(defn create [shout]
  (sql/insert! spec :shouts [:body] [shout]))

(defn delete [id]
  (sql/delete! spec :shouts ["id = ?" (Integer/parseInt id)]))