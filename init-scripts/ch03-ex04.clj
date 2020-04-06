;; Write a function, mapset, that works like map except the return value is a set
;; (mapset inc [1 1 2 2])
;;  => #{2 3}

(defn apply-func-to-collection [func coll vec]
  (if (empty? coll) vec
      (apply-func-to-collection func 
                                (rest coll)
                                (conj vec (func (first coll))))))

(defn mapset
  "Receives a collection and parse it to set"
  [func coll]
  (into (sorted-set) (apply-func-to-collection func coll [])))

(def mapset-value (mapset inc [1 1 2 2]))
(println mapset-value)
(println "Is set?" (set? mapset-value))