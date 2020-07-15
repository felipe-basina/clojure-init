(require '[clojure.string :as s])

(defn same-character? [char]
  (fn [char-for-compare]
    (if (= char-for-compare char) 1 0)))

(defn count-occurrencies [char s]
  (reduce + (map (same-character? char) (s/split s #""))))

(defn add-to-map [char-map char total]
  (if (not (contains? char-map char)) (assoc char-map char total)
           char-map))

(defn map-of-characters [s]
  (loop [str-vec (vec (s/split s #""))
        char-map {}]
    (if (empty? str-vec) char-map
        (let [char (first str-vec)
              total-of-occurrencies (count-occurrencies char s)]
          (recur (rest str-vec)
                 (add-to-map char-map char total-of-occurrencies))))))

(println (map-of-characters "anagrama"))
