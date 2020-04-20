;;(def steps "UDDDUDUU")
(def steps "DDUUDDUDUUUD")

(defn count-valleys [steps]
  (loop [current-step (str (first steps))
         total-steps 0
         total-valleys 0
         steps steps]
    (if (empty? steps) total-valleys
        (recur (str (first (rest steps)))
               (if (= current-step "U") (inc total-steps)
                   (dec total-steps))
               (if (and (= total-steps 0) (= current-step "D")) (inc total-valleys)
                   total-valleys)
               (rest steps)))))

(println (count-valleys steps))