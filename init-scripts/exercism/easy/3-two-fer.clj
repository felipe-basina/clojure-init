;; Create a sentence of the form "One for X, one for me."
(defn print-sentence
    ([] (print-sentence "X"))
    ([name] (println "One for" name ", one for me")))

(print-sentence)
(print-sentence "Felipe")