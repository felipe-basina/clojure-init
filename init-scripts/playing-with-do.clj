; do function is used to group a bunch of expressions
; into a single expression construct
(defn shipping-charge[preferred-customer order-amount]
    (if preferred-customer
        (do (println "Preferred customer, free shipping!") 0.0)
        (do (println "Regular customer, charge them for shipping.")
            (* order-amount 0.10))))

(println "Value to shipping (preferred):" (shipping-charge "Felipe" 100))
(println "Value to shipping (regular):" (shipping-charge false 100))