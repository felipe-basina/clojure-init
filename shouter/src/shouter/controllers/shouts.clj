(ns shouter.controllers.shouts
    (:require [compojure.core :refer [defroutes GET POST]]
              [clojure.string :as str]
              [ring.util.response :as ring]
              [shouter.views.shouts :as view]
              [shouter.models.shout :as model]))

(defn index []
  (view/index (model/all)))

(defn create
  [shout]
  (when-not (str/blank? shout)
            (model/create shout))
  (ring/redirect "/"))

(defn delete
  [id]
  (model/delete id)
  (ring/redirect "/"))

(defroutes routes
  (GET  "/" [] (index))
  (GET  "/:id" [id] (delete id))
  (POST "/" [shout] (create shout)))