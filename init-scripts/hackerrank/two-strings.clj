(require '[clojure.string :as s])

(defn split-string [string]
  (s/split string #""))

(defn first-string-bigger-or-equal? [s1 s2]
  (>= (count s1) (count s2)))

(defn includes-char? [string char]
  (s/includes? string char))

(defn common-strings? [common?]
  (if (not-empty common?) common? "NO"))

(defn twoStrings [s1 s2]
  (let [first-string-bigger-or-equal? (first-string-bigger-or-equal? s1 s2)
        bigger (if first-string-bigger-or-equal? s1 s2)
        smaller (if (not first-string-bigger-or-equal?) s1 s2)]
    (loop [smaller (split-string smaller)
           common? ""]
      (if (or (empty? smaller)
              (not-empty common?)) (common-strings? common?)
        (let [first-char (first smaller)
              contains-char? (includes-char? bigger first-char)]
          (if contains-char? (recur []
                                    "YES")
              (recur (rest smaller)
                     common?)))))))

(println (twoStrings "hello" "world"))
(println (twoStrings "hi" "world"))
(println (twoStrings "art" "a"))
(println (twoStrings "cat" "be"))