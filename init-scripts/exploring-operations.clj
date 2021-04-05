(defn sum-up-n-first-even-numbers [n]
    (reduce + (take n (filter even? (map #(* % %) (range))))))

(defn- sum-up-even-numbers []
    (fn [n]
        (reduce + (take n (filter even? (map #(* % %) (range)))))))

(defn- sum-up-numbers [sum-fn]
    (fn [n]
        (reduce + (take n (filter sum-fn (map #(* % %) (range)))))))

(defn sum-up-n-numbers [n sum-fn]
    (->> (range)
         (map #(* % %))
         (filter sum-fn)
         (take n)
         (reduce +)))        

(println (sum-up-n-first-even-numbers 10))
(println (let [sum-up (sum-up-even-numbers)]
            (sum-up 10)))
(println (let [sum-up (sum-up-numbers even?)]
            (sum-up 10)))
(println (let [sum-up (sum-up-numbers odd?)]
            (sum-up 10)))
(println (sum-up-n-numbers 10 even?))
(println (sum-up-n-numbers 10 odd?))

(defn print-n-elements [n]
    (loop [elements (range 1 n)]
        (if (not-empty elements)
            (do 
                (println (first elements))
                (recur (rest elements))))))

(println (print-n-elements 100))

(def init (atom 1))

(defn print-n-elements-v2 [n]
    (while (<= @init n)
        (println @init)
        (swap! init inc)))

(println (print-n-elements-v2 100))
