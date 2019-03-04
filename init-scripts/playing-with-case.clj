; The last statement, the default one, is optional but
; if none of the other statement were evaluate to true
; it will generate an error
(defn customer-greeting [status]
    (case status
        :gold       "Welcome, welcome, welcome back!!!"
        :preferred  "Welcome back!"
                    "Welcome to Blotts Books"))

(println "Greeting GOLD customer" (customer-greeting :gold))
(println "Greeting PREFERRED customer" (customer-greeting :preferred))
(println "Greeting NEW customer" (customer-greeting :new))