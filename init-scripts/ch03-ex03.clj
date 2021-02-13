;; Write a function, dec-maker, that works exactly like the function inc-maker except with subtraction:
;; (def dec9 (dec-maker 9))
;; (dec9 10)
;; => 1

(defn dec-maker [dec]
  (fn [number]
    (- number dec)))

(def dec9 (dec-maker 9))
(println (dec9 10))

(def dec10 (dec-maker 10))
(println (dec10 10))