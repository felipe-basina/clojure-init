(defn multiple-of [number multiple]
  (= 0 (rem number multiple)))

(defn multiple-of-three [number]
    (multiple-of number 3))

(defn multiple-of-five [number]
  (multiple-of number 5))

(defn multiple-of-three-and-five [number]
  (and (multiple-of-three number)
       (multiple-of-five number)))

(defn print-value [number]
  (cond
    (multiple-of-three-and-five number) "FizzBuzz"
    (multiple-of-three number) "Fizz"
    (multiple-of-five number) "Buzz"
    :else number))

(defn less-than-equal? [number max]
  (<= number max))

(loop [number 1]
  (when (less-than-equal? number 100)
    (println (print-value number))
    (recur (inc number))))