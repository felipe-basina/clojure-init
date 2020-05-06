(defn rotate [array times]
  (loop [total 0
         array array]
    (if (= total times) array
        (recur (inc total)
               (vec (cons (last array) (take (dec (count array)) array)))))))

(defn circularArrayRotation [a k queries]
  (let [rotated-array (rotate a k)]
    (loop [queries queries
           array []]
      (if (empty? queries) array
          (let [index (first queries)]
            (recur (rest queries)
                   (conj array (nth rotated-array index))))))))

(println (circularArrayRotation [1 2 3] 2 [0 1 2]))