(let [int-char (int (apply char "a"))
      string (str (char int-char))]
  (println "letter:: 'a'" 
           "int-char::" int-char
           "back to string::" string))