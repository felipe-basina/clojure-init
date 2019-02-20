; Set a map with key as keywords
(def books {:title "Oliver Twist" :author "Dickens" :published "1838"})

(println "Books from map" books)

; Get values from map through its keywords
(println "Get title" (books :title))
(println "Get author" (books :author))
(println "Get published" (books :published))

; Get value from map using keyword as function
(println "Get title from keyword :title as function" (:title books))