(require '[clojure.string :as s])

(defn get-first-letter [string-vector]
  (first string-vector))

(defn concatenate [all-letters reverse]
  (str (get-first-letter all-letters) reverse))

(defn split-string [string]
  (s/split string #""))

(defn reverse-string [string]
  (loop [splitted-string (split-string string)
         reverse ""]
    (if (empty? splitted-string) reverse
        (recur (rest splitted-string)
               (concatenate splitted-string reverse)))))

(println (reverse-string "SOCORRAM ME SUBI NO ONIBUS EM MARROCOS"))