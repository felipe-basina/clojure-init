(def clouds [0 0 1 0 0 1 0])
;;(def clouds [0 0 0 0 1 0])
;;(def clouds [0 0 0 1 0 0])

(defn jumping-on-clouds [clouds]
  (loop [index 0
         current (nth clouds index)
         total 0]
    (if (or (= (- (count clouds) 1) index)
            (> (+ index 1) (count clouds))
            (> (+ index 2) (count clouds))) total
        (let [next (if (< (+ index 1) (count clouds)) (nth clouds (+ index 1))
                       0)
              next-next (if (< (+ index 2) (count clouds)) (nth clouds (+ index 2))
                            0)
              reach-end? (if (< (+ index 2) (count clouds)) false
                             true)]
          (println "total-elements" (count clouds)
                   "index" index
                   "current" current
                   "next" next
                   "next-next" next-next
                   "total" total)
          (recur (if (= current next-next) (+ index 2)
                     (inc index))
                 (if (and (= current next-next) (not reach-end?)) (nth clouds (+ index 2))
                     (nth clouds (inc index)))
                 (if (or (= current next) (= current next-next)) (inc total)
                     total))))))

(println (jumping-on-clouds clouds))