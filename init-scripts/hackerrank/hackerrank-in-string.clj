(require '[clojure.string :as s])

(def HACKERRANK "hackerrank")

(defn split-str [string]
  (s/split string #""))

(defn count-letter [letter]
  (fn [reference]
    (if (= (str reference) (str letter)) 1
        0)))

(defn count-occurrencies [reference-letter splited-string]
  (reduce + (map (count-letter reference-letter) splited-string)))

(defn hackerrank-letter-map []
  (let [splited (split-str HACKERRANK)]
    (loop [splited splited
           letter-map {}]
      (if (empty? splited) letter-map
          (recur (rest splited)
                 (assoc letter-map (first splited) (count-occurrencies (first splited) (split-str HACKERRANK))))))))

(defn hackerrankInString [string]
  (let [splited (split-str string)
        letter-map (hackerrank-letter-map)]
    (loop [letter-map letter-map]
      (if (empty? letter-map) true
          (let [pair (first letter-map)
                letter (first pair)
                amount (second pair)
                total-occurrencies (count-occurrencies letter splited)]
            (println "pair" pair "letter" letter "amount" amount "total-occurrencies" total-occurrencies)
            (if (>= total-occurrencies amount) (recur (rest letter-map))
                false))))))

;(println (hackerrankInString "hereiamstackerrank"))
;(println (hackerrankInString "hackerworld"))
;(println (hackerrankInString "hhaacckkekraraannk"))
(println (hackerrankInString "rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt"))