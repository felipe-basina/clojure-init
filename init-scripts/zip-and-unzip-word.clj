(require '[clojure.string :as str])

(defn letter-already-mapped? [letter zipped]
    (.contains zipped letter))

(defn same-letter? [current-letter letter-target]
    (= current-letter letter-target))

(defn count-letter-occurrencies [letter word]
    (loop [w word
           total 0]
        (if (not-empty w)
            (let [l (first w)
                  inc-total (if (same-letter? l letter) 1 0)]
                (recur (rest w)
                        (+ total inc-total)))
        total)))

(defn repeat-letter [letter times]
    (loop [times times
            string ""]
            (if (> times 0)
                (recur (dec times)
                        (str string letter))
            string)))

(defn zip-word [word]
    (loop [w word
        zipped ""]
        (if (not-empty w)
            (let [letter (first w)
                total (if (letter-already-mapped? letter zipped) 0 (count-letter-occurrencies letter word))
                reduced-word (str/replace (reduce str w) letter "")
                word-wo-current-letter (if (empty? reduced-word) [] (str/split reduced-word #""))]
                (recur word-wo-current-letter
                        (if (> total 0) (str zipped total letter) zipped)))
        zipped)))

(defn unzip-word [zipped-word]
    (loop [w (str/split zipped-word #"")
           unzipped ""]
        (if (not-empty w)
            (let [pair (take 2 w)
                    number (Integer/parseInt (first w))
                    letter (second w)
                    partial-string (repeat-letter letter number)]
                (recur (rest (rest w))
                        (str unzipped partial-string)))
            unzipped)))

(def original "ANTICONSTITUCIONALISSIMAMENTE")
(def word (str/split original #""))
(let [zipped (zip-word word)
      unzipped (unzip-word zipped)]
    (println "zipped" zipped)
    (println "unzipped" unzipped))