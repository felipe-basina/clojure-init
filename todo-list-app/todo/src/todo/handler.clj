(ns todo.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [todo.service :refer :all]))

(defroutes app-routes
  (GET "/" [] (response "Hello from Clojure web app"))
  (GET "/api/todos" [] (response (get-todos)))
  (POST "/api/todos" {:keys [params]} 
    (let [{:keys [title description]} params]
      (response (add-todo title description))))
  (PUT "/api/todos/:id" {:keys [params]}
    (let [{:keys [id title description is_complete]} params]
      (update-todo id title description is_complete)
      (let [todo (get-todo-by-id id)]
        (if (empty? todo) nil
            (response (first todo))))))
  (PUT "/api/todos/:id/status" {:keys [params]}
    (let [{:keys [id is_complete]} params]
      (update-todo-status id is_complete)
      (let [todo (get-todo-by-id id)]
        (if (empty? todo) nil
            (response (first todo))))))
  (GET "/api/todos/:id" [id] 
    (response (get-todo-by-id id)))
  (DELETE "/api/todos/:id" [id]
    (delete-todo id)
    (response (get-todos)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))
