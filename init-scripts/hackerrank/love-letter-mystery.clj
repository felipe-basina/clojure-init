(require '[clojure.string :as s])

(defn letter-to-int-char [letter]
  (int (apply char letter)))

(defn split-string [string]
  (s/split string #""))

(defn same-char? [char1 char2]
  (= char1 char2))

(defn same-index? [init-index last-index]
  (= init-index last-index))

(defn is-init-index-greater? [init-index last-index]
  (> init-index last-index))

(defn get-total-operations-to-reduce-letter [init-char last-char]
  (let [int-init-char (letter-to-int-char init-char)
        int-last-char (letter-to-int-char last-char)
        char-to-reduce (if (> int-last-char int-init-char) int-last-char int-init-char)
        char-to-compare (if (> int-last-char int-init-char) int-init-char int-last-char)]
    (loop [char-to-reduce char-to-reduce
           total-operations 0]
      (if (= char-to-compare char-to-reduce) total-operations
          (recur (dec char-to-reduce)
                 (inc total-operations))))))

(defn theLoveLetterMystery [string]
  (let [total-chars (count string)
        splited (split-string string)]
    (loop [init-index 0
           last-index (dec total-chars)
           total-operations 0]
      (if (or (same-index? init-index last-index)
              (is-init-index-greater? init-index last-index)) total-operations 
          (let [init-char (get splited init-index)
                last-char (get splited last-index)]
            (if (same-char? init-char last-char) 
              (recur (inc init-index)
                     (dec last-index)
                     total-operations)
                (recur (inc init-index)
                       (dec last-index)
                       (+ total-operations 
                          (get-total-operations-to-reduce-letter init-char last-char)))))))))

(println (theLoveLetterMystery "abc"))
(println (theLoveLetterMystery "abcba"))
(println (theLoveLetterMystery "abcd"))
(println (theLoveLetterMystery "cba"))