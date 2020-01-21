;; Reverse a string
;; For example: input: "cool" output: "looc"
(require '[clojure.string :as str])

(defn reverse-string [str-vector reversed size]
    (if (= size 0) reversed
        (do
            ;(println "size" size "reversed" reversed)
            (reverse-string str-vector (str reversed (nth str-vector (dec size))) (dec size)))))

(defn split-string [string]
    (str/split string #""))

(def some-words ["felipe" "cool" "socorram me subi no onibus em marrocos"])

(defn reverse-now []
    (loop [index 0]
        (when (< index (count some-words))
            (println "Reversing:" (nth some-words index) 
                "::" (reverse-string (split-string (nth some-words index)) "" (count (split-string (nth some-words index)))))
            (recur (+ index 1)))))

(reverse-now)