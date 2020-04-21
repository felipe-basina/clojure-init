(defn jumping-on-clouds [clouds]
  (let [total-elements (count clouds)]
      (loop [index 0
             total 0]
        (if (or (= (- total-elements 1) index)
                (> (+ index 1) total-elements)
                (> (+ index 2) total-elements)) total
            (let [current (nth clouds index)
                  next (if (< (+ index 1) total-elements) (nth clouds (+ index 1))
                           0)
                  next-next (if (< (+ index 2) total-elements) (nth clouds (+ index 2))
                                0)]
              (recur (if (= current next-next) (+ index 2)
                         (inc index))
                     (if (or (= current next) (= current next-next)) (inc total)
                         total)))))))

(println (jumping-on-clouds [0 0 1 0 0 1 0]))
(println (jumping-on-clouds [0 0 0 0 1 0]))
(println (jumping-on-clouds [0 0 0 1 0 0]))