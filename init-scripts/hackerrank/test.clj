(require '[clojure.string :as s])

(defn to-char [init end]
  (map char (range (int init) (inc (int end)))))

(println (vec (to-char \a \z)))
(println (apply str (vec (to-char \a \z))))
(println (s/split (apply str (vec (to-char \a \z))) #""))
(println (s/split "abcdefghijklmnopqrstuvwxyz" #""))