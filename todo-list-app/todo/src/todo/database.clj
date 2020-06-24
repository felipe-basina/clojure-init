(ns todo.database
  (:require [korma.db :as korma]))

(def db-connection-data
  (korma/mysql {:host (System/getenv "DATABASE_HOST") 
                :port (Integer/parseInt (System/getenv "DATABASE_PORT"))
                :db (System/getenv "DATABASE_SCHEMA")
                :user (System/getenv "DATABASE_USER") 
                :password (System/getenv "DATABASE_PASSWORD")}))

(korma/defdb conn db-connection-data)