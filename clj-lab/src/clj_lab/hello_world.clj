(ns clj-lab.hello-world)

(defn hello
  ([] (hello "from Clojure"))
  ([name] (println (str "Hello World " name))))

(comment
  (hello)                                                   ; Hello World from Clojure
  (hello "Felipe")                                          ; Hello World Felipe
  )