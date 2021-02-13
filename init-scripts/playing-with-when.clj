(defn print-message[preferred-customer]
    (when preferred-customer
        (println "Hello returning customer!" preferred-customer)
        (println "Welcome back to Blotts Books!" preferred-customer)))

(println "Print message for preferred customer" (print-message true))
(println "Print message for regurar customer" (print-message false))