(ns hipstr.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[hipstr started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[hipstr has shut down successfully]=-"))
   :middleware identity})
