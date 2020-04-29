(require '[clojure.string :as str])

(defn is-noon? [s]
  (let [hour-system (subs s 8 10)]
    (if (= "PM" hour-system) true
        false)))

(defn timeConversion [s]
  (let [is-noon? (is-noon? s)
        separated-time-values (str/split (subs s 0 8) #":")
        hour (Integer/parseInt (nth separated-time-values 0))
        hour-time (if (= is-noon? true) (if (= hour 12) hour
                                            (+ hour 12))
                      (if (= hour 12) 0
                          hour))]
    (str (if (< hour-time 10) (str "0" hour-time)
             hour-time) ":" (nth separated-time-values 1) ":" (nth separated-time-values 2))))

(println (timeConversion "07:05:45PM"))
(println (timeConversion "12:52:08PM"))
(println (timeConversion "12:40:22AM"))