(require '[clojure.string :as str])

(defn convert-and-format [number]
  (str/replace (format "%.6f" number) #"," "."))

(defn negative [number]
  (if (< number 0) 1
      0))

(defn positive [number]
  (if (> number 0) 1
      0))

(defn zeros [number]
  (if (= number 0) 1
      0))

(defn count-by-type [function-type numbers]
  (reduce + (map function-type numbers)))

(defn calculate-ratio [function-type numbers]
  (convert-and-format (float (/ (count-by-type function-type numbers) (count numbers)))))

(defn plusMinus [arr]
  (println (calculate-ratio positive arr))
  (println (calculate-ratio negative arr))
  (println (calculate-ratio zeros arr)))

(plusMinus [1 1 0 -1 -1])
(plusMinus [-4 -3 -9 0 4 1])