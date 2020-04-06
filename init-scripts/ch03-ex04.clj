;; Write a function, mapset, that works like map except the return value is a set
;; (mapset inc [1 1 2 2])
;;  => #{2 3}

(defn mapset [inc coll]
  ;; Receives a collection and parset it to set
  (into (sorted-set) (map inc coll)))

(def mapset-value (mapset inc [1 1 2 2]))
(println mapset-value)
(println "Is set?" (set? mapset-value))