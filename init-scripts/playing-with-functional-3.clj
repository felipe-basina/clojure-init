(def dracula {:title "Dracula"
              :author "Stoker"
              :price 1.99
              :genre :horror})
            
(defn cheapy? [book]
    (when (<= (:price book) 9.99) 
        book))

(defn pricey? [book]
    (when (> (:price book) 9.99) 
        book))

(defn horror? [book]
    (when (= (:genre book) :horror)
        book))

(defn adventure? [book]
    (when (= (:genre book) :adventure)
        book))

(defn both? [first-predicate-f
             second-predicate-f
             book]
    (when (and (first-predicate-f book) 
               (second-predicate-f book))
        book))

(println "cheapy & horror?" (both? cheapy? horror? dracula))
(println "pricey & adventure?" (both? pricey? adventure? dracula))
