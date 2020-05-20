(defn dividend [x1 x2]
  (let [diff (- x2 x1)]
    (println "dividend" diff)
    (int diff)))

(defn divider [v1 v2]
  (let [diff (- v1 v2)]
    (println "divider" diff)
    diff))

(defn division [x1 v1 x2 v2]
  (try
    (/ (dividend x1 x2) (divider v1 v2))
    (catch Exception e (int -1))))

(defn reminder [x1 v1 x2 v2]
  (try
    (rem (dividend x1 x2) (divider v1 v2))
    (catch Exception e (int -1))))

(defn kangaroo [x1 v1 x2 v2]
  (let [quotient (division x1 v1 x2 v2)
        reminder (reminder x1 v1 x2 v2)]
    (println "quotient" quotient)
    (if (and (>= quotient 1) (= reminder 0)) "YES"
        "NO")))

(println (kangaroo 2 1 1 2))
(println (kangaroo 0 3 4 2))
(println (kangaroo 0 2 5 3))
(println (kangaroo 23 9867 9814 5861))