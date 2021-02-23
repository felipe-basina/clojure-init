;; Set some records
(defrecord FictionalCharacter [name appears-in author])
(defrecord SuperComputer [cpu no-cpus storage-gb])

(def watson-1 (->FictionalCharacter "John Watson" "Sign of the Four" "Doyle"))
(def watson-2 (map->SuperComputer {:cpu "Power7" :no-cpus 2880 :storage-gb 4000}))
(println "watson-1" watson-1 "\nwatson-2" watson-2)
(println (class watson-1))
(println (class watson-2))

;; Set a protocol
(defprotocol Person
    (full-name [this])
    (greeting [this msg])
    (description [this]))

;; Set some implementations for the protocol
(defrecord FictionalCharacter2 [name appears-in author]
    Person
    (full-name [this] (:name this))
    (greeting [this msg] (str msg " " (:appears-in this)))
    (description [this] (str (:name this) " is a character in " (:appears-in this))))

(defrecord Employee [first-name last-name department]
    Person
    (full-name [this] (str (:first-name this) " " (:last-name this)))
    (greeting [this msg] (str msg " " (:first-name this)))
    (description [this] (str (:first-name this) " works in " (:department this))))

(def john-wick (->FictionalCharacter2 "John Wick" "John Wick 1,2,3" "Keenu Reeves"))
(println 
    (full-name john-wick)
    (greeting john-wick "Hi man,")
    (description john-wick))

(def marie-doe (->Employee "Marie" "Doe" "Marketing"))
(println 
    (full-name marie-doe)
    (greeting marie-doe "Hello")
    (description marie-doe))

;; Set a new protocol that should be implemented
(defprotocol Marketable 
    (make-slogan [this]))

;; Set on-the-fly protocol implementations without changing/re-setting the existing records
(extend-protocol Marketable
    Employee
        (make-slogan [e] (str (:first-name e) " is the BEST employee"))
    FictionalCharacter2
        (make-slogan [fc2] (str (:name fc2) " is the GREATEST character"))
    SuperComputer
        (make-slogan [sc] (str "This computer has " (:no-cpus sc) " CPUS!")))

(println 
    (make-slogan marie-doe)
    (make-slogan john-wick)
    (make-slogan watson-2))