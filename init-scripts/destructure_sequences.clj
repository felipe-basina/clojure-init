(def items ["jd" "Joe Doe" "Los Bagos"])

; Destructuring vector items to symbols
(println "All elements destructured?" (let [[alias name city] items]
              (= alias (nth items 0))
              (= name (nth items 1))
              (= city (nth items 2))))

; When there are no elements to assign a value, the symbol will be nil
(println "Is nil element?" (let [[alias name city country] items]
              (nil? country)))