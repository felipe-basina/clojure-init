(require '[clojure.string :as s])

(defn split-string [string]
  (s/split string #""))

(defn half-total-characters [string]
  (/ (count string) 2))

(defn odd-number-of-characters? [string]
  (let [total-characters (count string)
        total-characters (rem total-characters 2)]
    (> total-characters 0)))

(defn anagram [s]
  (if (odd-number-of-characters? s) -1
      (let [half (half-total-characters s)
            first-part (subs s 0 half)
            parts (split-string first-part)
            second-part (subs s half)]
        ;(println first-part second-part)
        (loop [parts parts
               total 0]
          (if (empty? parts) total
              (let [includes? (s/includes? second-part (first parts))]
                (if (not includes?) (recur (rest parts)
                                     (inc total))
                    (recur (rest parts)
                           total))))))))

(println (anagram "aaabbb"))
(println (anagram "ab"))
(println (anagram "abc"))
(println (anagram "mnop"))
(println (anagram "xyyx"))
(println (anagram "xaxbbbxx"))
