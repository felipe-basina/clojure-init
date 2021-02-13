(ns todo.service
  (:require [korma.core :refer :all]
            [todo.database]))

(defentity todos)

(defn get-todos []
  (select todos))

(defn add-todo [title description]
  (insert todos 
          (values {:title title :description description :is_complete false})))

(defn update-todo [id title description is_complete]
  (update todos
          (set-fields {:title title 
                :description description
                :is_complete is_complete})
          (where {:id id})))

(defn update-todo-status [id is_complete]
  (update todos
          (set-fields {:is_complete is_complete})
          (where {:id id})))

(defn get-todo-by-id [id]
  (select todos
          (where {:id id})))

(defn delete-todo [id]
  (delete todos
          (where {:id id})))