(def earth {:nickname "water planet" :moons 1})
(def venus {:nickname "onion planet" :moons 3})
(def mars {:nickname "green" :moons 2})
(def mercury {:nickname "the red one" :moons 0})
(def neptune {:nickname "isolated" :moons 0})

(def planets [earth venus mars mercury neptune])

(defn has-moons? [planet]
    (pos? (:moons planet)))

(def grouped-by-moon (group-by has-moons? planets))
(println grouped-by-moon)
(println (count grouped-by-moon))
(println (map? grouped-by-moon))
(println (keys grouped-by-moon))
(println (vals grouped-by-moon))