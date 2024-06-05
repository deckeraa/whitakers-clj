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
  {"ad" "to, towards, at, according to"
   "aliam" "other, another; singular feminine accusative from alius, alia, aliud"
   "anteā" "before"
   "atque" "and"
   "aut" "or"
   "autem" "but, however, moreover"
   "avēs" "birds; plural feminine nominative or accusative from avis, avis"
   "avium" "of birds; plural feminine genitive from avis, avis"
   "Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "candida" "bright, white, clean; singular feminine nominative from candidus, candida, candidum"
   "coepērunt" "they started; from coepī, coepisse, coepī, coeptum"
   "contrā" "against, away from, facing"
   "cum" "with"
   "de" "of, from, away from, down from"
   "dum" "while, as long as, until"
   "ecce" "Look! Behold!"
   "eius" "his/her/its"
   "et" "and"
   "exceptō" "except"
   "ibī" "there, then"
   "illam" "that; singular feminine accusative from ille, illa, illud"
   "illīs" "those; plural dative or ablative from ille, illa, illud"
   "illīus" "of that; singular genitive from ille, illa, illud"
   "illud" "that; singular neuter nominative or accusative from ille, illa, illud"
   "illum" "that; singular feminine accusative from ille, illa, illud"
   "in" "into (with accusative), in (with ablative)"
   "īre" "to go; present infinitive from eō, īre, iī, itus (irregular)"
   "istō" "that; singular masculine or neuter ablative from iste"
   "ita" "yes"
   "iuxtā" "near, nearly"
   "mē" "to me, accusative from ego"
   "mēcum" "with me (mē + cum)"
   "nōbīs" "us; singular dative or ablative from ego"
   "nōn" "not"
   "nunc" "now"
   "per" "through"
   "plūs" "more, from mūltus"
   "porrō" "farther, further, also"
   "pōtum" "drink; singular masculine accusative from pōtus, pōtūs"
   "prope" "near, close"
   "quadrāgintā" "40"
   "quaerere" "to seek"
   "quaerō, quaerere, quaesīvī, quaesītus" "to seek"
   "quantum" "how much?"
   "quantus" "how much?"
   "quantus, quanta, quantum" "how much?"
   "quattuordecim" "14"
   "quia" "because"
   "resurrēctiō, resurrēctiōnis" "resurrection"
   "resurrēctiōne" "resurrection"
   "rīvulum" "rivulet, small brook"
   "rīvulus, rīvulī" "rivulet, small brook"
   "sāncta" "holy, saint"
   "sānctus" "holy, saint"
   "sānctōrum" "of the saints; plural masculine gentive from sānctus, sānctī"
   "sed" "but"
   "sī" "if"
   "sibi" "to himself; singular dative of se"
   "sīcut" "as, same as, like"
   "sua" "her/its; sing. fem. nom. or abl. or neuter nom. or acc. from suus"
   "sufficere" "to be sufficient"
   "sufficiō, sufficere, suffēcī, suffectum" "to be sufficient"
   "summitās, summitātis" "summit, top"
   "summitātem" "summit, top"
   "tam" "as much, as much as"
   "tē" "to you, accusative from tu"
   "tēcum" "with you (tē + cum)"
   "terra, terrae" "land"
   "terram" "land"
   "trahō, trahere, trāxī, tractum" "to draw, to drag, to haul"
   "trāxissent" "they (might) have had drawn"
   "trīduum, trīduī" "three days"
   "trīduum" "three days"
   "tunc" "then"
   "ubī" "where, when if"
   "ūniūs" "of one (genitive of ūnus)"
   "ūsque" "until, all the way, up until"
   "ut" "so that"
   "valdē" "very"
   "vel" "or"
   "veniō, venīre, vēnī, ventus" "to come"
   "vēnērant" "they had came"
   "vēnissent" "they (might) have had come"
   "vergō, vergere, -, -" "to lay, to incline, to slope"
   "vergentem" "laying"
   "vīctum"" food; singular masculine accussative from victus, victūs"
   "videō, vidēre, vīdī, vīsus" "to see"
   "vīdērunt" "they saw"
   })

(def dictionary-map
  {"abbās" "abbot"
   "abbās, abbātis" "abbot"
   "abscondō, abscondere, abscondī, absconditus" "to hide, to conceal"
   "absconditōrum" "of things hidden"
   "addidit" "he added"
   "addō, addere, addidī, additus" "to add"
   "āgnōscō, āgnōscere, āgnōvī, āgnitus" "to recognize, to realize, to acknowledge"
   "āgnōvit" "he recognized, he realized"
   "āit" "he said"
   "āiere" "to speak, to affirm"
   "āla, ālae" "wing"
   "ālae" "wings"
   "ālās" "wings"
   "alia" "other"
   "alius, alia, aliud" "other"
   "altitūdinis" "height, depth"
   "altitūdō, altitūdinis" "height, depth"
   "alveum" "cavity, trough"
   "alveus, alveī" "cavity, trough"
   "ambulābant" "they were walking"
   "ambulō, ambulāre, ambulāvī, ambulātus" "to walk"
   "amīcus" "friend"
   "amīcus, amīcī" "friend"
   "angustiam" "small space, narrow passage, being boxed in"
   "angustia, angustiae" "small space, narrow passage, being boxed in"
   "angustum, angustī" "small space, narrow passage, being boxed in"
   "appāreō, appārēre, appāruī, appāritus" "to appear";; no past perfect participle?
   "appāruit" "he appeared"
   "arbor" "tree"
   "arbor, arboris" "tree"
   "arbōre" "tree"
   "arbōrēs" "trees"
   "ascendentibus" "ascending"
   "ascendō, ascendere, ascendī, ascēnsus" "to ascend"
   "aspicere" "to look at, to contemplate"
   "aspiciō, aspicere, aspēxī, aspectus" "to look at, to contemplate"
   "avem" "bird"
   "avis, avis" "bird"
   "avium" "of birds"
   "avibus" "birds"
   "Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "candidus, candida -um, candidior -or -us, candidissimus -a -um" "bright, white, clean"
   "candidissimīs" "most bright/white, very bright/white"
   "candidissimus" "most bright/white, very bright/white"
   "causa, causae" "cause, reason"
   "causa" "cause, reason"
   "chrīstus" "annointed one, Christ"
   "Chrīstus, Chrīstī" "Christ"
   "circuitum" "circuit, outer shore"
   "circuitus, circuitūs" "circuit, outer shore"
   "clēmentia, clēmentiae" "mercy, clemency"
   "clēmentiae" "mercies"
   "coepērunt" "they started"
   "coepī, coepisse, coepī, coeptus" "to start"
   "coepit" "he started"
   "cōgitāre" "to think"
   "cōgitāvit" "he thought"
   "cōgitō, cōgitāre, cōgitāvī, cōgitātus" "to think"
   "cōgnitor" "advocate, attorney, witness"
   "cōgnitor, cōgnitōris" "advocate, attorney, witness"
   "collēctiō" "collection"
   "collēctiō, collēctiōnis" "collection"
   "collēctiōne" "collection"
   "cooperta" "covered"
   "cooperiō, cooperīre, cooperuī, coopertus" "to cover"
   "cooperuērunt" "they covered"
   "cor, cordis" "heart"
   "cordis" "heart"
   "crēdō" "I believe"
   "crēdō, crēdere, crēdidī, crēditum" "to believe"
   "dēbēs" "you should"
   "dēbeō, dēbēre, dēbuī, dēbitus" "to owe, to ought"
   "dēliciōsa" "delicious"
   "dēliciōsam" "delicious"
   "dēliciōsus, dēliciōsa, dēliciōsum" "delicious"
   "deī" "god, diety"
   "dēpreco, dēprecāre, dēprecāvī, dēprecātus" "to pray"
   "dēprecor" "I prayed"
   "dēprecātiō, dēprecātiōnis" "deprecation; averting by prayer"
   "dēprecātiōnum" "of deprecations"
   "dēprecāvisset" "they (might) have had prayed"
   "deum" "god"
   "deus" "god"
   "deus, deī" "god, diety"
   "dīcēns" "saying"
   "dīcō, dīcere, dīxī, dictus" "to say"
   "diēs" "day"
   "diē" "day"
   "diēs, diēī" "day"
   "dīgnēris" "you (might) be deemed worthy"
   "dignitās, dignitātis" "worth, honor, esteem, rank"
   "dignitātis" "worth, honor, esteem, rank"
   "dīgnō, dīgnāre, dīgnavī, dīgnatus" "to deem worthy, to deign"
   "dīxērunt" "they said"
   "dīxisset" "he (might) have had said"
   "dīxit" "he said"
   "dedit" "he gave"
   "dispendia" "pay, nourishment"
   "dispendium, dispendiī" "pay, nourishment, expense, cost"
   "dō, dare, dedī, datum" "to give (irregular)"
   "dominus" "lord, master"
   "dominus, dominī" "lord, master"
   "ego" "I"
   "eius" "his, hers, its"
   "erant" "they were"
   "erat" "he was"
   "est" "he is"
   "fābula" "story"
   "fābulam" "story"
   "fābula, fābulae" "story"
   "faciō, facere, fēcī, factus" "to do, to make"
   "fēcērunt" "they did, they made"
   "fēcī" "I did, I made"
   "fīliī" "sons"
   "fīlium" "son"
   "fīlius, fīlī" "son"
   "flōribus" "flowers"
   "flōs, flōris" "flower"
   "flūmen" "river"
   "flūminis" "river"
   "flūmen, flūminis" "river"
   "fōns" "fountain"
   "fōns, fontis" "fountain"
   "fonte" "fountain"
   "fontem" "fountain"
   "frātrēs" "brothers"
   "fretō" "strait, channel"
   "fretum, fretī" "strait, channel"
   "fūnēs" "ropes"
   "fūnis, fūnis" "rope"
   "habēbat" "he had"
   "habeō, habēre, habuī, habitus" "to have"
   "habuissēmus" "we (might) have had"
   "habuit" "he had"
   "herbōsam" "grassy, herbaceous"
   "herbōsus" "grassy, herbaceous"
   "ībimus" "we will go"
   "incōgnitōrum" "unknown, untested"
   "incōgnitus, incōgnita, incōgnitum" "unknown, untested"
   "īnsula" "island"
   "īnsula, īnsulae" "island"
   "īnsulae" "island"
   "īnsulam" "island"
   "interveniente" "come between, intervene"
   "invēnērunt" "they found"
   "inveniō, invenīre, invēnī, inventum" "to find"
   "īre" "to go"
   "ita" "yes; in this manner"
   "iter" "journey, trip"
   "iter, itineris" "journey, trip"
   "iūnctam" "connected, joined"
   "Iēsūs" "Jesus"
   "iēsūs" "Jesus"
   "Jēsūs, Jēsū" "Jesus"
   "lātitūdō" "breadth, width, latitude"
   "lātitūdō, lātitūdinis" "breadth, width, latitude"
   "lātum" "wide"
   "lātus, lāta, lātum" "wide"
   "locum" "place"
   "locus, locī" "place"
   "lūx" "light"
   "lūx, lūcis" "light"
   "māgnō" "large"
   "māgnus, māgna -um, major -or -us, maximus -a -um" "large"
   "manendum" "remaining"
   "maneō, manēre, mānsī, mānsus" "to remain"
   "mare" "sea"
   "mare, maris" "sea"
   "merīdiānam" "noon, southern"
   "merīdiānum" "noon, southern"
   "merīdiānus" "noon, southern"
   "mīliāriī" "milestone"
   "mīliārium, mīliāriī" "milestone"
   "mīsērunt" "they sent"
   "mittō, mittere, mīsī, missus" "to send"
   "monachus" "monk"
   "monachus, monachī" "monk"
   "multus, multa -um, -, plūrimus -a -um" "many"
   "nāvem" "boat"
   "nāvī" "boat"
   "nāvigā" "sail (imperative)"
   "nāvigantibus" "navigating"
   "nāvigāre" "to sail"
   "nāvigō, nāvigāre, nāvigāvī, nāvigātus" "to sail, to navigate"
   "nāvigāvērunt" "they sailed"
   "navigavissent" "they (might) have navigated"
   "nāvim" "boat"
   "nāvis" "boat"
   "nāvis, nāvis" "boat"
   "nebula, nebulae" "fog, cloud"
   "nebulam" "fog, cloud"
   "nemorōsam" "woody, shaded"
   "nemorōsus" "woody, shaded"
   "nemorōsus, nemorōsa, nemorōsum" "woody, shaded"
   "nōmen" "name"
   "nōmen, nōminis" "name"
   "noster" "our"
   "noster, nostra, nostrum" "our"
   "nox" "night"
   "nox, noctis" "night"
   "occīdī" "I killed"
   "occīdō" "I kill"
   "occīdō, occīdere, occīdī, occīsus" "to kill"
   "ōrāvērunt" "they prayed"
   "ōrō, ōrāre, ōrāvī, ōrātus" "to pray"
   "paradīsus, paradīsī" "paradise"
   "paradīsus" "paradise"
   "pater" "father"
   "pater, patris" "father"
   "plāgam" "coast"
   "plāga, plāgae" "coast"
   "plēnam" "full"
   "plēnum" "full"
   "plēnus, plēna -um, plēnior -or -us, plēnissimus -a -um" "full"
   "porta, portae" "door, entrance"
   "portum" "harbor, port"
   "portus, portūs" "harbor, port"
   "possum, posse, potuī, -" "to be able (irregular)"
   "potuī" "I was able"
   "potuit" "he was able"
   "potuērunt" "they were able"
   "potuissent" "they (might) have had been able"
   "praecipiō, praecipere, praecēpī, praeceptus" "to order"
   "praecēpit" "he ordered"
   "praedictus" "the aforesaid"
   "praedīcō, praedīcere, praedīxī, praedictus" "to say before"
   "reprōmissiō, reprōmissiōnis" "promise"
   "reprōmissiōnis" "promise"
   "revertērunt" "they returned"
   "revertō, revertere, revertī, reversum" "to return"
   "sedēbat" "he was sitting"
   "sedēbant" "they were sitting"
   "sedeō, sedēre, sēdī, sessus" "to sit"
   "spatium" "space"
   "spatium, spatiī" "space"
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
    (or
     (dictionary-override v)
     (dictionary-override (clojure.string/lower-case v))
     (dictionary-override (clojure.string/upper-case v))
     (dictionary-map v)
     (dictionary-map (clojure.string/lower-case v))
     (dictionary-map (clojure.string/upper-case v)))))

(def macronized-words
  (into {} (map (fn [v]
                  {(remove-macrons v) v})
                (concat (keys dictionary-map) (keys dictionary-override)))))
