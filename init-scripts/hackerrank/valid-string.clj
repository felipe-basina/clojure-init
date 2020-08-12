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

(defn same-number-of-ocurrencies? [total-set]
  (let [total-elements (count  total-set)]
    (or (= total-elements 1)
        (is-valid-when-remove-one-letter? total-set))))

(defn isValid [word]
  (let [map-of-letters (map-of-letters word)
        total-set (total-set map-of-letters)]
    (println map-of-letters "\n" total-set)
    (if (same-number-of-ocurrencies? total-set) "YES" "NO")))

(println (isValid "aabbcd"))