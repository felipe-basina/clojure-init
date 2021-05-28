(defn compare-author [author1 author2]
    "Applies the juxt function for each keywords in map"
    (letfn [(project-author [author]
        ((juxt :lname :fname) author))]
            (compare (project-author author1) (project-author author2))))

(println (sorted-set-by compare-author 
               {:fname "Jeff" :lname "Smith"}
               {:fname "Bill" :lname "Smith"}))