(defn update-min-score? [new-score current-min-score]
  (if (= current-min-score 0) new-score
    (< new-score current-min-score)))

(defn update-min-score [score current-min-score score-map]
  (if (update-min-score? score current-min-score)
    (let [current-total-score (:total-min-score score-map)]
      (assoc score-map :min-score score :total-min-score (inc current-total-score)))
    score-map))

(defn update-max-score? [new-score current-max-score]
  (> new-score current-max-score))

(defn update-max-score [score current-max-score score-map]
  (if (update-max-score? score current-max-score) 
    (let [current-total-score (:total-max-score score-map)]
      (assoc score-map :max-score score :total-max-score (inc current-total-score)))
    score-map))

(defn update-score-map [score score-map]
  (let [max-score (:max-score score-map)
        min-score (:min-score score-map)
        score-map (update-max-score score max-score score-map)
        score-map (update-min-score score min-score score-map)]
    score-map))

(defn breakingRecords [scores]
    (loop [scores scores
           score-map {:max-score 0 :total-max-score -1 :min-score 0 :total-min-score -1}]
      (println "score-map" score-map)
      (if (empty? scores) [(:total-max-score score-map) (:total-min-score score-map)]
          (recur (rest scores)
                 (update-score-map (first scores) score-map)))))

(println (breakingRecords [10 5 20 20 4 5 2 25 1]))
(println (breakingRecords [3 4 21 36 10 28 35 5 24 42]))