(def items ["jd" "Joe Doe" "Los Bagos"])

; Destructuring vector items to symbols
(println "All elements destructured?" (let [[alias name city] items]
              (= alias (nth items 0))
              (= name (nth items 1))
              (= city (nth items 2))))

; When there are no elements to assign a value, the symbol will be nil
(println "Is nil element?" (let [[alias name city country] items]
              (nil? country)))

(println "User underscore when it is not need the destructured value:"
         (let [[username _ city] items]
              (str username " | " city)))

; It is possible to destructure other types of sequences
(def coords '(29.20090, 12.90391))

(println "Coordinates as list:" (let [[x y] coords]
              (str x " - " y)))

(println "Getting letters 1, 2, 4 from string `VIRO`:"
         (let [[first-letter second-letter _ fourth-letter] "VIRO"]
              (str first-letter ", " second-letter ", " fourth-letter)))

; It is possible to destructure nested sequences
(def currencies [[42 "EUR"] [50 "USD"]])
(println "currencies" currencies)
(println "Nested sequences:"
         (let [[[_ currency] [amount _]] currencies]
              (str currency " " amount)))

(def basket '("Apple" "Pear" "Banana" "Grapes" "Lemon"))
(println "fruit basket" basket)

; Using & do assign all remaining not-yet destructured elements
(println "Get rest not-yet destructured elements:"
         (let [[first second & rest] basket]
              (str "first: " first ", second: " second ", remaining: " rest)))

; Using : to get the original elements
(println "All elements" (let [[first _ third :as fruits] basket]
                             (str first ", " third ", all: " fruits)))

; Using destructure in function parameters
(defn summary [[first second & rest]]
      (str first ", " second " and " (count rest) " more fruit names!"))
(println (summary basket))