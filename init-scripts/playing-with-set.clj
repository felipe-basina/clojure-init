; Create a set
(def genres #{:sci-fi :romance :mystery})
(def authors #{"Dickens" "Austen" "King"})

; Add existing element element into set
(println "Add existing element into set" (conj genres :romance))

; Check if an element exists in set
(println "Contains author Tolken?" (contains? authors "Tolken"))
(println "Contains author King?" (contains? authors "King"))

; Add new element to set
(println "Add 'action' genre" (conj genres :action))

; Remove element from set
(println "Remove 'King' from set" (disj authors "King"))