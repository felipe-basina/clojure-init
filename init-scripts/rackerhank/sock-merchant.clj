(defn exist-element? [value]
  (fn [element]
    (if (= element value) 1
        0)))

(defn count-elements [element itens]
  (reduce + (map (exist-element? element) itens)))

(defn sockMerchant [n ar]
  (loop [colors ar
         total 0
         mapped-color #{}]
    (if (empty? colors) total 
        (let [color (first colors)]
          (recur (rest colors)
                 (if (not (contains? mapped-color color)) (+ total (quot (count-elements color ar) 2))
                     total)
                 (conj mapped-color color))))))

(println (sockMerchant 7 [1 2 1 2 1 3 2]))
(println (sockMerchant 9 [10 20 20 10 10 30 50 10 20]))
(println (sockMerchant 10 [1 1 3 1 2 1 3 3 3 3]))