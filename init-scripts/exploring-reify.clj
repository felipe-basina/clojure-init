(defrecord Banana [qty])
(defrecord Grape  [qty])
(defrecord Orange [qty])

(defprotocol Fruit
  (subtotal [item]))

(extend-type Banana
  Fruit
  (subtotal [item]
    (* 158 (:qty item))))

(extend-type Grape
  Fruit
  (subtotal [item]
    (* 178 (:qty item))))

(extend-type Orange
  Fruit
  (subtotal [item]
    (* 98 (:qty item))))

(def banana (->Banana 10))
(def grape (->Grape 10))
(def orange (->Orange 10))

(println (subtotal banana))
(println (subtotal grape))
(println (subtotal orange))

(defn coupon [item]
  (reify Fruit
    (subtotal [_]
      (int (* 0.75 (subtotal item))))))

(println (subtotal (coupon banana)))
(println (subtotal (coupon grape)))
(println (subtotal (coupon orange)))
