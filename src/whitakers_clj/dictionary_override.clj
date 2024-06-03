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
  {"Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic."
   "illam" "to that; singular feminine accusative from ille, illa, illud"
   "īre" "to go; present infinitive from eō, īre, iī, itus (irregular)"
   "ita" "yes"
   "mē" "to me, accusative from ego."
   "mēcum" "with me (mē + cum)"
   "quattuordecim" "14"
   "sānctōrum" "of the saints; plural masculine gentive from sānctus, sānctī"
   "tē" "to you, accusative from tu."
   "tēcum" "with you (tē + cum)"
   "tunc" "then"
   "vel" "or"})

(def dictionary-map
  {"Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic."
   "dīxērunt" "they said"
   "dīxit" "he said"
   "ego" "I"
   "frātrēs" "brothers"
   "ībimus" "we will go"
   "īre" "to go"
   "ita" "yes; in this manner"
   "nāvigāre" "to sail"
   "nāvigāvērunt" "they sailed"
   "tu" "you"
   })

(defn dictionary [v]
  (when v
    (or (dictionary-map v)
        (dictionary-map (clojure.string/lower-case v))
        (dictionary-map (clojure.string/upper-case v)))))

(def macronized-words
  (into {} (map (fn [v]
                  {(remove-macrons v) v})
                (concat (keys dictionary-map) (keys dictionary-override)))))
