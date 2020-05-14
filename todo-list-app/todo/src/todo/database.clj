(ns todo.database
  (:require [korma.db :as korma]))

(def db-connection-data
  (korma/mysql {:host "localhost" 
                :port 3307 
                :db "todolist" 
                :user "root" 
                :password "s3cr3t"}))

(korma/defdb conn db-connection-data)