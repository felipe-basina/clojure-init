(require '[clojure.set :as st])

(defn twoStrings [s1 s2]
  (let [first-set (set s1)
        second-set (set s2)
        intersection (st/intersection first-set second-set)]
    (if (empty? intersection) "NO" "YES")))

(println (twoStrings "hello" "world"))
(println (twoStrings "hi" "world"))
(println (twoStrings "art" "a"))
(println (twoStrings "cat" "be"))