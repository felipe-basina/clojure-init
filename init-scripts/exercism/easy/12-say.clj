(def MAX 999999999999)
(def MIN 0)

(defn valid? [number]
  (and (>= number MIN)
       (<= number MAX)))

(println (valid? (inc MAX)))
(println (valid? (inc 8888888877)))