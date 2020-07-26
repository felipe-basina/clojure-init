(require '[clojure.string :as s])

(defn split-string [string]
  (s/split string #""))

(defn replace-first-char [string char]
  (s/replace-first string char ""))

(defn includes-char? [string char]
  (s/includes? string char))

(defn count-string [string]
  (count string))

(defn first-string-bigger-or-equal? [s1 s2]
  (>= (count-string s1) (count-string s2)))

(defn remaining [string]
  (println "remaining" string)
  (count string))

(defn makingAnagrams [s1 s2]
  (let [first-bigger-or-equal? (first-string-bigger-or-equal? s1 s2)
        bigger (if first-bigger-or-equal? s1 s2)
        smaller (if (not first-bigger-or-equal?) s1 s2)]
    (loop [smaller (split-string smaller)
           bigger bigger
           total-deletions 0]
      (if (empty? smaller) (+ total-deletions (remaining bigger))
          (let [first-char (first smaller)
                includes-char? (includes-char? bigger first-char)]
            (if includes-char? (recur (rest smaller)
                                      (replace-first-char bigger first-char)
                                      total-deletions)
                (recur (rest smaller)
                       bigger
                       (inc total-deletions))))))))

(println (makingAnagrams "abc" "amnop"))
(println (makingAnagrams "cde" "abc"))