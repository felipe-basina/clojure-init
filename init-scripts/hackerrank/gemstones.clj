(require '[clojure.string :as s])

(defn includes-mineral? [mineral rock]
  (s/includes? rock mineral))

(defn gemstone? [mineral rocks]
  ;(println "mineral" mineral "rocks" rocks)
  (loop [rocks rocks
         analyze? true]
    (if (or (empty? rocks)
            (not analyze?)) analyze?
        (if (includes-mineral? mineral (first rocks)) (recur (rest rocks)
                                                                analyze?)
            (recur []
                   false)))))

(defn gemstones [arr]
  (let [first-rock (first arr)
        minerals (s/split first-rock #"")
        arr (rest arr)]
    ;(println "first-rock" first-rock "minerals" minerals "(first minerals)" (first minerals))
    (loop [minerals minerals
           total 0]
      (if (empty? minerals) total
          (let [gemstone? (gemstone? (first minerals) arr)
                total-gemstones (if gemstone? 1 0)]
            (recur (rest minerals)
                   (+ total total-gemstones)))))))

(println (gemstones ["abcdde" "baccd" "eeabg"]))