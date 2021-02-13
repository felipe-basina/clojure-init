(defn update-min-score? []
  (fn [new-score current-min-score]
    (or (= current-min-score 0)
        (< new-score current-min-score))))

(defn update-max-score? []
  (fn [new-score current-max-score]
    (or (= current-max-score 0) (> new-score current-max-score))))

(defn update-score [func score current-score score-map keyword-type]
  (let [total (str "total-" keyword-type)]
    (if (func score current-score) 
      (let [current-total-score ((keyword total) score-map)]
        (assoc score-map (keyword (str keyword-type)) score (keyword total) (inc current-total-score)))
      score-map)))

(defn update-score-map [score score-map]
  (let [max-score (:max-score score-map)
        min-score (:min-score score-map)
        score-map (update-score (update-max-score?) score max-score score-map "max-score")
        score-map (update-score (update-min-score?) score min-score score-map "min-score")]
    score-map))

(defn first-is-zero? [scores]
  (= (first scores) 0))

(defn breakingRecords [scores]
    (let [first-is-zero? (first-is-zero? scores)]
      (loop [scores scores
             score-map {:max-score 0 :total-max-score -1 :min-score 0 :total-min-score -1}]
        (if (empty? scores) 
          [(:total-max-score score-map) (if first-is-zero? 0 (:total-min-score score-map))]
            (recur (rest scores)
                   (update-score-map (first scores) score-map))))))

(println (breakingRecords [10 5 20 20 4 5 2 25 1]))
(println (breakingRecords [3 4 21 36 10 28 35 5 24 42]))
(println (breakingRecords [0 9 3 10 2 20]))