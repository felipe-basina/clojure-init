(require '[clojure.string :as s])

(defn split-string [string]
  (s/split string #""))

(defn find-character [checked-characters character]
  (.indexOf checked-characters character))

(defn add-permutation [checked-characters first second]
  (conj checked-characters (str first second)))

(defn not-checked-character? [checked-characters first second]
  (let [fs (str first second)
        sf (str second first)]
    (and (< (find-character checked-characters fs) 0)
         (< (find-character checked-characters sf) 0))))

(defn not-same-character? [current next]
  (not (= current next)))

(defn inner-permutation [checked-characters character string]
  (loop [string string
         checked-characters checked-characters]
    (let [new-character (first string)]
      (if (empty? string) checked-characters
          (if (and (not-same-character? character new-character)
                   (not-checked-character? checked-characters character new-character))
            (recur (rest string)
                   (add-permutation checked-characters character new-character))
            (recur (rest string)
                   checked-characters))))))

(defn permute [source]
  (loop [string source
         permutation []]
    (let [character (first string)]
      (if (empty? string) permutation
          (recur (rest string)
                 (inner-permutation permutation character source))))))

(defn alternate-characters? [string]
  (loop [splited (split-string string)
         character ""]
    (if (empty? splited) true
        (if (not (= character (first splited)))
          (recur (rest splited)
                 (first splited))
          false))))

(defn only-two-characters? [string]
  ;(println "string" string)
  (loop [splited (split-string string)
         checked-characters []]
    (if (empty? splited) (= (count checked-characters) 2)
        (if (not-checked-character? checked-characters (first splited) (second splited))
          (recur (rest splited)
                 (add-permutation checked-characters (first splited) (second splited)))
          (recur (rest splited)
                 checked-characters)))))

(defn two-and-alternate-characters? [string]
  (and (only-two-characters? string)
       (alternate-characters? string)))

(defn new-longest-string [current new]
  (> (count new) (count current)))

(defn inner-process [characters longest-string string]
  (let [new-string (s/replace string (first characters) "")
        new-string (s/replace new-string (second characters) "")]
    (println "new-string" new-string "longest-string" longest-string)
    (if (and (two-and-alternate-characters? new-string)
             (new-longest-string longest-string new-string))
      new-string
      longest-string)))

(defn process [string]
  (let [longest-string ""
        permute (permute string)]
    (loop [permute permute
           longest-string longest-string]
      (if (empty? permute) longest-string
          (let [characters (split-string (first permute))]
            ;(println "characters" characters "new-longest-string" longest-string "permute" permute)
            (recur (rest permute)
                   (inner-process characters longest-string string)))))))

(defn alternate [s]
  (let [result (process s)]
    (println "result" result)
    (if (empty? result) 0
        (count result))))

;(println (alternate "abaacdabd"))
;(println (alternate "beabeefeab"))
(println (alternate "asdcbsdcagfsdbgdfanfghbsfdab"))