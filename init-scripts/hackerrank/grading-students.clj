(def ROUND_NUMBER_INIT_VALUE 38)

(defn can-be-rounded? [number]
  (>= number ROUND_NUMBER_INIT_VALUE))

(defn multiple-of-5? [number]
  (= (rem number 5) 0))

(defn find-next-multiple-of-5 [number]
  (loop [number (inc number)]
    (if (multiple-of-5? number) number
        (recur (inc number)))))

(defn calculate-grade [number]
  (if (not (can-be-rounded? number)) number
      (let [multiple-of-5-number (find-next-multiple-of-5 number)
            distance (- multiple-of-5-number number)]
        (if (< distance 3) multiple-of-5-number
            number))))

(defn gradingStudents [grades]
  (loop [grades grades
         final-grades []]
    (if (empty? grades) final-grades
        (recur (rest grades)
               (conj final-grades (calculate-grade (first grades)))))))

(println (gradingStudents [73 67 38 33]))
