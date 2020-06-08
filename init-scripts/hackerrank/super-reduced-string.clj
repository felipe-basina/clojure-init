(require '[clojure.string :as s])

(defn split-string [string]
  (s/split string #""))

(defn same-letter? [splitted]
  (= (first splitted) (second splitted)))

(defn slice-in-2 [string]
  (try
    (subs string 0 2)
    (catch Exception e (subs string 0 1))))

(defn check-reduced-string [reduced-string]
  (if (empty? reduced-string) "Empty String"
      reduced-string))

(defn two-letters? [splitted]
  (= (count splitted) 2))

(defn next-substring [string init]
  (subs string init (count string)))

(defn reduce-string [string reduced-string]
  (loop [string string
         reduced-string reduced-string
         reduced? false]
    (if (empty? string) (if (not reduced?) (check-reduced-string reduced-string)
                            (reduce-string reduced-string ""))
        (let [sliced-str (slice-in-2 string)
              splitted (split-string sliced-str)]
          (if (and (two-letters? splitted)
                   (same-letter? splitted))
              (recur (next-substring string 2)
                     reduced-string
                     true)
            (recur (next-substring string 1)
                   (str reduced-string (first splitted))
                   reduced?))))))

(defn superReducedString [string]
  (reduce-string string ""))

(println (superReducedString "aaabccddd"))
(println (superReducedString "aa"))
(println (superReducedString "baab"))
(println (superReducedString "mwkommokwmxjivkkvijxshscbbcshsgwdyqqydwgzpnlzzlnpzvfeaiiaefvyeqjccjqeymhqhiihqhmhaomkkmoahhddymmyddh"))