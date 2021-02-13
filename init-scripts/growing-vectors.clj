(def novels ["Emma" "Coma" "War and Peace"])
(println "Novel's vector" novels)

; As vector immutable we can add elements to it by creating a new one
; and providing new values with function conj - conjunction
(println "Add element to an existing vector by creating a new one" 
  (conj novels "Carrie"))

; To put new element as the first of the collection we can
; use function cons - construction. Instead of returning a vector,
; it returns a collection
(println "Put new value as first element" (cons "Carrie" novels))