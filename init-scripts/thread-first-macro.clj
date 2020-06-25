(def person {:name "Socrates" :age 39})

; Utiliza o parâmetro 'person' em cada uma das seguintes chamadas; o retorno de cada função é repassado como parâmetro para a próxima função
(println (-> person
             (assoc :hair-color :gray)
             (update :age inc)))

(println (-> person
             (assoc ,,, :hair-color :black-gray)
             (update ,,, :age inc)))