(require '[clojure.string :as s])

(def alphabet ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])

(defn split-string [string]
  (s/split string #""))

(defn character-weight [character]
  (inc (.indexOf alphabet character)))

(defn character-existing-weights [current-character previous-character-map]
  (previous-character-map current-character))

(defn remove-character [character previous-character-map]
  (dissoc previous-character-map character))

(defn find-value [value]
  (fn [value-to-find]
    (= value-to-find value)))

(defn exists-value? [value-to-find queries]
  (let [value-found (filterv (find-value value-to-find) queries)]
    (if (empty? value-found) false true)))

(defn weightedUniformStrings [s queries]
  (loop [string-vec (split-string s)
         previous-character {}
         result []]
    (if (empty? string-vec) result
        (let [character (first string-vec)
              character-weights (character-existing-weights character previous-character)]))))
