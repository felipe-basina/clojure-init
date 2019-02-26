; For create a list we should provide a quote before parentheses: '([content])
(println "Creating a list w/o function" '(1 "two" "3" 4.0 "five"))

(println "Creating a list with function list" (list 1 2 3 "four" "five" 6))

(def odd-numbers [1 3 5 7 9])
(println "Adding values from vector to list" (list 0 odd-numbers "two" "four" 6))