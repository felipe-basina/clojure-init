(ns clj-lab.hello-world)

(defn hello
  ([] (hello "from Clojure"))
  ([name] (println (str "Hello World " name))))

(comment
  (hello)
  (hello "Felipe"))