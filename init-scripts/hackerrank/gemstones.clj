(require '[clojure.string :as s])

(defn includes-mineral? [mineral rock]
  (s/includes? rock mineral))

(defn gemstone? [mineral rocks]
  ;(println "mineral" mineral "rocks" rocks)
  (loop [rocks rocks
         analyze? true]
    (if (or (empty? rocks)
            (not analyze?)) analyze?
        (if (includes-mineral? mineral (first rocks)) 
          (recur (rest rocks)
                 analyze?)
          (recur []
                 false)))))

(defn remove-same-minerals [current-mineral minerals]
  (let [join (reduce str minerals)
        updated-minerals (s/replace join current-mineral "")]
    (println "join" join "updated-minerals" updated-minerals)
    (s/split updated-minerals #"")))

(defn gemstones [arr]
  (let [first-rock (first arr)
        minerals (s/split first-rock #"")
        arr (rest arr)]
    ;(println "first-rock" first-rock "minerals" minerals "(first minerals)" (first minerals))
    (loop [minerals minerals
           total 0]
      (if (empty? minerals) total
          (let [gemstone? (gemstone? (first minerals) arr)
                total-gemstones (if gemstone? (do (println (first minerals)) 1) 0)
                minerals (if gemstone? (remove-same-minerals (first minerals) minerals) (rest minerals))]
            (recur minerals
                   (+ total total-gemstones)))))))

(println (gemstones ["abcdde" "baccd" "eeabg"]))
