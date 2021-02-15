(ns hipstr.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [hipstr.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[hipstr started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[hipstr has shut down successfully]=-"))
   :middleware wrap-dev})
