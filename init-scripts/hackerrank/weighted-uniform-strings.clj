(require '[clojure.string :as s])

(def alphabet ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])

(defn split-string [string]
  (s/split string #""))

(defn character-weight [character]
  (inc (.indexOf alphabet character)))

(defn character-existing-weights [current-character previous-character-map]
  (let [total (previous-character-map current-character)]
    (if total total 0)))

(defn remove-character [character previous-character-map]
  (dissoc previous-character-map character))

(defn add-character [character weight previous-character-map]
  (assoc previous-character-map character weight))

(defn find-value [value]
  (fn [value-to-find]
    (= value-to-find value)))

(defn value-exists? [value-to-find queries]
  (let [value-found (filterv (find-value value-to-find) queries)]
    (if (empty? value-found) "NO" "YES")))

(defn same-query? [current-value query]
  (= current-value query))

(defn find-by-query [string-vector query]
  (loop [string-vec string-vector
         previous-character {}]
    (if (empty? string-vec) "No"
        (let [character (first string-vec)
              current-character-weight (character-weight character)
              character-weights (character-existing-weights character previous-character)]
          (if (or (same-query? current-character-weight query)
                  (same-query? (+ current-character-weight character-weights) query)) "Yes"
            (recur (rest string-vec)
                   (let [previous-character (add-character character (+ current-character-weight character-weights) {})]
                     previous-character)))))))

(defn weightedUniformStrings [s queries]
  (let [string-vec (split-string s)]
    (loop [queries queries
           result []]
      (if (empty? queries) result
          (recur (rest queries)
                 (conj result (find-by-query string-vec (first queries))))))))

(println (weightedUniformStrings "abccddde" [1 3 12 5 9 10]))
(println (weightedUniformStrings "aaabbbbcccddd" [9 7 8 12 5]))
