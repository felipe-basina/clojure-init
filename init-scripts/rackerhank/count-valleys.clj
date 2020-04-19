(def steps "UDDDUDUU")
;;(def steps "DDUUDDUDUUUD")

(defn count-step [current-step total]
  (if (= current-step "U") (inc total)
      (dec total)))

(defn is-going-down? [total-steps current-step]
  (if (and (= total-steps 0) (= current-step "D")) true
      false))

(defn count-valleys [steps]
  (loop [current-step (str (first steps))
         total-steps 0
         total-valleys 0
         steps steps]
    (println "going-down?" (is-going-down? total-steps current-step)
             "total-valleys" total-valleys
             "total-steps" total-steps
             "current-step" current-step
             "steps" steps)
    (if (empty? steps) total-valleys
        (recur (str (first (rest steps)))
               (count-step current-step total-steps)
               (if (is-going-down? total-steps current-step) (inc total-valleys)
                   total-valleys)
               (rest steps)))))

(println (count-valleys steps))