(defn dispatch-book-format [book]
    (cond
        (vector? book) :vector-book
        (contains? book :title) :standard-map
        (contains? book :book) :alternative-map))

(defmulti normalize-book dispatch-book-format)

(defmethod normalize-book :vector-book [book]
    {:title (first book) :author (second book)})

(defmethod normalize-book :standard-map [book]
    book)

(defmethod normalize-book :alternative-map [book]
    {:title (:book book) :author (:by book)})

(println "Returns standard:" 
    (normalize-book {:title "War and Peace" :author "Tolstoy"}))
(println "Returns from alternative-map:" 
    (normalize-book {:book "Emma" :by "Austen"}))
(println "Returns from vector:" 
    (normalize-book ["1984" "Orwell"]))