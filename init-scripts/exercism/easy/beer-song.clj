;;;
;;; Recite the lyrics to that beloved classic, that field-trip favorite: 99 Bottles of Beer on the Wall.
;;; Note that not all verses are identical.
;;;

(require '[clojure.string :as s])

(def SENTENCE_1 (str ":d bottles of beer on the wall, :d bottles of beer."))
(def SENTENCE_2 (str "Take one down and pass it around, :d bottles of beer on the wall."))
(def SENTENCE_3 (str "Take it down and pass it around, no more bottles of beer on the wall."))
(def FINAL_SENTENCE_1 (str "No more bottles of beer on the wall, no more bottles of beer."))
(def FINAL_SENTENCE_2 (str "Go to the store and buy some more, :d bottles of beer on the wall."))
(def total-beers 99)

(loop [bootle-num total-beers]
    (if (> bootle-num 0)
        (do 
            (let [fsentence (s/replace SENTENCE_1 ":d" (str bootle-num))
                  fsentence (if (= bootle-num 1) (s/replace fsentence "bottles" "bottle") fsentence)
                  ssentence (s/replace SENTENCE_2 ":d" (str (dec bootle-num)))
                  ssentence (if (= bootle-num 1) SENTENCE_3 ssentence)]
                (println fsentence)
                (println ssentence)
                (println)
                (recur (dec bootle-num))))
    (do (println FINAL_SENTENCE_1)
        (println (s/replace FINAL_SENTENCE_2 ":d" (str total-beers))))))