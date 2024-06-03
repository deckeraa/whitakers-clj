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
   "anteā" "before"
   "Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "candida" "bright, white, clean; singular feminine nominative from candidus, candida, candidum"
   "et" "and"
   "illam" "to that; singular feminine accusative from ille, illa, illud"
   "in" "into (with accusative), in (with ablative)"
   "īre" "to go; present infinitive from eō, īre, iī, itus (irregular)"
   "ita" "yes"
   "mē" "to me, accusative from ego"
   "mēcum" "with me (mē + cum)"
   "nōn" "not"
   "nunc" "now"
   "quadrāgintā" "40"
   "quattuordecim" "14"
   "quia" "because"
   "sānctōrum" "of the saints; plural masculine gentive from sānctus, sānctī"
   "sed" "but"
   "tē" "to you, accusative from tu"
   "tēcum" "with you (tē + cum)"
   "tunc" "then"
   "vel" "or"})

(def dictionary-map
  {"abbās" "abbot"
   "abbās, abbātis" "abbot"
   "alveum" "cavity, trough"
   "alveus, alveī" "cavity, trough"
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
   "cōgitāvit" "he thought"
   "cōgitō, cōgitāre, cōgitāvī, cōgitātus" "to think"
   "dēbēs" "you should"
   "dēbeō, dēbēre, dēbuī, dēbitus" "to owe, to ought"
   "dēliciōsa" "delicious"
   "dēliciōsam" "delicious"
   "dēliciōsus, dēliciōsa, dēliciōsum" "delicious"
   "dīcō, dīcere, dīxī, dictus" "to say"
   "diēs" "day"
   "diē" "day"
   "diēs, diēī" "day"
   "dīxērunt" "they said"
   "dīxit" "he said"
   "ego" "I"
   "eius" "his, hers, its"
   "erat" "he was"
   "est" "he is"
   "fābula" "story"
   "fābulam" "story"
   "fābula, fābulae" "story"
   "faciō, facere, fēcī, factus" "to do, to make"
   "fēcī" "I did, I made"
   "fīliī" "sons"
   "fīlium" "son"
   "fīlius, fīlī" "son"
   "flūmen" "river"
   "flūmen, flūminis" "river"
   "frātrēs" "brothers"
   "habēbat" "he had"
   "habeō, habēre, habuī, habitus" "to have"
   "habuit" "he had"
   "ībimus" "we will go"
   "īnsula" "island"
   "īnsula, īnsulae" "island"
   "īnsulae" "island"
   "īnsulam" "island"
   "invēnērunt" "they found"
   "inveniō, invenīre, invēnī, inventum" "to find"
   "īre" "to go"
   "ita" "yes; in this manner"
   "iter" "journey, trip"
   "iter, itineris" "journey, trip"
   "Iēsūs" "Jesus"
   "Jēsūs, Jēsū" "Jesus"
   "lūx" "light"
   "lūx, lūcis" "light"
   "monachus" "monk"
   "monachus, monachī" "monk"
   "multus, multa -um, -, plūrimus -a -um" "many"
   "nāvem" "boat"
   "nāvigā" "sail (imperative)"
   "nāvigāre" "to sail"
   "nāvigō, nāvigāre, nāvigāvī, nāvigātus" "to sail, to navigate"
   "nāvigāvērunt" "they sailed"
   "nāvis, nāvis" "boat"
   "nebula, nebulae" "fog, cloud"
   "nebulam" "fog, cloud"
   "nōmen" "name"
   "nōmen, nōminis" "name"
   "noster" "our"
   "noster, nostra, nostrum" "our"
   "nox" "night"
   "nox, noctis" "night"
   "ōrāvērunt" "they prayed"
   "ōrō, ōrāre, ōrāvī, ōrātus" "to pray"
   "reprōmissiō, reprōmissiōnis" "promise"
   "reprōmissiōnis" "promise"
   "revertērunt" "they returned"
   "revertō, revertere, revertī, reversum" "to return"
   "sum, esse, fuī, futūrus" "to be (irregular)"
   "terra" "land"
   "terra, terrae" "land"
   "trāns" "across, beyond"
   "tu" "you"
   "vēnērunt" "they came"
   "veniō, venīre, vēnī, ventus" "to come"
   "vēnit" "he came"
   "vestīmenta" "clothes"
   "vestīmentum, vestīmentī" "clothing, clothes"
   "vir" "man"
   "vir, virī" "man"
   "vīvēbat" "he was living"
   "vīvō, vīvere, vīxī, vīctus" "to live"
   "volēbant" "they were wanting"
   "volō" "I want"
   "volō, velle, voluī, -" "to want"
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
