(def m (atom {:total 0}))
(println @m)

(swap! m assoc :name "Name")
(println @m (count @m))

(swap! m assoc :age 33)
(println @m (count @m))

(swap! m assoc :date-of-birth "2000-01-10")
(println @m (count @m))

(swap! m assoc :name "Name Lastname")
(println @m (count @m))

(println (@m :name))
(println (@m :age))
(println (@m :date-of-birth))

(def mm {:name "tunga"})
(println mm)

(println (assoc mm :name "oyyye"))
(println mm)

(println "Before" @m)
(defn print-n-times [init end]
    (if (< init end)
        (do
            (swap! m assoc :total (inc (@m :total)))
            (print-n-times (inc init) end))))

(print-n-times 0 5)
(println "After" @m)
