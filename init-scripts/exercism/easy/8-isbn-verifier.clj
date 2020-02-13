;; The ISBN-10 verification process is used to validate book identification numbers. These normally contain dashes and look like: 3-598-21508-8
;; The ISBN-10 format is 9 digits (0 to 9) plus one check character (either a digit or an X only). In the case the check character is an X, this represents the value '10'. 
;; These may be communicated with or without hyphens, and can be checked for their validity by the following formula:
;; (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0
;; If the result is 0, then it is a valid ISBN-10, otherwise it is invalid.
(require '[clojure.string :as str])

(defn hifen-remove [string]
  (str/replace string #"-" ""))

(defn split-string [string]
  (let [new-string (hifen-remove string)]
       (str/split new-string #"")))

(defn convert-to-int []
  (fn [digit] 
    (if (= digit "X") 10
        (#(Integer/parseInt %) digit))))

(defn convert-digits [digits]
  (map (convert-to-int) digits))

(defn sum-up-digits [digits sum]
  (if (empty? digits) sum
      (sum-up-digits
       (rest digits)
       (+ sum (* (int (first digits)) (count digits))))))

(defn is-valid-isbn? [isbn]
  (let [digits (convert-digits (split-string isbn))]
      (=
       (rem (sum-up-digits digits 0) 11)
       0)))

(println (is-valid-isbn? "3-598-21508-8"))
(println (is-valid-isbn? "3598215088"))
(println (is-valid-isbn? "3-598-21507-X"))
(println (is-valid-isbn? "359821507X"))

