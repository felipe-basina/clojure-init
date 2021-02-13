;; An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself. 
;; For example, 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371

(defn calculate-cube [digit]
    (* digit digit digit))

(defn sum-up-digits [map total]
    (if (= (count map) 0) total
        (do
            ;(println "Total" total "map" map)
            (sum-up-digits (rest map) (+ (calculate-cube (nth map 0)) total)))))

(defn add-digits-into-map [number]
    (map #(Integer/parseInt %) 
        (map str ((comp seq str) number))))

(defn is-three-digits-number? [number]
    (= (count (add-digits-into-map number)) 3))

(defn is-armstrong-number [number]
    (cond 
        (not (is-three-digits-number? number)) false
        :else (= (sum-up-digits (add-digits-into-map number) 0) number)))

;(println (is-armstrong-number 123))
;(println (is-armstrong-number 371))
;(println (is-armstrong-number 1001))

(defn check-all-armstrong-numbers [number]
    (loop [index number]
        (when (> index 0)
            (println "Is" index "Armstrong number?" (is-armstrong-number index))
            (recur (- index 1)))))

(check-all-armstrong-numbers 999)