(ns clj-lab.apresentacao)

;;; sintaxe (funcao parametros...)

(println "Hello World")
(str "Hello World")

(+ 1 2 3 4)

(str "1" 1)

(first [1 2 3 4])

(rest [1 2 3 4])

(def vetor [1 2 3 4])
(first vetor)
(rest vetor)

;;; estrutura de dados

(def minha-lista '(1 2 3 4))
(list? minha-lista)
(first minha-lista)
(second minha-lista)

(let [l minha-lista
      lista-alterada (cons 7 l)]
  (do
    (println l)
    (println lista-alterada)
    (println minha-lista)
    (println l)))

(def minha-lista2 (list 1 2 3 4))
(list? minha-lista2)

(def meu-set #{1 2 3 4})
(set? meu-set)

(def meu-mapa {"chave" "valor"
               "chave2" "valor2"})
(map? meu-mapa)
(get meu-mapa "chave")
(keys meu-mapa)
(vals meu-mapa)

;;; funções

(defn minha-funcao
  []
  "Hello World")
(minha-funcao)

(def minha-f2 (fn []
                "Hello World"))
(minha-f2)

(def minha-f3 #(str "Hello World"))
(minha-f3)

;;; map / filter / reduce
(def primeiros-100-int (range 1 101))
(count primeiros-100-int)

(map (fn [x]
       (* x 2))
     primeiros-100-int)

(defn dobra-int [x]
  (* x 2))

(map dobra-int
     primeiros-100-int)

(map #(* % 2)
     primeiros-100-int)

(filter (fn [x]
          (= 0 (mod x 2)))
        primeiros-100-int)

(filter even? primeiros-100-int)

(reduce + primeiros-100-int)
(reduce str ["FELIPE" " BATISTA" " SIMÃO"])


;;; interação com java
(let [d (java.util.Date.)
      sdf (java.text.SimpleDateFormat. "dd-MM-yyyy")]
  (do
    (println d)
    (println (.format sdf d))
    (.getTime d)))


;;; closure
(defn incrementa-em-?
  [x]
  (fn [y]
    (+ x y)))

(let [inc-5 (incrementa-em-? 5)]
  (inc-5 10))

((fn [y]
   (+ 5 y)) 10)

;;; recursão

(let [v (range 1 11)]
  (loop [col v
         soma 0]
    (if (empty? col)
      soma
      (recur
        (rest col)
        (+ soma (first col))))))