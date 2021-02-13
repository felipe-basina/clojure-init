;; Write a function, mapset, that works like map except the return value is a set
;; (mapset inc [1 1 2 2])
;;  => #{2 3}

(defn mapset
  "Receives a collection and parse it to set"
  [original-func original-coll]
  (loop [func original-func
         coll original-coll
         vec []]
    (if (empty? coll) 
      (into (sorted-set) vec)
      (recur func (rest coll) (conj vec (func (first coll)))))))

(def mapset-value (mapset inc [1 1 2 2]))
(println mapset-value)
(println "Is set?" (set? mapset-value))

(println (mapset inc [1 2 2 3 7 3 8]))