(defn circularArrayRotation [a k queries]
  (let [elements-total (count a)
        distance-from-origin (rem k elements-total)]
    (loop [queries queries
           array []]
      (if (empty? queries) array
          (let [index (first queries)
                new-index (- index distance-from-origin)
                new-index (if (< new-index 0) (+ new-index elements-total)
                              new-index)]
            (recur (rest queries)
                   (conj array (nth a new-index))))))))

(println (circularArrayRotation [1 2 3] 2 [0 1 2]))