(def dracula {:title "Dracula"
              :author "Stoker"
              :price 1.99
              :genre :horror})

(defn run-with-dracula [f]
    (f dracula))

(defn pricey? [book]
    (when (> (:price book) 9.99) 
        book))

(defn horror? [book]
    (when (= (:genre book) :horror)
        book))

(println run-with-dracula pricey?)
(println run-with-dracula horror?)