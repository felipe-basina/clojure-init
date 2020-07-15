(defn half-total-characters [string]
  (/ (count string) 2))

(defn odd-number-of-characters? [string]
  (let [total-characters (count string)
        total-characters (rem total-characters 2)]
    (> total-characters 0)))

(defn convert-to-vec [str-list]
  (vec (map str str-list)))

(defn anagram [s]
  (if (odd-number-of-characters? s) -1
      (let [half (half-total-characters s)
            first-part (subs s 0 half)
            f-vec (convert-to-vec (sort first-part))
            second-part (subs s half)
            s-vec (convert-to-vec (sort second-part))]
        (println f-vec)
        (println s-vec)
        (loop [f-vec f-vec
               s-vec s-vec
               total 0]
          (if (empty? f-vec) total
              (let [same? (= (first f-vec) (first s-vec))]
                (if (not same?) (recur (rest f-vec)
                                       (rest s-vec)
                                       (inc total))
                    (recur (rest f-vec)
                           (rest s-vec)
                           total))))))))

;(println (anagram "aaabbb"))
;(println (anagram "ab"))
;(println (anagram "abc"))
;(println (anagram "mnop"))
;(println (anagram "xyyx"))
;(println (anagram "xaxbbbxx"))

;(println (anagram "asdfjoieufoa"))
;(println (anagram "fdhlvosfpafhalll"))
;(println (anagram "mvdalvkiopaufl"))

(println (anagram "hhpddlnnsjfoyxpciioigvjqzfbpllssuj"))
