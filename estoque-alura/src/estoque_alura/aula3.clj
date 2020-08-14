(ns estoque-alura.aula3)

(defn aplica-desconto? [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))
    valor-bruto))

(defn testes-valor-desconto []
  (println (valor-descontado 1000))
  (println (valor-descontado 100)))