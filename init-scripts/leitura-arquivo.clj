(require '[clojure.string :as s])

; Caminho completo para o arquivo
(def content (slurp ".../content.txt"))
(def arr (vec (map #(Integer/parseInt %) (s/split (s/trimr content) #" "))))
(println arr)