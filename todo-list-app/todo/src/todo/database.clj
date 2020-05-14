(ns todo.database
  (:require [korma.db :as korma]))

(def db-connection-data
  (korma/mysql {:host "localhost" 
                :port 3306 
                :db "todolist" 
                :user "root" 
                :password "Acesso#123"}))

(korma/defdb conn db-connection-data)