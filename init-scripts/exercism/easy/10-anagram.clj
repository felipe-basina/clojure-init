;; Given a word and a list of possible anagrams, select the correct sublist.
;; Given "listen" and a list of candidates like "enlists" "google" "inlets" "banana" th
;; program should return a list containing "inlets" .
(require '[clojure.string :as str])

(defn update-map-letters [map-letters letter]
  (let [found-letter? (not (nil? (get map-letters letter)))]
    (if (= found-letter? true) (dissoc map-letters letter)
        (assoc map-letters letter 1))))

(defn check-anagram [word candidate]
  (loop [map-letters {}
         reference word
         candidate candidate]
    (let [word-letter (first reference)
          candidate-letter (first candidate)]
      (if (empty? reference) map-letters
          (let [map-letters (update-map-letters map-letters word-letter)
                map-letters (update-map-letters map-letters candidate-letter)]
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
                                                                                        (if (empty? map-letters) (recur (inc index)
                                                                                                                        (conj anagrams candidate))
                                                                                            (recur (inc index)
                                                                                                   anagrams)))
                                             (recur (inc index)
                                                    anagrams)))
            anagrams))))

(println (anagram "listen" '("enlists" "google" "inlets" "banana" "lentis")))