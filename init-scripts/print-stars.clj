(defn stars [total]
  (loop [index 0
         stars ""]
    (if (>= index total) stars
        (recur (inc index)
               (str stars "*")))))

(defn create-stars [total]
  (loop [index 1]
    (if (<= index total) (do 
                           (println (stars index))
                           (recur (inc index))))))

(create-stars 10)
(create-stars 100)

