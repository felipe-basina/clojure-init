(defn left-stars [total]
  (loop [index 0
         stars ""]
    (if (>= index total) stars
        (recur (inc index)
               (str stars "*")))))

(defn left-space [total]
  (loop [index 0
         stars " "]
    (if (>= index total) stars
        (recur (inc index)
               (str stars " ")))))

(defn get-left-stars [total max]
  (let [left-spaces (left-space (- max total))
        left-stars (left-stars total)]
    (str left-spaces left-stars)))

(defn right-stars [total]
  (loop [index 0
         stars ""]
    (if (>= index total) stars
        (recur (inc index)
               (str stars "*")))))


(defn create-pine-tree [total]
  (loop [index 1]
    (if (<= index total) (do
                           (let [right-stars (right-stars index)
                                 left-stars (get-left-stars index total)]
                             (println (str left-stars right-stars)))
                           (recur (inc index))))))

(defn create-left-stars [total]
  (loop [index 1]
    (if (<= index total) (do
                           (println (get-left-stars index total))
                           (recur (inc index))))))

(defn create-stars [total func]
  (loop [index 1]
    (if (<= index total) (do
                           (println (func index))
                           (recur (inc index))))))

(create-left-stars 10)
(create-stars 10 right-stars)
(create-left-stars 100)
(create-stars 100 right-stars)
(create-pine-tree 25)