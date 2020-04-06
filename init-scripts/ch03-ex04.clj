;; Write a function, mapset, that works like map except the return value is a set
;; (mapset inc [1 1 2 2])
;;  => #{2 3}

(defn apply-func-to-collection [func vec coll]
  (if (empty? coll) vec
      (apply-func-to-collection func 
                                (conj vec (func (first coll))) 
                                (rest coll))))

(defn mapset [func coll]
  ;; Receives a collection and parse it to set
  (into (sorted-set) (apply-func-to-collection func [] coll)))

(def mapset-value (mapset inc [1 1 2 2]))
(println mapset-value)
(println "Is set?" (set? mapset-value))