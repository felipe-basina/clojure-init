(require '[clojure.string :as str])

(defprotocol InputProtocol
    (process-input [this]))

(deftype FileInput [file-path]
    InputProtocol
    (process-input [this]
        (let [content (slurp (.file-path this))]
            (println content))))

(deftype StringInput [content]
    InputProtocol
    (process-input [this]
        (println (.content this)))) 

(deftype ConsoleInput [content]
    InputProtocol
    (process-input [this]
        (println (str/split (.content this) #"\n"))))

(let [file-input (FileInput. "input.txt")
      string-input (StringInput. "Hello World")
      console-input (ConsoleInput. (read-line))]
    (process-input file-input)
    (process-input string-input)
    (process-input console-input))
