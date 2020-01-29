(require '[clojure.string :as str])

(defn get-total [total]
    (if (= total 1) ""
        total))

(defn compress [string compressed total first-letter]
    (cond
        (= (count string) 0) (str compressed (get-total total) first-letter)
        (= (first string) first-letter) (compress (rest string) compressed (inc total) (first string))
        (not (= (first string) first-letter)) (compress (rest string) (str compressed (get-total total) first-letter) 1 (first string))
        :else ""))

(defn run-compress [original]
    (let [string (#(str/split %1 #"") original)
            first-letter (first string)
            remaining (rest string)]
        (compress remaining "" 1 first-letter)))

(println (run-compress "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB")) ; 12WB12W3B24WB
(println (run-compress "AABCCCDEEEE")) ; 2AB3CD4E