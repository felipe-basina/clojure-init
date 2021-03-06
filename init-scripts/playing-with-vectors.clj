; Creating a vector from vector function
(println "Creating vector with vector function"(vector "Emma" "Coma" "War and Peace"))

; Setting variable with vector value
(def years-book [1491 "April 1865" "1984" "2001"])

(println "Vector" years-book)

; Get total of elements
(println "Total of elements" (count years-book))

; Get first element
(println "First element" (first years-book))

; Get all elements but first
; Response will be a Collection and not vector
(println "All but first" (rest years-book))

; Get at specific position with nth function
(println "Get value at index 2 with nth function" (nth years-book 2))

; Get at specific indexed position
(println "Get value indexed at 2" (years-book 2))