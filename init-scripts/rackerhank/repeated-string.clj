(defn has-only-a [s]
  (loop [index 0]
    (if (= index (count s)) true
        (if (not (= (str (nth s index)) "a")) false
            (recur (inc index))))))

(defn count-a [s n]
  (if (has-only-a s) n
      (loop [index 0
             total 0]
        (if (or (= index (count s)) (= index n)) total
            (recur (inc index)
                   (if (= (str (nth s index)) "a") (inc total)
                       total))))))

(defn repeatedString [s n]
  (if (or (>= (count s) n) (has-only-a s)) (count-a s n)
      (loop [index 0
             new-string s
             total (count-a s n)]
        (if (= (count new-string) n) total
            (let [inner-index (if (< index (count s)) index
                                  0)
                  new-letter (nth s inner-index)]
              (recur (inc inner-index)
                     (str new-string new-letter)
                     (if (= (str new-letter) "a") (inc total)
                         total)))))))

(println (repeatedString "ababa" 3))
(println (repeatedString "abcac" 10))
(println (repeatedString "aba" 10))
(println (repeatedString "a" 1000000000000))