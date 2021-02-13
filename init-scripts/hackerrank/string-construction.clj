(require '[clojure.string :as s])

(defn split-string [string]
  (s/split string #""))

(defn includes-char? [string char]
  (s/includes? string char))

(defn stringConstruction [s]
  (let [splited-string (split-string s)]
    (loop [splited-string splited-string
           new-string ""
           min-cost 0]
      (if (empty? splited-string) min-cost
          (let [first-char (first splited-string)
                already-in-new-string? (includes-char? new-string first-char)]
            (if already-in-new-string? 
              (recur (rest splited-string)
                     new-string
                     min-cost)
                (recur (rest splited-string)
                       (str new-string first-char)
                       (inc min-cost))))))))

(println (stringConstruction "abcd"))
(println (stringConstruction "abab"))
(println (stringConstruction "abcabc"))