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

(defn reduce-string [string reduced-string]
  (loop [string string
         reduced-string reduced-string
         reduced? false]
    (if (empty? string) (if (not reduced?) (check-reduced-string reduced-string)
                            (reduce-string reduced-string ""))
        (let [sliced-str (slice-in-2 string)
              splitted (split-string sliced-str)]
          (println "string" string "reduced-string" reduced-string "sliced-str" sliced-str)
          (if (= (count splitted) 2)
            (if (same-letter? splitted)
              (recur (subs string 2 (count string))
                     reduced-string
                     true)
              (recur (subs string 1 (count string))
                     (str reduced-string (first splitted))
                     reduced?))
            (recur (subs string 1 (count string))
                   (str reduced-string (first splitted))
                   reduced?))))))

(defn superReducedString [string]
  (reduce-string string ""))

(println (superReducedString "aaabccddd"))
(println (superReducedString "aa"))
(println (superReducedString "baab"))
(println (superReducedString "mwkommokwmxjivkkvijxshscbbcshsgwdyqqydwgzpnlzzlnpzvfeaiiaefvyeqjccjqeymhqhiihqhmhaomkkmoahhddymmyddh"))