; Create a set
(def genres #{:sci-fi :romance :mystery})

(println "First set" genres)

; Get value from set
(println "Get value :romance" (:romance genres))
(println "Get unexisting value :pacto" (:pacto genres))