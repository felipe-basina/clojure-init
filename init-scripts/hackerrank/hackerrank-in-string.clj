(defn hackerrankInString [string]
  (let [find-substring? (re-matches (re-pattern #"(.*)[h](.*)[a](.*)[c](.*)[k](.*)[e](.*)[r](.*)[r](.*)[a](.*)[n](.*)[k](.*)") string)]
    (println find-substring?)
    (if find-substring? "YES" "NO")))

(println (hackerrankInString "hereiamstackerrank"))
(println (hackerrankInString "hackerworld"))
(println (hackerrankInString "hhaacckkekraraannk"))
(println (hackerrankInString "rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt"))