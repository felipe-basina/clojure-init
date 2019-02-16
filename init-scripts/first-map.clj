; Set a map
(def book-map (hash-map "title" "Oliver Twist" 
                        "author" "Dickens"
                        "published" "1838"))

(println "Map" book-map)

; Get value from a map with get function
(println "Getting value from map with get function: 'title'" (get book-map "title"))

; Get value from a map directly by key
(println "Getting value from map with key 'title'" (book-map "title"))
(println "Getting value from map with key 'author'" (book-map "author"))
(println "Getting value from map with key 'published'" (book-map "published"))
(println "Getting value from map with key 'copyright'" (book-map "copyright"))