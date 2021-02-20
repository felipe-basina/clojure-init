(def items ["jd" "Joe Doe" "Los Bagos"])

; Destructuring vector items to symbols
(println (let [[alias name city] items]
              (= alias (nth items 0))
              (= name (nth items 1))
              (= city (nth items 2))))
