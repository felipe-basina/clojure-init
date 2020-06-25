; Realiza a soma dos quadrados de números ímpares menores que 10
; O valor do parâmetro é adicionado como ÚLTIMO PARÂMETRO de cada função
(println (->> (range 10)
              (filter odd?)
              (map #(* % %))
              (reduce +)))

(println (->> (range 10)
              (filter odd? ,,,)
              (map #(* % %) ,,,)
              (reduce + ,,,)))

; Equivalente à seguinte chamada:
(println (reduce + (map #(* % %) (filter odd? (range 10)))))