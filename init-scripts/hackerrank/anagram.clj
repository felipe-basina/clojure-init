(require '[clojure.string :as s])

(defn split-string [string]
  (s/split string #""))

(defn half-total-characters [string]
  (/ (count string) 2))

(defn count-values-from-map [the-map]
  (let [total (reduce + (vals the-map))]
    (if (>= total 0) total -1)))

(defn odd-number-of-characters? [string]
  (let [total-characters (count string)
        total-characters (rem total-characters 2)]
    (> total-characters 0)))

(defn update-map [character map-to-update]
  (let [total (map-to-update character)]
    (if total (update map-to-update character dec)
        map-to-update)))

(defn count-characters [character map-to-add map-to-check]
  (let [current-val (map-to-check character 0)]
    (println "character" character "map-to-add" map-to-add "map-to-check" map-to-check)
    (if (> current-val 0) (update-map character map-to-add)
        (assoc map-to-add character (inc (map-to-add character 0))))))

(defn anagram [s]
  (if (odd-number-of-characters? s) -1
      (let [str1 (split-string (subs s 0 (half-total-characters s)))
            str2 (split-string (subs s (half-total-characters s)))]
        (loop [str1 str1
               str2 str2
               map1 {}
               map2 {}]
          (if (empty? str1) (count-values-from-map map1)
              (let [map1 (count-characters (first str1) map1 map2)
                    map2 (count-characters (first str2) map2 map1)]
                (recur (rest str1)
                       (rest str2)
                       map1
                       map2)))))))

;(println (anagram "aaabbb"))
;(println (anagram "ab"))
;(println (anagram "abc"))
;(println (anagram "mnop"))
(println (anagram "xyyx"))
