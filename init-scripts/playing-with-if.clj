(defn print-name [name]
    ; str function concatenates string values
    (if name (str "Hello there, " name) "No name at all"))

(println "First call" (print-name "Felipe"))

; In Clojure everything but nil and false are evaluate
; to true
(println "Second call" (print-name nil))
(println "Third call" (print-name false))