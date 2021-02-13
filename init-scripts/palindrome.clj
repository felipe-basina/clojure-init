(require '[clojure.string :as s])

(defn split-string [string]
  (s/split string #""))

(defn same-char? [char1 char2]
  ;(println "char1" char1 "char2" char2)
  (= char1 char2))

(defn next-indexes? [init-index last-index]
  ;(println "init-index" init-index "last-index" last-index)
  (> (- last-index init-index) 1))

(defn palindrome? [string]
  (let [total-chars (count string)
        splited (split-string string)]
    (loop [init-index 0
           last-index (dec total-chars)]
      (let [init-char (get splited init-index)
            last-char (get splited last-index)]
        (if (same-char? init-char last-char) 
          (if (next-indexes? init-index last-index) 
            (recur (inc init-index)
                   (dec last-index))
            true)
          false)))))

(println (palindrome? "abcba"))
(println (palindrome? "abba"))
(println (palindrome? "abc"))
(println (palindrome? "socorrammesubinoonibusemmarrocos"))
(println (palindrome? "romametemamor"))
(println (palindrome? "amalanadanalama"))
(println (palindrome? "anotaramadatadamaratona"))
