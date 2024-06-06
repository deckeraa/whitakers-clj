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
      (clojure.string/replace #"Ū" "U")
      (clojure.string/replace #"ȳ" "y")))

(def dictionary-override
  {"ā" "from, out of, by, since"
   "ad" "to, towards, at, according to"
   "adhūc" "until now"
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
   "ē" "out of, from"
   "ex" "out of, from"
   "ecce" "Look! Behold!"
   "eius" "his/her/its"
   "esse" "to be"
   "et" "and"
   "exceptō" "except"
   "haec" "this, these; singular feminine nominative or plural neuter nom. or acc. of hic, haec, hoc"
   "hic" "this; singuglar masculine nominative of hic, haec, hoc"
   "hierusalem" "Jerusalem"
   "hodiē" "today"
   "ibī" "there, then"
   "id" "it"
   "illa" "that; singular feminine nominative from ille, illa, illud"
   "illam" "that; singular feminine accusative from ille, illa, illud"
   "illārum" "that; plural feminine genitive from ille, illa, illud"
   "illīs" "those; plural dative or ablative from ille, illa, illud"
   "illīus" "of that; singular genitive from ille, illa, illud"
   "illud" "that; singular neuter nominative or accusative from ille, illa, illud"
   "illum" "that; singular feminine accusative from ille, illa, illud"
   "in" "into (with accusative), in (with ablative)"
   "intrā" "within, between, during"
   "īre" "to go; present infinitive from eō, īre, iī, itus (irregular)"
   "istae" "those; plural feminine nominative from iste, ista, istud"
   "istō" "that; singular masculine or neuter ablative from iste, ista, istud"
   "istum" "that; singular masculine accusative from iste, ista, istud"
   "ita" "yes"
   "iuxtā" "near, nearly"
   "mē" "to me, accusative from ego"
   "mēcum" "with me (mē + cum)"
   "minimē" "barely, no, not"
   "nimis" "too much, extremely"
   "nōbīs" "us; singular dative or ablative from ego"
   "nōn" "not"
   "nōs" "us; plural nominative or accusative of ego"
   "nunc" "now"
   "per" "through"
   "plūs" "more, from mūltus"
   "porrō" "farther, further, also"
   "pōtum" "drink; singular masculine accusative from pōtus, pōtūs"
   "prae" "before, in front, because of"
   "prō" "for, in favor of, before, in place of"
   "prope" "near, close"
   "quā" "what; singular female ablative of qui"
   "quae" "who; plural female nom. or neuter nom. or acc. of quis"
   "quī" "who; plural masculine nominative of quis"
   "quid" "who; singular neuter nom. or acc. of quis"
   "quod" "what; singular neuter nom. or acc. of qui"
   "quadrāgintā" "40"
   "quaerere" "to seek"
   "quaerō, quaerere, quaesīvī, quaesītus" "to seek"
   "quantum" "how much?"
   "quantus" "how much?"
   "quantus, quanta, quantum" "how much?"
   "quasi" "as if, like, as much as"
   "quattuordecim" "14"
   "quia" "because"
   "recordātus" "rememberance, recollection"
   "recordātus, recordātūs" "rememberance, recollection"
   "resurrēctiō, resurrēctiōnis" "resurrection"
   "resurrēctiōne" "resurrection"
   "rīvulum" "rivulet, small brook"
   "rīvulus, rīvulī" "rivulet, small brook"
   "sāncta" "holy, saint"
   "sānctus" "holy, saint"
   "sānctōrum" "of the saints; plural masculine gentive from sānctus, sānctī"
   "sānctum" "holy, saint"
   "scīs" "you know; 2nd person singular present from sciō, scīre, scīvī, scītum"
   "sēcrētum" "secret; singular neuter nominative or accusative from sēcrētum, sēcrētī"
   "se" "himself"
   "sed" "but"
   "sī" "if"
   "sibi" "to himself; singular dative of se"
   "sīcut" "as, same as, like"
   "statim" "immediately"
   "sua" "her/its; sing. fem. nom. or abl. or neuter nom. or acc. from suus"
   "sufficere" "to be sufficient"
   "sufficiō, sufficere, suffēcī, suffectum" "to be sufficient"
   "suis" "their; plural dative or ablative of suus"
   "summitās, summitātis" "summit, top"
   "summitātem" "summit, top"
   "super" "above, on top of"
   "Syon" "Zion"
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
   "unde" "from where?"
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
   "accipimus" "we accept, we take"
   "accipiō, accipere, accēpī, acceptus" "to take, to grasp, to receive, to accept"
   "addidit" "he added"
   "addō, addere, addidī, additus" "to add"
   "āēr, āeris" "air"
   "āeris" "air"
   "āgnōscō, āgnōscere, āgnōvī, āgnitus" "to recognize, to realize, to acknowledge"
   "āgnōvit" "he recognized, he realized"
   "āit" "he said"
   "āiere" "to speak, to affirm"
   "āla, ālae" "wing"
   "ālae" "wings"
   "ālārum" "of wings"
   "ālās" "wings"
   "alia" "other"
   "aliās" "others"
   "aliī" "others"
   "aliēnāvit" "he alienated"
   "aliēnō, aliēnāre, aliēnāvī, aliēnātus" "to alienate, to give up"
   "aliōrum" "of others"
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
   "annus, annī" "year"
   "annō" "year"
   "annum" "year"
   "antīquī" "of the ancient"
   "antīquus, antīqua -um, antīquior -or -us, antīquissimus -a -um" "antique"
   "appāreō, appārēre, appāruī, appāritus" "to appear";; no past perfect participle?
   "appāruit" "he appeared"
   "appropinquō, appropinquāre, appropinquāvī, appropinquātus" "to approach"
   "appropinquāvisset" "he (might) have had approached"
   "arbor" "tree"
   "arbor, arboris" "tree"
   "arbōre" "tree"
   "arbōrēs" "trees"
   "ascendentibus" "ascending"
   "ascendō, ascendere, ascendī, ascēnsus" "to ascend"
   "aspicere" "to look at, to contemplate"
   "aspiciō, aspicere, aspēxī, aspectus" "to look at, to contemplate"
   "avem" "bird"
   "avis" "bird"
   "avis, avis" "bird"
   "avium" "of birds"
   "avibus" "birds"
   "Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "candidus, candida -um, candidior -or -us, candidissimus -a -um" "bright, white, clean"
   "candidissimīs" "most bright/white, very bright/white"
   "candidissimus" "most bright/white, very bright/white"
   "cantāre" "to sing"
   "cantāvērunt" "they sang"
   "cantō, cantāre, cantāvī, cantātus" "to sing"
   "carmen" "song, poem, prayer"
   "carmen, carminis" "song, poem, prayer"
   "causa, causae" "cause, reason"
   "causa" "cause, reason"
   "celebrābis" "you will celebrate"
   "celebrāvistī" "you celebrated"
   "celebrō, celebrāre, celebrāvī, celebrātus" "to celebrate"
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
   "commorāmur" "we dwell"
   "commoro, commorare, commoravi, commoratus" "to dwell on"
   "cōnsēnsū" "consensus"
   "cōnsēnsus, cōnsēnsūs" "consensus"
   "cōnsentiō, cōnsentīre, cōnsēnsī, cōnsēnsus" "to be in agreement"
   "cōnsortiō" "fellowship"
   "cōnsortiō, cōnsortiōnis" "fellowship"
   "contigit" "to come to, to touch"
   "contingō, contingere, contigī, contāctus" "to come to, to touch"
   "cooperta" "covered"
   "cooperiō, cooperīre, cooperuī, coopertus" "to cover"
   "cooperuērunt" "they covered"
   "cor, cordis" "heart"
   "corde" "heart"
   "cordis" "heart"
   "corpus" "body, flesh"
   "corpum" "body, flesh"
   "corpora" "bodies, flesh"
   "corpus, corporis" "body, flesh"
   "creātor, creātōris" "creator"
   "creātōrem" "creator"
   "creō, creāre, creāvī, creātum" "to create"
   "creātī" "of the thing created"
   "crēdō" "I believe"
   "crēdō, crēdere, crēdidī, crēditum" "to believe"
   "dēbēs" "you should"
   "dēbeō, dēbēre, dēbuī, dēbitus" "to owe, to ought"
   "decet" "it is fitting"
   "decet, decēre, decuit, -" "it is fitting"
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
   "dīcentēs" "saying"
   "dīcō, dīcere, dīxī, dictus" "to say"
   "diēs" "day"
   "diē" "day"
   "diēbus" "days"
   "diēs, diēī" "day"
   "dīgnēris" "you (might) be deemed worthy"
   "dignitās, dignitātis" "worth, honor, esteem, rank"
   "dignitātis" "worth, honor, esteem, rank"
   "dīgnō, dīgnāre, dīgnavī, dīgnatus" "to deem worthy, to deign"
   "dīversās" "diverse"
   "dīversus" "diverse"
   "dīversus, dīversa, dīversum" "diverse"
   "dīxērunt" "they said"
   "dīxisset" "he (might) have had said"
   "dīxit" "he said"
   "dedit" "he gave"
   "dispendia" "pay, nourishment"
   "dispendium, dispendiī" "pay, nourishment, expense, cost"
   "dō, dare, dedī, datum" "to give (irregular)"
   "dominicīs" "Sundays"
   "Dominica, Dominicae" "Sunday"
   "dominus" "lord, master"
   "dominus, dominī" "lord, master"
   "effundō, effundere, effūdī, effūsus" "to pour out"
   "effūdisset" "he (might) have had poured out"
   "ego" "I"
   "eius" "his, hers, its"
   "eō" "I go"
   "erant" "they were"
   "erat" "he was"
   "es" "you are"
   "esset" "he (might) have been"
   "est" "he is"
   "extendere" "to extend"
   "extendō, extendere, extendī, extentus" "to extend"
   "fābula" "story"
   "fābulam" "story"
   "fābula, fābulae" "story"
   "faciō, facere, fēcī, factus" "to do, to make"
   "fēcērunt" "they did, they made"
   "fēcī" "I did, I made"
   "fīliī" "sons"
   "fīlium" "son"
   "fīlius, fīlī" "son"
   "firmāmentī" "strengthening, support"
   "firmāmentum, firmāmentī" "strengthening, support"
   "flōribus" "flowers"
   "flōs, flōris" "flower"
   "flūmen" "river"
   "flūminis" "river"
   "flūmen, flūminis" "river"
   "folia" "leaves"
   "folium, foliī" "leaf"
   "fōns" "fountain"
   "fōns, fontis" "fountain"
   "fonte" "fountain"
   "fontem" "fountain"
   "frāter" "brother"
   "frāter, frātris" "brother"
   "frātrēs" "brothers"
   "frātribus" "brothers"
   "fretō" "strait, channel"
   "fretum, fretī" "strait, channel"
   "fuimus" "we were"
   "fuisset" "he (might) have had been"
   "fūnēs" "ropes"
   "fūnis, fūnis" "rope"
   "genibus" "knee"
   "genu, genūs" "knee"
   "gȳrum" "circle, ring, circuit, course"
   "gȳrus, gȳrī" "circle, ring, circuit, course"
   "habēbat" "he had"
   "habeō, habēre, habuī, habitus" "to have"
   "habēs" "you have"
   "habuissēmus" "we (might) have had"
   "habuit" "he had"
   "herbōsam" "grassy, herbaceous"
   "herbōsus" "grassy, herbaceous"
   "hōra" "hour, time"
   "hōrae" "hour, time"
   "hōra, hōrae" "hour, time"
   "hostis" "enemy"
   "hostis, hostis" "enemy"
   "hymnus" "hymn"
   "hymnus, hymnī" "hymn"
   "ībimus" "we will go"
   "incōgnitōrum" "unknown, untested"
   "incōgnitus, incōgnita, incōgnitum" "unknown, untested"
   "īnsula" "island"
   "īnsula, īnsulae" "island"
   "īnsulae" "island"
   "īnsulam" "island"
   "interveniente" "come between, intervene"
   "invēnērunt" "they found"
   "inveniēs" "you will find"
   "inveniō, invenīre, invēnī, inventum" "to find"
   "īre" "to go"
   "ita" "yes; in this manner"
   "iter" "journey, trip"
   "iter, itineris" "journey, trip"
   "itinere" "journey, trip"
   "iūdex, iūdicis" "judge"
   "iūdicem" "judge"
   "iūnctam" "connected, joined"
   "Iēsūs" "Jesus"
   "iēsūs" "Jesus"
   "Jēsūs, Jēsū" "Jesus"
   "iūstus" "just"
   "jūstus, jūsta -um, jūstior -or -us, jūstissimus -a -um" "just"
   "iūdicium" "judgement"
   "iūdicium, iūdiciī" "judgement"
   "lacrima, lacrimae" "tear"
   "lacrimās" "tears"
   "lāpsum" "fall, slipping"
   "lāpsus" "fall, slipping"
   "lāpsus, lāpsūs" "fall, slipping"
   "laetitia, laetitiae" "joy, gladness, fruitfulness"
   "laetitiae" "joy, gladness, fruitfulness"
   "lātitūdinis" "breadth, width, latitude"
   "lātitūdō" "breadth, width, latitude"
   "lātitūdō, lātitūdinis" "breadth, width, latitude"
   "lātum" "wide"
   "latera" "side"
   "latus, lateris" "side"
   "lātus, lāta, lātum" "wide"
   "laudāmus" "we praise"
   "laudō, laudāre, laudāvī, laudātus" "to praise"
   "levāvit" "he raised up"
   "locum" "place"
   "locus, locī" "place"
   "lūx" "light"
   "lūx, lūcis" "light"
   "māgna" "large"
   "māgnam" "large"
   "māgnō" "large"
   "māgnum" "large"
   "māgnus, māgna -um, major -or -us, maximus -a -um" "large"
   "māiestās, māiestātis" "majesty"
   "māiestātem" "majesty"
   "manendum" "remaining"
   "maneō, manēre, mānsī, mānsus" "to remain"
   "mare" "sea"
   "mare, maris" "sea"
   "meī" "my"
   "meīs" "my"
   "mihī" "to me"
   "merīdiānam" "noon, southern"
   "merīdiānum" "noon, southern"
   "merīdiānus" "noon, southern"
   "mereō, merēre, meruī, meritus" "to earn, to deserve"
   "meritī" "merited"
   "mīliāriī" "milestone"
   "mīliārium, mīliāriī" "milestone"
   "mīrae" "wonderful, marvelous"
   "mīrus, mīra, mīrum" "wonderful, marvelous"
   "misericordia, misericordiae" "pity, compassion, mercy"
   "misericordiam" "pity, compassion, mercy"
   "mīsērunt" "they sent"
   "mīsit" "he sent"
   "mittō, mittere, mīsī, missus" "to send"
   "mittuntur" "they are being sent"
   "modō" "mode, manner, way, measure, size"
   "modulātiō, modulātiōnis" "melody, modulation"
   "modulātiō" "melody, modulation"
   "modus, modī" "mode, manner, way, measure, size"
   "monachus" "monk"
   "monachus, monachī" "monk"
   "multitūdō" "multitude, great number"
   "multitūdō, multitūdinis" "multitude, great number"
   "multus, multa -um, -, plūrimus -a -um" "many"
   "nārrā" "narrate!"
   "nārrō, nārrāre, nārrāvī, nārrātus" "to narrate, to tell about"
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
   "nostra" "our"
   "nox" "night"
   "nox, noctis" "night"
   "nūntius" "messenger"
   "nūntius, nūntiī" "messenger"
   "occīdī" "I killed"
   "occīdō" "I kill"
   "occīdō, occīdere, occīdī, occīsus" "to kill"
   "oculīs" "eyes"
   "oculus, oculī" "eye"
   "omnēs" "all, every"
   "omnī" "all, every"
   "omnis, omnis, omne" "all, every"
   "omnium" "of all"
   "ōrāvērunt" "they prayed"
   "ōrō, ōrāre, ōrāvī, ōrātus" "to pray"
   "paradīsus, paradīsī" "paradise"
   "paradīsus" "paradise"
   "pars, partis" "part"
   "partēs" "parts"
   "pascha" "Passover, Easter"
   "pascha, paschae" "Passover, Easter"
   "pater" "father"
   "pater, patris" "father"
   "patrem" "father"
   "peccātōrī" "sinner"
   "peccātor, peccātōris" "sinner"
   "peccandō" "sinning"
   "peccō, peccāre, peccāvī, peccātus" "to sin"
   "percutiō, percutere, percussī, percussus" "to strike, to beat"
   "percutientēs" "striking, beating"
   "placidō" "placid, gentle, quiet"
   "placidus, placida, placidum" "placid, gentle, quiet"
   "plāgam" "coast"
   "plāga, plāgae" "coast"
   "plānctus" "beating, wailing, lamentation"
   "plānctūs" "beating, wailing, lamentation"
   "plānctus, plānctūs" "beating, wailing, lamentation"
   "plēnam" "full"
   "plēnum" "full"
   "plēnus, plēna -um, plēnior -or -us, plēnissimus -a -um" "full"
   "poena, poenae" "penalty, punishment"
   "poenās" "penalty, punishment"
   "porta, portae" "door, entrance"
   "portum" "harbor, port"
   "portus, portūs" "harbor, port"
   "possum, posse, potuī, -" "to be able (irregular)"
   "possumus" "we are able to"
   "potuī" "I was able"
   "potuit" "he was able"
   "potuērunt" "they were able"
   "potuisset" "he (might) have had been able"
   "potuissent" "they (might) have had been able"
   "praecipiō, praecipere, praecēpī, praeceptus" "to order"
   "praecēpit" "he ordered"
   "praedictus" "the aforesaid"
   "praedīcō, praedīcere, praedīxī, praedictus" "to say before"
   "praesentia, praesentiae" "present time"
   "praesentiam" "present time"
   "praesūmō" "to presume, to anticipate"
   "praesūmō, praesūmere, praesūmpsī, praesūmptus" "to presume, to anticipate"
   "prōra, prōrae" "prow"
   "prōrae" "prow"
   "prōvolō, prōvolāre, prōvolāvī, prōvolātus" "to fly forward"
   "prōvolūtīs" "fallen, rolled"
   "prōvolvō, prōvolvere, prōvolvī, prōvolūtus" "to roll forward, to bowl over"
   "rāmī" "branches"
   "rāmus, rāmī" "branch"
   "reprōmissiō, reprōmissiōnis" "promise"
   "reprōmissiōnis" "promise"
   "rē" "thing"
   "rēs, reī" "thing"
   "resideō, residēre, resēdī, resessus" "to sit down, to settle"
   "resēdisset" "he (might) have had sat down"
   "revēlō, revēlāre, revēlāvī, revēlātus" "to show, to reveal"
   "revēlāre" "to reveal"
   "revēlātor" "revealer"
   "revertērunt" "they returned"
   "revertō, revertere, revertī, reversum" "to return"
   "ruīna" "collapse, ruin, destruction"
   "ruīna, ruīnae" "collapse, ruin, destruction"
   "satelles, satellitis" "attendant, guard, assistant"
   "satellitibus" "attendants, guards, assistants"
   "sēcrētum, sēcrētī" "secret"
   "sedēbat" "he was sitting"
   "sedēbant" "they were sitting"
   "sedeō, sedēre, sēdī, sessus" "to sit"
   "sēdit" "he sat"
   "signō" "sign"
   "signum, signī" "sign"
   "sit" "he (might) be"
   "sonābant" "they were making sounds"
   "sono, sonare, sonavi, sonatus" "to make a sound"
   "spatium" "space"
   "spatium, spatiī" "space"
   "stetērunt" "they stood"
   "stō, stāre, stetī, status" "to stand, to remain"
   "sum, esse, fuī, futūrus" "to be (irregular)"
   "summitās, summitātis" "summit, top"
   "summitāte" "summit, top"
   "sumus" "we are"
   "sunt" "they are"
   "sustinēmus" "we sustain"
   "sustineō, sustinēre, sustinuī, sustentus" "to sustain"
   "suum" "his"
   "taedium" "weariness, tedium"
   "taedium, taediī" "weariness, tedium"
   "tanta" "so much, so great, this many"
   "tantum" "so much, so great, this many"
   "tantus, tanta, tantum" "so much, so great, this many"
   "terra" "land"
   "terra, terrae" "land"
   "tintinnābulum" "bell"
   "tintinnābulum, tintinnābulī" "bell"
   "tractāre" "to haul, to drag, to handle, to discuss"
   "tractō, tractāre, tractāvī, tractātum" "to haul, to drag, to handle, to discuss"
   "trāns" "across, beyond"
   "tu" "you"
   "tuae" "your"
   "tuam" "your"
   "tuum" "your"
   "ūna" "one"
   "ūnus -a -um, prīmus -a -um, singulī -ae -a, semel" "one"
   "vēnērunt" "they came"
   "veniō, venīre, vēnī, ventus" "to come"
   "vēnit" "he came"
   "vērāx" "true"
   "vērāx, vērācis (gen.), vērācior -or -us, vērācissimus -a -um" "true"
   "vestīmenta" "clothes"
   "vestīmentum, vestīmentī" "clothing, clothes"
   "videō" "I see"
   "videō, vidēre, vīdī, vīsus" "to see"
   "vidēre" "to see"
   "vīdit" "he saw"
   "vīdērunt" "they saw"
   "vidērentur" "he (may) have appeared"
   "vīdisset" "he (might) have had seen"
   "vīdissent" "they (might) have had seen"
   "vir" "man"
   "vir, virī" "man"
   "vīvēbat" "he was living"
   "vīvō, vīvere, vīxī, vīctus" "to live"
   "volēbant" "they were wanting"
   "volō" "I want"
   "volō, velle, voluī, -" "to want"
   "volābat" "he was flying"
   "volō, volāre, volāvī, volātus" "to fly"
   "vultū" "face, expression, appearance"
   "vultus, vultūs" "face, expression, appearance"
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
