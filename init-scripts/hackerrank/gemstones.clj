(require '[clojure.string :as s])

(defn includes-mineral? [mineral rock]
  (s/includes? rock mineral))

(defn gemstone? [mineral rocks]
  (loop [rocks rocks
         analyze? true]
    (if (or (empty? rocks)
            (not analyze?)) analyze?
        (if (includes-mineral? mineral (first rocks)) 
          (recur (rest rocks)
                 analyze?)
          (recur []
                 false)))))

(defn to-char []
  (map char (range (int \a) (inc (int \z)))))

(defn gemstones [arr]
  (let [minerals (s/split (apply str (vec (to-char))) #"")]
    (loop [minerals minerals
           total 0]
      (if (empty? minerals) total
          (let [gemstone? (gemstone? (first minerals) arr)
                total-gemstones (if gemstone? (do (println (first minerals)) 1) 0)]
            (recur (rest minerals)
                   (+ total total-gemstones)))))))

(println (gemstones ["abcdde" "baccd" "eeabg"]))
