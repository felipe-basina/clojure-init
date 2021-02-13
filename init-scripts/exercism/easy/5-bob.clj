(use '[clojure.string :as str])

(defn is-upper-case [input]
    (every? (fn [^Character c] (Character/isUpperCase c)) input))

(defn all-upper-case [vector]
    (cond 
        (not (is-upper-case (first vector))) false
        (= (count vector) 0) true
        :else (all-upper-case (rest vector))))

(defn split-string [input]
    (str/split input #" "))

(defn is-an-yelling? [input]
    (all-upper-case (split-string (str/replace input #"\?" ""))))

(defn is-a-question? [input]
    (str/includes? input "?"))

(defn is-an-yelling-question? [input]
    (and (is-an-yelling? input) (is-a-question? input)))

(defn is-just-calling-by-name? [input]
    (and (= (count input) 3)
        (= (upper-case input) "BOB")))

(defn talk-something [input]
    (cond
        (is-an-yelling-question? input) "Calm down, I know what I'm doing!"
        (is-a-question? input) "Sure"
        (is-an-yelling? input) "Whoa, chill out"
        (is-just-calling-by-name? input) "Fine. Be that way!"
        :else "Whatever."))

(println (talk-something "bob"))
(println (talk-something "is that you?"))
(println (talk-something "WHY IS THAT?"))
(println (talk-something "anything"))
(println (talk-something "HEYYYY"))