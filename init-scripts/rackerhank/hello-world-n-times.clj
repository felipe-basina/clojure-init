(defn hello_word_n_times [n]
  (when (> n 0)
    (println n "Hello World")
    (hello_word_n_times (dec n))))

(hello_word_n_times 10)