; Creating a list of poems
(def poems '("Iliad" "Odyssey" "Now we are Six"))
(println "List of poems" poems)

(println "List size of poems" (count poems))

(println "List's first element" (first poems))

(println "List's all element but first" (rest poems))

(println "List value at nth (2) index" (nth poems 2))