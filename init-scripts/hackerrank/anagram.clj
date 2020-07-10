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

(defn update-value-from-map [character map-to-update key-reference func]
  (let [total (get-in map-to-update [key-reference character])]
    (if total (update-in map-to-update [key-reference character] func)
        map-to-update)))

(defn update-map [character map-to-update key-reference key-sentinel]
  (let [total (get-in map-to-update [key-sentinel character])]
    (println "total" total "character" character "map-to-update" map-to-update)
    (if total (update-value-from-map character map-to-update key-reference dec)
        (assoc-in map-to-update [key-reference character] (inc (get-in map-to-update [key-reference character] 0))))))

(defn anagram [s]
  (if (odd-number-of-characters? s) -1
      (let [str1 (split-string (subs s 0 (half-total-characters s)))
            str2 (split-string (subs s (half-total-characters s)))]
        (loop [str1 str1
               str2 str2
               map1 {"1" {} "2" {}}]
          (if (empty? str1) (count-values-from-map map1)
              (let [map1 (update-map (first str1) map1 "1" "2")
                    map1 (update-map (first str2) map1 "2" "1")]
                ;(println "map1" map1)
                (recur (rest str1)
                       (rest str2)
                       map1)))))))

;(println (anagram "aaabbb"))
;(println (anagram "ab"))
;(println (anagram "abc"))
;(println (anagram "mnop"))
(println (anagram "xyyx"))
