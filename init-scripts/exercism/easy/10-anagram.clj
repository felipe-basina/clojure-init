;; Given a word and a list of possible anagrams, select the correct sublist.
;; Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" th
;; program should return a list containing "inlets" .
(require '[clojure.string :as str])

(defn add-letter-with-value-in-map [map-letters nested-map-key letter-key total]
  (assoc-in map-letters [nested-map-key letter-key] total))

(defn remove-letter-from-map [map-letters nested-map-key letter-key]
  (update-in map-letters [nested-map-key] dissoc letter-key))

(defn get-value-from-map [map-letters nested-map-key letter-key]
  (get-in map-letters [nested-map-key letter-key]))

(defn exists-letter-in-map? [map-letters nested-map-key letter-key]
  (not (nil? (get-value-from-map map-letters nested-map-key letter-key))))

(defn update-map-letters [map-letters nested-map-key-source nested-map-key-lookup letter]
  (let [letter-key (keyword letter)]
    (if (exists-letter-in-map? map-letters nested-map-key-lookup letter-key) 
      (let [current-total (dec (get-value-from-map map-letters nested-map-key-lookup letter-key))]
        (if (<= current-total 0) (remove-letter-from-map map-letters nested-map-key-lookup letter-key)
            (add-letter-with-value-in-map map-letters nested-map-key-lookup letter-key current-total)))
        (if (exists-letter-in-map? map-letters nested-map-key-source letter-key) 
          (add-letter-with-value-in-map map-letters nested-map-key-source letter-key (inc (get-value-from-map map-letters nested-map-key-source letter-key)))
          (add-letter-with-value-in-map map-letters nested-map-key-source letter-key 1)))))

(defn split-string [string]
  (str/split string #""))

(defn check-anagram [word candidate]
  (loop [map-letters {}
         reference (split-string word)
         candidate (split-string candidate)]
    (let [word-letter (first reference)
          candidate-letter (first candidate)]
      (if (empty? reference) map-letters
          (let [map-letters (update-map-letters map-letters :ref :cand word-letter)
                map-letters (update-map-letters map-letters :cand :ref candidate-letter)]
            (recur map-letters
                   (rest reference)
                   (rest candidate)))))))

(defn empty-map-letters? [map-letters]
  (and (empty? (get-in map-letters [:ref]))
       (empty? (get-in map-letters [:cand]))))

(defn words-total [words]
  (count words))

(defn same-size-words? [reference candidate]
  (= (words-total reference) (words-total candidate)))

(defn add-to-anagram-list [anagrams anagram]
  (conj anagrams anagram))

(defn anagram [word candidates]
  (loop [candidates candidates anagrams '()]
    (if (empty? candidates) anagrams
        (let [candidate (first candidates)]
          (if (same-size-words? word candidate) 
            (let [map-letters (check-anagram word candidate)]
              (if (empty-map-letters? map-letters) (recur (rest candidates) (add-to-anagram-list anagrams candidate))
                  (recur (rest candidates) anagrams)))
            (recur (rest candidates) anagrams))))))

(println "Anagrams for 'listen'" (anagram "listen" '("enlists" "google" "inlets" "banana" "lentis")))
(println "Anagrams for 'nnaa'"(anagram "nnaa" '("mbmb" "nana")))
(println "Anagrams for 'aaab'"(anagram "aaab" '("bbba")))
(println "Anagrams for 'amor'"(anagram "amor" '("roma" "ramo" "mora" "maro" "maru")))