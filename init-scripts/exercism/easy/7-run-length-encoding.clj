(require '[clojure.string :as str])

(defn get-total [total]
    (if (= total 1) ""
        total))

(defn compress [string compressed total first-letter]
    (cond
        (= (count string) 0) (str compressed (get-total total) first-letter)
        (= (first string) first-letter) (compress (rest string) compressed (inc total) (first string))
        (not (= (first string) first-letter)) (compress (rest string) (str compressed (get-total total) first-letter) 1 (first string))))

(defn run-compress [original]
    (let [string (#(str/split %1 #"") original)
            first-letter (first string)
            remaining (rest string)]
        (compress remaining "" 1 first-letter)))

(println "compress: WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB <" 
    (run-compress "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB") ">") ; 12WB12W3B24WB
(println "compress: AABCCCDEEEE <"(run-compress "AABCCCDEEEE") ">") ; 2AB3CD4E

(defn parse-int [s]
    (try
        (Integer. (re-find #"[0-9]*" s))  
        (catch Exception e -1)))

 (defn repeat-value [index total value repeated-value]
    (if (= index total) repeated-value
        (repeat-value (inc index) total value (str repeated-value value))))

(defn decompress [string total partial first-char decompressed]
    (cond
        (= (count string) 0) (str decompressed (repeat-value 0 total first-char ""))
        (= (parse-int first-char) -1) (decompress (rest string) 1 "" (first string) (str decompressed (repeat-value 0 total first-char "")))
        (not (= (parse-int first-char) -1)) (decompress (rest string) (parse-int (str partial first-char)) (str partial first-char) (first string) decompressed)))

(defn run-decompress [original]
    (let [string (#(str/split %1 #"") original)
            first-letter (first string)
            remaining (rest string)]
        (decompress remaining 1 "" first-letter "")))

(println "decompress: 2AB3CD4E <" (run-decompress "2AB3CD4E") ">") ; AABCCCDEEEE
(println "decompress: 12WB12W3B24WB <" (run-decompress "12WB12W3B24WB") ">") ; WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB