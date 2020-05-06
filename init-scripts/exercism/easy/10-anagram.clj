;; Given a word and a list of possible anagrams, select the correct sublist.
;; Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" th
;; program should return a list containing "inlets" .
(require '[clojure.string :as str])

(defn update-map-letters [map-letters nested-map-key-source nested-map-key-lookup letter]
  (let [key-letter (keyword letter)
        found-letter-lookup? (not (nil? (get-in map-letters [nested-map-key-lookup key-letter])))]
    (if (= found-letter-lookup? true) (update-in map-letters [nested-map-key-lookup] dissoc key-letter)
        (let [found-letter-source? (not (nil? (get-in map-letters [nested-map-key-source key-letter])))]
          (if (= found-letter-source? true) (assoc-in map-letters [nested-map-key-source key-letter] 
                                                       (inc (get-in map-letters [nested-map-key-source key-letter])))
              (assoc-in map-letters [nested-map-key-source key-letter] 1))))))

(defn check-anagram [word candidate]
  (loop [map-letters {}
         reference word
         candidate candidate]
    (let [word-letter (first reference)
          candidate-letter (first candidate)]
      (if (empty? reference) map-letters
          (let [map-letters (update-map-letters map-letters :ref :cand word-letter)
                map-letters (update-map-letters map-letters :cand :ref candidate-letter)]
            (recur map-letters
                   (rest reference)
                   (rest candidate)))))))

(defn anagram [word candidates]
  (let [word-letters (str/split word #"")
        word-total-letters (count word)
        total-candidates (count candidates)]
      (loop [index 0
             anagrams '()]
        (if (< index total-candidates) (let [candidate (nth candidates index) 
                                             candidate-letters (str/split candidate #"")]
                                         (if (= word-total-letters (count candidate)) (let [map-letters (check-anagram word-letters candidate-letters)] 
                                                                                        (if (and (empty? (get-in map-letters [:ref])) 
                                                                                                 (empty? (get-in map-letters [:cand]))) (recur (inc index)
                                                                                                                                               (conj anagrams candidate))
                                                                                            (recur (inc index)
                                                                                                   anagrams)))
                                             (recur (inc index)
                                                    anagrams)))
            anagrams))))

(println (anagram "listen" '("enlists" "google" "inlets" "banana" "lentis")))
(println (anagram "nnaa" '("mbmb" "nana")))