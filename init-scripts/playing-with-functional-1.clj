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

(println (cheapy? dracula))
(println (pricey? dracula))

(defn horror? [book]
    (when (= (:genre book) :horror)
        book))

(defn adventure? [book]
    (when (= (:genre book) :adventure)
        book))

(println (horror? dracula))
(println (adventure? dracula))

(defn cheapy-horror? [book]
    (when (and (cheapy? book) (horror? book))
        book))

(defn pricy-adventure? [book]
    (when (and (pricey? book) (adventure? book))
        book))

(println "cheapy-horror" (cheapy-horror? dracula))
(println "pricy-adventure?" (pricy-adventure? dracula))