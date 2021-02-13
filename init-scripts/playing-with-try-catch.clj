(def book {:author "Dickens" :editor "Miscellaneous" :genre "Adventure" :book "First book"})

(println "New book:" book)

(defn get-year []
   (def year (.format (java.text.SimpleDateFormat. "yyyy") (new java.util.Date))))
  
(defn publish-book [book]
    (when (not (:title book))
        (throw
            (ex-info "A book needs a title" {:book book})))
    (assoc book :publish (var-get (get-year))))

; Will throw exception
(try
    (publish-book book)
    (catch clojure.lang.ExceptionInfo e (println "Error when publishing book" e)))

; Will not throw exception
(try
    (println "Book published" (publish-book (assoc book :title "A new history begins")))
    (catch clojure.lang.ExceptionInfo e (println "Error when publishing book" e)))