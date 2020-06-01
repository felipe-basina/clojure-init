(defn sumup [arr]
  (reduce + arr))

(defn slice-a-vector [arr init-idx end-idx]
  (try 
    (subvec arr init-idx end-idx)
    (catch Exception e 
      [])))

(defn birthday [s d m]
  (loop [arr s total 0]
    (if (empty? arr) total
        (let [partial-vector (slice-a-vector arr 0 m)
              sumup (sumup partial-vector)
              arr-as-vector (vec (rest arr))]
          (if (and (= (count partial-vector) m) (= sumup d)) 
            (recur arr-as-vector (inc total))
            (recur arr-as-vector total))))))

(println (birthday [1 2 1 3 2] 3 2))
(println (birthday [1 1 1 1 1 1] 3 2))
(println (birthday [4] 4 1))
(println (birthday [5 1 4 1 5 4 5 1 3 5 1 1 5 1 4 2 1 1 1 2 5] 15 7))