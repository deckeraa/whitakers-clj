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
  {"aliam" "other, another; singular feminine accusative from alius, alia, aliud"
   "Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "candida" "bright, white, clean; singular feminine nominative from candidus, candida, candidum"
   "illam" "to that; singular feminine accusative from ille, illa, illud"
   "īre" "to go; present infinitive from eō, īre, iī, itus (irregular)"
   "ita" "yes"
   "mē" "to me, accusative from ego"
   "mēcum" "with me (mē + cum)"
   "quattuordecim" "14"
   "sānctōrum" "of the saints; plural masculine gentive from sānctus, sānctī"
   "tē" "to you, accusative from tu"
   "tēcum" "with you (tē + cum)"
   "tunc" "then"
   "vel" "or"})

(def dictionary-map
  {"abbās" "abbot"
   "abbās, abbātis" "abbot"
   "ambulābant" "they were walking"
   "ambulō, ambulāre, ambulāvī, ambulātus" "to walk"
   "amīcus" "friend"
   "amīcus, amīcī" "friend"
   "appāreō, appārēre, appāruī, appāritus" "to appear";; no past perfect participle?
   "appāruit" "he appeared"
   "arbor" "tree"
   "arbor, arboris" "tree" 
   "arbōrēs" "trees"
   "Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "candidus, candida -um, candidior -or -us, candidissimus -a -um" "bright, white, clean"
   "chrīstus" "annointed one, Christ"
   "Chrīstus, Chrīstī" "Christ"
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
