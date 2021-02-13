; Working with nested if statements
(defn shipping-charge [preferred-customer order-amount]
    (if preferred-customer
        0.0
        (if (< order-amount 50.0)
            5.0
            (if (< order-amount 100.0)
                10.0
                (* 0.1 order-amount)))))

(println "Shipping charge for preferred customer" (shipping-charge true 150.0))
(println "Shipping charge for order amount = 47.22" (shipping-charge false 47.22))
(println "Shipping charge for order amount = 75.94" (shipping-charge false 75.94))
(println "Shipping charge for order amount = 224.45" (shipping-charge false 224.45))