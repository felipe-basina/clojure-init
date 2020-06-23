(require '[clojure.string :as s])

(defn split-string [string]
  (s/split string #""))

(defn add-into-stack [stack element]
  (conj stack element))

(defn pop-from-stack [stack]
  (pop stack))

(defn in-stack? [stack element]
  (if (empty? stack) false
      (let [last-element (last stack)]
        (= last-element element))))

(defn reduce-string [stack]
  (if (empty? stack) "Empty String" (reduce str stack)))

(defn superReducedString [string]
  (let [split-string (split-string string)]
    (loop [split-string split-string
           reduced-string []]
      (if (empty? split-string) (reduce-string reduced-string)
          (let [character (first split-string)]
            (if (not (in-stack? reduced-string character))
              (recur (vec (rest split-string))
                     (add-into-stack reduced-string character))
              (recur (vec (rest split-string))
                     (pop-from-stack reduced-string))))))))

(println (superReducedString "aaabccddd"))
(println (superReducedString "aa"))
(println (superReducedString "baab"))