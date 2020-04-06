;; Use the str, vector, list, hash-map, and hash-set functions.
;; Creates a string
(println (str "This" "is" "a" "string" "concatenation"))

;; Creates a vector
(def my-vector [1 "string" 2.5 nil])
(println "A vector" my-vector)
(println "A vector?" (vector? my-vector))
(println "A vector is a sequence?" (seq? my-vector))
(println "Add new item to the end of vector: true" (conj my-vector true))
(println "Add new item at the beginning of vector: true" (cons true my-vector))
(println "Add new item to the end of vector with assoc: true" (assoc my-vector (count my-vector) true))
(println "Remove last element from vector with pop:" (pop my-vector))

;; Creates a list
(def my-list (list 2 "string2" 2.5 nil))
(println "A list" my-list)
(println "A list?" (list? my-list))
(println "A list is a sequence?" (seq? my-list))
(println "Add new item to the list with cons: true" (cons true my-list))
(println "Add new item to the list with conj: true" (conj my-list true))
(println "Get element from last position with nth:" (nth my-list (dec (count my-list))))
(println "Get element from last position with get:" (get my-list (dec (count my-list))))
(println "Remove first element from list with pop:" (pop my-list))

;; Creates a hashmap
(def my-hmap {:name "An individual" :age 67 :profession {:type "Office" :charge "Senior" :role "Analyst"}})
(println "A hash map:" my-hmap)
(println "A hash map?" (map? my-hmap))
(println "Get inner hash map with get-in:" (get-in my-hmap [:profession]))
(println "Add new item to hash map:" (assoc my-hmap :id 90))
(println "Substitute inner item hash map" (assoc-in my-hmap [:profession] {:id 45}))
(println "Add new item to inner hash map" (assoc-in my-hmap [:profession :id] 45))
(println "Remove an item from hash map" (dissoc my-hmap :age))
(println "Remove an item from inner hash map" (update-in my-hmap [:profession] dissoc :type))

;; Creates a hashset
(def my-hset #{"apple" "banana" "lemon" "grape"})
(println "A set:" my-hset)
(println "A set?" (set? my-hset))
(println "Get an item from hash set: grape" (my-hset "grape"))
(println "Add new existing item into hash set: apple" (conj my-hset "apple"))
(println "Add new not existing item into hash set: cherry" (conj my-hset "cherry"))
(println "Remove an item from hash set: lemon" (disj my-hset "lemon"))