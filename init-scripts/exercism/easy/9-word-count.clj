;; Given a phrase, count the occurrences of each word in that phrase.
;; For example for the input "olly olly in come free"
;; olly: 2
;; in: 1
;; come: 1
;; free: 1
(require '[clojure.string :as str])

(defn split-string [string]
  (str/split string #" "))

(defn count-word [sentence word count]
  (if (empty? sentence) count
      (do
        (if (= (first sentence) word) (count-word (rest sentence) word (inc count))
            (count-word (rest sentence) word count)))))

(defn has-word? [words word]
  (some (partial = word) (sequence words)))

(defn print-total [word total]
  (println (str word ":") total))

(defn check-total [sentence words]
  (if (not (empty? sentence))
      (let [word (first sentence)
            total (count-word sentence word 0)]
        (do
          (if (not (has-word? @words word))
            (do 
              (swap! words conj word)
              (print-total word total)))
          (check-total (rest sentence) words)))))

(def words (atom []))
(check-total (split-string "olly olly in come free") words)
;;(reset! words [])
;;(check-total (split-string "uma pessoa estava a uma quadra de distancia") words)