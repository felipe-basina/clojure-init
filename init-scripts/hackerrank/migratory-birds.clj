(defn is-new-min-occurrence? [current-min new]
  (let [current-id (nth current-min 0)
        current-occurrences (nth current-min 1)
        new-id (nth new 0)
        new-occurrences (nth new 1)]
    (cond
      (> new-occurrences current-occurrences) true
      (and (= new-occurrences current-occurrences)
           (< new-id current-id)) true
      :else false)))

(defn get-most-common-bird-smallest-id [birds-map]
  (loop [birds-map birds-map
         min-occurrence []]
    (if (empty? birds-map) (nth min-occurrence 0)
        (let [bird-type (first birds-map)]
          (if (empty? min-occurrence) (recur (rest birds-map) (conj [] (nth bird-type 0) (nth bird-type 1)))
              (if (is-new-min-occurrence? min-occurrence bird-type)
                (recur (rest birds-map) (conj [] (nth bird-type 0) (nth bird-type 1)))
                (recur (rest birds-map) min-occurrence)))))))

(defn create-birds-map [birds]
  (loop [all-birds birds
         birds-map {}]
    (if (empty? all-birds) birds-map
        (let [bird-type (first all-birds)]
          (if (contains? birds-map bird-type)
            (recur (rest all-birds)
                   (assoc birds-map bird-type (inc (birds-map bird-type))))
            (recur (rest all-birds)
                   (assoc birds-map bird-type 1)))))))

(defn migratoryBirds [birds]
  (let [birds-map (create-birds-map birds)]
    (get-most-common-bird-smallest-id birds-map)))

(println (migratoryBirds [1 4 4 4 5 3]))
(println (migratoryBirds [1 2 3 4 5 4 3 2 1 3 4]))