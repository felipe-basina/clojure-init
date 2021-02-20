(ns hipstr.components.signup
(:require
  [struct.core :as st]))

(def sign-up-schema [[:username st/required st/string st/string-like]
                     [:email st/required st/string]
                     [:password st/required st/string]])

(defn get-form-field-errors [user]
  (nth (st/validate user sign-up-schema) 0))

(defn validate-signup [user]
  (println "validate-signup" user
           "is valid body?" (st/valid? user sign-up-schema)
           "validate" (nil? (nth (st/validate user sign-up-schema) 0))
           (count (st/validate user sign-up-schema)))
  (let [valid? (st/valid? user sign-up-schema)]
    (if (not valid?)
      (get-form-field-errors user)
      {})))

