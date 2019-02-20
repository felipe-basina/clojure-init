; Create a map
(def book {:title "Oliver Twist" :author "Dickens" :published "1838"})

(println "A book" book)

; Use assoc to add info into an existing map
(println "A book updated" (assoc book :page-count "362"))

; Use assoc to update info in an existing map
(println "A book updated" (assoc book :title "War and Peace"))

; Use dissoc to remove info from an existing map
(println "A book updated" (dissoc book :published))