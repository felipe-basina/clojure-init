;; Needs to be imported from a project
(:require [medley.core :refer (map-keys)])

(defn keywordize-entity [entity]
    (map-keys keyword entity))

(println (keywordize-entity {"name" "Earth"
                             "moon" 1
                             "volume" 1.08321e12
                             "mass" 5.97219e24
                             "aphelion" 152098232
                             "perihelion" 147098290}))