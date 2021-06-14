(ns sample-db)

(def gemstone-db {
                  :ruby {
                         :name "Ruby"
                         :stock 120
                         :sales [1990 3644 6376 4918 7882 6747 7495 8573 5097 1712]
                         :properties {
                                      :dispersion 0.018
                                      :hardness 9.0
                                      :refractive-index [1.77 1.78]
                                      :color "Red"
                                      }
                         }
                  :diamond {
                            :name "Diamond"
                            :stock 10
                            :sales [8295 329 5960 6118 4189 3436 9833 8870 9700 7182 7061 1579]
                            :properties {
                                         :dispersion 0.044
                                         :hardness 10
                                         :refractive-index [2.417 2.419]
                                         :color "Typically yellow, brown or gray to colorless"
                                         }
                            }
                  :moissanite {
                               :name "Moissanite"
                               :stock 45
                               :sales [7761 3220]
                               :properties {
                                            :dispersion 0.104
                                            :hardness 9.5
                                            :refractive-index [2.65 2.69]
                                            :color "Colorless, green, yellow"
                                            }
                               }
                  }
  )

(defn durability [db gem]
      (:hardness (:properties (gem db))))

(defn durability2 [db gem]
      (get-in db [gem :properties :hardness]))

(println (durability gemstone-db :moissanite))
(println (durability2 gemstone-db :moissanite))

;; This way returns the entire map (db content)
(defn change-color [db gem new-color]
      (assoc-in db [gem :properties :color] new-color))

;; This way returns only the updated value, not the entire map (db content)
(defn change-color2 [db gem new-color]
      (update (gem db) :properties into {:color new-color}))

(println (change-color gemstone-db :ruby "Near colorless through pink through all shades of red to a deep crimson"))
(println (change-color2 gemstone-db :ruby "Near colorless through pink through all shades of red to a deep crimson"))

;; Functions like assoc-in and update-in will
;; change content from a map and return the entire content of it
(defn sell [db gem client-id]
      (let [decreased-stock-map (update-in db [gem :stock] dec)
            updated-sales-map (update-in decreased-stock-map [gem :sales] conj client-id)]
           updated-sales-map))

(println (sell gemstone-db :diamond 101010))