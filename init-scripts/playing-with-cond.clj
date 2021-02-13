; Working with cond function avoid nest
; if statements but it does not provide an 'else' default clause
(defn shipping-charge [preferred-customer order-amount]
    (cond 
        preferred-customer 0.0
        (< order-amount 50.0) 5.0
        (< order-amount 100.0) 10.0
        (>= order-amount 100.0) (* 0.1 order-amount)))

(println "Shipping charge for preferred customer" (shipping-charge true 150.0))
(println "Shipping charge for order amount = 47.22" (shipping-charge false 47.22))
(println "Shipping charge for order amount = 75.94" (shipping-charge false 75.94))
(println "Shipping charge for order amount = 224.45" (shipping-charge false 224.45))

; Alternative: use :else keywords
(defn shipping-charge-v2 [preferred-customer order-amount]
    (cond 
        preferred-customer 0.0
        (< order-amount 50.0) 5.0
        (< order-amount 100.0) 10.0
        :else (* 0.1 order-amount)))

(println "Shipping charge for preferred customer" (shipping-charge-v2 true 150.0))
(println "Shipping charge for order amount = 47.22" (shipping-charge-v2 false 47.22))
(println "Shipping charge for order amount = 75.94" (shipping-charge-v2 false 75.94))
(println "Shipping charge for order amount = 224.45" (shipping-charge-v2 false 224.45))