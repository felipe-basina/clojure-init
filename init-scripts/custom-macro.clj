(defn criticize-code [criticism code]
    `(println ~criticism (quote ~code)))

(defmacro code-critic
  [good bad]
  `(do ~@(map #(apply criticize-code %)
              [["Sweet lion of Zion, this is bad code:" bad]
               ["Great cow of Moscow, this is good code:" good]])))

(code-critic (1 + 1) (+ 1 1))

(def message "Good job!")
(defmacro with-mischief
  [& stuff-to-do]
  (println "stuff-to-do" stuff-to-do)
  (concat (list 'let ['message "Oh, big deal!"])
          stuff-to-do))

(with-mischief
  (println "Here's how I feel about that thing you did: " message))

;; syntax symbol# applied for auto-generate symbols!
(defmacro report
  [to-try]
  `(let [result# ~to-try]
     (if result#
       (println (quote ~to-try) "was successful:" result#)
       (println (quote ~to-try) "was not successful:" result#))))

(report (do (Thread/sleep 1000) (+ 1 1)))
(report (= 1 1))
(report (= 1 2))
