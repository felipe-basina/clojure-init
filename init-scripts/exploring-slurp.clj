(require '[clojure.string :as str])

(defn read-input
  "Reads file content at once and keep each of its lines in a vector.
  Returns the vector"
  []
    (let [file-content (slurp "input.txt")
          splited-content (str/split file-content #"\n")]
       (loop [contents splited-content
              new-content []]
        (if (not-empty contents)
            (recur (rest contents)
                    (conj new-content (first contents)))
            new-content))))

(let [contents (read-input)]
    (println "total: " (count contents))
    (println "contents\n" contents))
