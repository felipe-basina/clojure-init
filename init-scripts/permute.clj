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

;(println (permute "asdcbsdcagfsdbgdfanfghbsfdab"))
;(println (permute "abaacdabd"))
;(println (permute "beabeefeab"))

(defn add-distinct [distincts new]
  (try
    (conj distincts new)
    (catch Exception e distincts)))

(defn distinct-characters [string]
  (loop [characters (split-string string)
         distincts #{}]
    (if (empty? characters) distincts
        (let [character (first characters)]
          (recur (rest characters)
                 (add-distinct distincts character))))))

(println (distinct-characters "asdcbsdcagfsdbgdfanfghbsfdab"))