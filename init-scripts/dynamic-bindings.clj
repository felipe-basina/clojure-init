; Dynamic bindings allows to change def values
; in runtime
;
; By convention dynamic vars should
; begin and end with '*' (earmuffs)
; '^:dynamic' it's a metadata
(def ^:dynamic *debug-enabled* false)

(defn debug [msg]
  (if *debug-enabled* (println msg)))

(defn a-function []
  (debug "In a a-function"))

(binding [*debug-enabled* true]
  (debug "Calling that darned function")
  (a-function)
  (debug "Back from that darned function"))

(println "Calling a-function...")
(a-function)