(ns whitakers-clj.dictionary-override
  "Contains macronized versions of words since Whitaker's Words doesn't support that yet.")

(defn remove-macrons [s] ;; TODO this was cut'n'pasted, find a good place to put the function
  (-> s
      (clojure.string/replace #"ā" "a")
      (clojure.string/replace #"Ā" "A")
      (clojure.string/replace #"ē" "e")
      (clojure.string/replace #"Ē" "E")
      (clojure.string/replace #"ī" "i")
      (clojure.string/replace #"Ī" "I")
      (clojure.string/replace #"ō" "o")
      (clojure.string/replace #"Ō" "O")
      (clojure.string/replace #"ū" "u")
      (clojure.string/replace #"Ū" "U")))

(def dictionary-override
  {"Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic."})

(def dictionary
  {"Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic."
   "dīxērunt" "they said"
   "dīxit" "he said"
   "frātrēs" "brothers"
   })

(def macronized-words
  (into {} (map (fn [v]
                  {(remove-macrons v) v})
                (concat (keys dictionary) (keys dictionary-override)))))
