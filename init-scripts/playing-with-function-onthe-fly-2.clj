(def dracula {:title "Dracula"
              :author "Stoker"
              :price 1.99
              :genre :horror})

(def possession {:title "Possession"
              :author "Unknown author"
              :price 5.78
              :genre :horror})

(defn cheap? [book]
    (when (<= (:price book) 9.99) 
        book))

(defn horror? [book]
    (when (= (:genre book) :horror)
        book))

(defn both-f [predicate-f-1 predicate-f-2]
    (fn [book]
        (when (and (predicate-f-1 book) (predicate-f-2 book))
            book)))

(def cheap-horror? (both-f cheap? horror?))

(def cheap-horror-possession?
    (both-f cheap-horror?
        (fn [book] (= (:title book) "Possession"))))

(println "cheap-horror for dracula?" (cheap-horror? dracula))
(println "cheap-horror-possession for dracula?" (cheap-horror-possession? dracula))
(println "cheap-horror-possession for possession?" (cheap-horror-possession? possession))