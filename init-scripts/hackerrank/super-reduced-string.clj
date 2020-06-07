(require '[clojure.string :as s])

(defn split-string [string]
  (s/split string #""))

(defn same-letter? [splitted]
  (= (first splitted) (second splitted)))

(defn slice-in-2 [string]
  (try
    (subs string 0 2)
    (catch Exception e (subs string 0 1))))

(defn check-reduced-string [reduced]
  (if (empty? reduced) "Empty String"
      (let [sliced-str (slice-in-2 reduced)
            splitted (split-string sliced-str)]
        (if (= (count splitted) 2)
          (if (same-letter? splitted) "Empty String"
              reduced)
          reduced))))

(defn superReducedString [string]
  (loop [string string
         reduced-string ""]
    (if (empty? string) (check-reduced-string reduced-string)
      (let [sliced-str (slice-in-2 string)
          splitted (split-string sliced-str)]
      (if (= (count splitted) 2)
        (if (same-letter? splitted)
          (recur (subs string 2 (count string))
                 reduced-string)
          (recur (subs string 1 (count string))
                 (str reduced-string (first splitted))))
        (recur (subs string 1 (count string))
               (str reduced-string (first splitted))))))))

(println (superReducedString "aaabccddd"))
(println (superReducedString "aa"))
(println (superReducedString "baab"))