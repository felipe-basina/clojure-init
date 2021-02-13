(require '[clojure.string :as s])

(def alphabet ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])

(defn split-string [string]
  (s/split string #""))

(defn character-weight [character]
  (inc (.indexOf alphabet character)))

(defn character-existing-weights? [current-character previous-character-map]
  (previous-character-map current-character))

(defn add-vals-to-vector [all-vals vals]
  (loop [vals vals
         all-vals all-vals]
    (if (empty? vals) all-vals
        (recur (rest vals)
               (conj all-vals (first vals))))))

(defn get-all-vals [my-map]
  (loop [vals (vals my-map)
         all-vals []]
    (if (empty? vals) all-vals
        (recur (rest vals)
               (add-vals-to-vector all-vals (first vals))))))

(defn get-existing-weight [weights-map character]
  (last (weights-map character)))

(defn map-characters-weight [string-vector]
  (loop [string-vector string-vector
         weights-map {}]
    (if (empty? string-vector) weights-map
        (let [character (first string-vector)
              current-weight (character-weight character)
              character-existing-weights? (character-existing-weights? character weights-map)]
          (if character-existing-weights?
            (recur (rest string-vector)
                   (assoc weights-map character (conj (get weights-map character) (+ current-weight (get-existing-weight weights-map character)))))
            (recur (rest string-vector)
                   (assoc weights-map character (conj [] current-weight))))))))

(defn exists-weight? [weights query]
  (> (.indexOf weights query) -1))

(defn find-by-query [weights query]
    (if (exists-weight? weights query) "Yes" "No"))

(defn weightedUniformStrings [s queries]
  (let [string-vec (split-string s)
        characters-weight-map (map-characters-weight string-vec)
        weights (get-all-vals characters-weight-map)]
    (loop [queries queries
           result []]
      (if (empty? queries) result
          (recur (rest queries)
                 (conj result (find-by-query weights (first queries))))))))

(println (weightedUniformStrings "abccddde" [1 3 12 5 9 10]))
(println (weightedUniformStrings "aaabbbbcccddd" [9 7 8 12 5]))
