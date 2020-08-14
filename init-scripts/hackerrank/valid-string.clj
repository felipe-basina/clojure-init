(require '[clojure.string :as s])

(defn find-letter [letter]
  (fn [ref]
    (if (= ref letter) 1 0)))

(defn count-letter [letter word]
  (let [letters (s/split word #"")]
    (reduce + (map (find-letter letter) letters))))

(defn remove-letter [letter word]
  (s/replace word letter ""))

(defn map-of-letters [word]
  (loop [letters (s/split word #"")
         letters-map {}]
    (if (empty? letters) letters-map
        (let [letter (first letters)
              total (count-letter letter word)]
          (recur (rest letters)
                 (assoc letters-map letter total))))))

(defn more-than-one-occurrences [amount]
  (fn [min-val]
    (if (> amount min-val) 1 0)))

(defn more-than-one-occurrences-same-word [map-of-letters]
  (let [vals (vals map-of-letters)
        min-val (apply min vals)]
    (reduce + (map (more-than-one-occurrences min-val) vals))))

(defn total-set [map-of-letters]
  (loop [map-vals (vals map-of-letters)
         total-set #{}]
    (if (empty? map-vals) total-set
        (let [val (first map-vals)]
          (recur (rest map-vals)
                 (conj total-set val))))))

(defn get-module-difference [total-set]
  (let [difference (reduce - total-set)]
    (if (< difference 0) (* -1 difference) difference)))

(defn is-valid-when-remove-one-letter? [total-set]
  (if (> (count total-set) 2) false
      (let [difference (get-module-difference total-set)]
        (if (= difference 1) true false))))

(defn same-number-of-occurrences? [total-set]
  (let [total-elements (count  total-set)]
    (or (= total-elements 1)
        (is-valid-when-remove-one-letter? total-set))))

(defn exists-only-one-candidate? [values min-val]
  (loop [values values
         candidate -1]
    (if (empty? values) true
        (let [val (first values)
              difference (- val min-val)]
          (if (or (> difference 1)
                  (> candidate 0)) false
              (recur (rest values)
                     (if (> candidate 0) candidate difference)))))))

(defn remove-min-elements [values min-val]
  (remove #(= min-val %) values))

(defn isValid [word]
  (let [map-of-letters (map-of-letters word)
        min-val (apply min (vals map-of-letters))
        max-val (apply max (vals map-of-letters))
        total-max (reduce + (map (find-letter max-val) (vals map-of-letters)))
        more-than-one-max? (> total-max 1)
        values (remove-min-elements (vals map-of-letters) min-val)
        total-set (total-set map-of-letters)]
    (println map-of-letters "\n" total-set)
    (if (= (count total-set) 1) "YES"
        (let [difference (- max-val min-val)]
          (if (or more-than-one-max?
                  (> difference 1)) "NO"
            "YES")))))

(println (isValid "aabbcd"))
(println (isValid "aabbccddeefghi"))
(println (isValid "abcdefghhgfedecba"))

;(println (remove-min-elements '(1 2 1 2 3 4) 1))
;(println (exists-only-one-candidate? '(2 3 4) 1)) ; NO
;(println (exists-only-one-candidate? '(3) 1)) ; NO
;(println (exists-only-one-candidate? '(2) 1)) ; YES