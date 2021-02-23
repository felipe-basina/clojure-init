; Set some records
(defrecord FictionalCharacter [name appears-in author])
(defrecord SuperComputer [cpu no-cpus storage-gb])

(def watson-1 (->FictionalCharacter "John Watson" "Sign of the Four" "Doyle"))
(def watson-2 (map->SuperComputer {:cpu "Power7" :no-cpus 2880 :storage-gb 4000}))
(println "watson-1" watson-1 "\nwatson-2" watson-2)
(println (class watson-1))
(println (class watson-2))