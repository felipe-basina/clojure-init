(def DAY_OF_THE_PROGRAMMER 256)
(def TOTAL_31DAYS_MONTHS 5)
(def TOTAL_30DAYS_IN_8_MONTHS (quot DAY_OF_THE_PROGRAMMER 30))
(def TOTAL_DAYS_IN_8_MONTHS_INCLUDING_TOTAL_31DAYS_MONTHS (+ (* TOTAL_30DAYS_IN_8_MONTHS 30) TOTAL_31DAYS_MONTHS))
(def TOTAL_DAYS_IN_8_MONTHS_EXCLUDING_FEBRUARY (- TOTAL_DAYS_IN_8_MONTHS_INCLUDING_TOTAL_31DAYS_MONTHS 2))
(def FEBRUARY_RULE {:year 1918 :days-in-february 15})

(defn julian-calendar-year? [year]
  (and (>= year 1700) (<= year 1917)))

(defn leap-year? [year]
  (or (and (julian-calendar-year? year)
           (= (rem year 4) 0))
      (= (rem year 400) 0)
      (and (= (rem year 4) 0)
           (> (rem year 100) 0))))

(defn transition-year? [year]
  (= (:year FEBRUARY_RULE) year))

(defn apply-february-rule [year]
  (cond
    (transition-year? year) (- TOTAL_DAYS_IN_8_MONTHS_INCLUDING_TOTAL_31DAYS_MONTHS (:days-in-february FEBRUARY_RULE))
    (leap-year? year) (inc TOTAL_DAYS_IN_8_MONTHS_EXCLUDING_FEBRUARY)
    :else TOTAL_DAYS_IN_8_MONTHS_EXCLUDING_FEBRUARY))

(defn missing-days [year]
  (- DAY_OF_THE_PROGRAMMER (apply-february-rule year)))

(defn dayOfProgrammer [year]
  (str (missing-days year) ".09." year))

(println (dayOfProgrammer 1984))
(println (dayOfProgrammer 2017))
(println (dayOfProgrammer 2016))
(println (dayOfProgrammer 1800))
(println (dayOfProgrammer 1918))