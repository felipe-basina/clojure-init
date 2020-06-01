(defn sumup [arr]
  (reduce + arr))

(defn birthday [s d m]
  (loop [arr s
         collector-arr []
         total 0]
    (if (empty? arr) total
        (let [collector-arr (cons (first arr) collector-arr)]
          (if (= (count collector-arr) m) 
            (let [sumup (sumup collector-arr)
                  new-arr (cons (first arr) [])] 
              (if (= sumup d) (recur (rest arr)
                                     new-arr
                                     (inc total))
                  (recur (rest arr)
                         new-arr
                         total)))
            (recur (rest arr)
                   collector-arr
                   total))))))

(println (birthday [1 2 1 3 2] 3 2))
(println (birthday [1 1 1 1 1 1] 3 2))
(println (birthday [4] 4 1))