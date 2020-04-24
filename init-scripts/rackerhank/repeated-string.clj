(require '[clojure.string :as str])

(defn is-a [letter]
  (if (= (str letter) "a") 1
      0))

(defn count-total [string]
  (let [vector (str/split string #"")]
    (reduce + (map is-a vector))))

(defn repeatedString [string size]
  (if (>= (count string) size) (count-total (subs string 0 size))
      (let [total (quot size (count string))
            rest (rem size (count string))
            additional (if (> rest 0) (count-total (subs string 0 rest))
                           0)]
        (+ (* total (count-total string)) additional))))

(println (repeatedString "ababa" 3))
(println (repeatedString "abcac" 10))
(println (repeatedString "aba" 10))
(println (repeatedString "a" 1000000000000))