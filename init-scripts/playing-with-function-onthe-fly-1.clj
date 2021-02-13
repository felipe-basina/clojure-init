(def dracula {:title "Dracula"
              :author "Stoker"
              :price 1.99
              :genre :horror})

(defn cheaper-f [max-price]
    (fn [book]
        (when (<= (:price book) max-price)
            book)))

(def real-cheap? (cheaper-f 1.00))
(def kind-of-cheap? (cheaper-f 1.99))
(def marginally-cheap? (cheaper-f 5.99))

(println "real-cheap" (real-cheap? dracula))
(println "kind-of-cheap" (kind-of-cheap? dracula))
(println "marginally-cheap" (marginally-cheap? dracula))