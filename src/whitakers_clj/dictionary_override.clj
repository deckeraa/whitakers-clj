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
   "Ailbēī" "The name of a group of monks living on an island."
   "aliam" "other, another; singular feminine accusative from alius, alia, aliud"
   "aliquid" "someone"
   "ante" "before, in front, forwards"
   "anteā" "before"
   "at" "and"
   "atque" "and"
   "aut" "or"
   "autem" "but, however, moreover"
   "avēs" "birds; plural feminine nominative or accusative from avis, avis"
   "avium" "of birds; plural feminine genitive from avis, avis"
   "Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "candida" "bright, white, clean; singular feminine nominative from candidus, candida, candidum"
   "citō" "quickly"
   "coepērunt" "they started; from coepī, coepisse, coepī, coeptum"
   "commorantur" "they dwell, 3rd person present of commoror, commorārī, commorātum (dep.)"
   "contrā" "against, away from, facing"
   "cōram" "in the presence of"
   "cum" "with"
   "de" "of, from, away from, down from"
   "dum" "while, as long as, until"
   "duo" "two"
   "ē" "out of, from"
   "ex" "out of, from"
   "ecce" "Look! Behold!"
   "eius" "his/her/its"
   "enim" "for, truly, really, indeed"
   "esse" "to be"
   "et" "and"
   "eum" "to him; singular masculine accusative from is, ea, id"
   "exceptō" "except"
   "fīnītā" "end"
   "fīnītīs" "end"
   "forās" "outside (adverb)"
   "fūrtim" "secret, stealthily"
   "haec" "this, these; singular feminine nominative or plural neuter nom. or acc. of hic, haec, hoc"
   "hic" "this; singuglar masculine nominative of hic, haec, hoc"
   "hīs" "to these; plural masculine dative or ablative of hic, haec, hoc"
   "hierusalem" "Jerusalem"
   "hōc" "this; sing. masc. or neut. abl. of hic, haec, hoc"
   "hodiē" "today"
   "hūc" "toward here"
   "iam" "already, now, soon"
   "Iascōniī" "of Jasconius (the sea creature); singular masculine genitive from Iascōnius"
   "Iascōnius" "Jasconius, a large sea creature"
   "ibī" "there, then"
   "ibīdem" "in the same place"
   "id" "it"
   "igitur" "therefore"
   "illa" "that; singular feminine nominative from ille, illa, illud"
   "illam" "that; singular feminine accusative from ille, illa, illud"
   "illārum" "that; plural feminine genitive from ille, illa, illud"
   "illīs" "those; plural dative or ablative from ille, illa, illud"
   "illīus" "of that; singular genitive from ille, illa, illud"
   "illō" "these; singular masculine or neuter ablative from ille, illa, illud"
   "illōrum" "of those; plural masculine or neuter genitive from ille, illa, illud"
   "illōs" "that; plural masculine accusative from ille, illa, illud"
   "illud" "that; singular neuter nominative or accusative from ille, illa, illud"
   "illum" "that; singular feminine accusative from ille, illa, illud"
   "illūc" "over there"
   "in" "into (with accusative), in (with ablative)"
   "intrā" "within, between, during"
   "īre" "to go; present infinitive from eō, īre, iī, itus (irregular)"
   "istae" "those; plural feminine nominative from iste, ista, istud"
   "istō" "that; singular masculine or neuter ablative from iste, ista, istud"
   "istud" "that; singuglar neuter nominative and accusative from iste, ista, istud"
   "istum" "that; singular masculine accusative from iste, ista, istud"
   "ita" "yes"
   "itaque" "so then, therefore"
   "iuxtā" "near, nearly"
   "locūtus" "locūtus est = he spoke"
   "mē" "to me, accusative from ego"
   "mēcum" "with me (mē + cum)"
   "minimē" "barely, no, not"
   "namque" "for and in fact, on the other hand"
   "nātūra, nātūrae" "nature, quality"
   "nātūram" "nature, quality"
   "nec" "nor, not either"
   "necessāria" "necessities of life"
   "necessāria, necessāriōrum" "necessities of life"
   "nihil" "not at all"
   "nimia" "too much"
   "nimis" "too much, extremely"
   "nisī" "if not, unless"
   "nōbīs" "us; singular dative or ablative from ego"
   "nōlīte" "be unwilling! imperative plural of nōlō, nōlle, nōluī (irr.)"
   "nōn" "not"
   "nōnam" "the 9th"
   "nōs" "us; plural nominative or accusative of ego"
   "nostrae" "our; singular feminine genitive or dative of noster"
   "nostrī" "our; sing. masc. gen. or pl. masc. nom. or sing. neut. gen. of noster"
   "nostrō" "our"
   "nostrum" "our; plural genitive of ego"
   "nunc" "now"
   "octāvās" "octave, 8th"
   "octāvus, octāvī" "octave, 8th"
   "octāvum" "octave, 8th"
   "octāvus" "octave, 8th"
   "paene" "almost"
   "per" "through"
   "perfīnīta" "perfīnīta + est: it has been finished"
   "plūs" "more, from mūltus"
   "porrō" "farther, further, also"
   "post" "behind, after, since"
   "posteā" "thereafter, later"
   "pōtū" "drink; singular masculine ablative from pōtus, pōtūs"
   "pōtum" "drink; singular masculine accusative from pōtus, pōtūs"
   "prae" "before, in front, because of"
   "praeteritō" "previous"
   "praeteritum" "previous"
   "prius" "before"
   "prō" "for, in favor of, before, in place of"
   "prope" "near, close"
   "quā" "what; singular female ablative of qui"
   "quae" "who; plural female nom. or neuter nom. or acc. of quis"
   "quam" "how? how much?"
   "quattuor" "4"
   "quī" "who; plural masculine nominative of quis"
   "quid" "who; singular neuter nom. or acc. of quis"
   "quisquis" "whatever"
   "quod" "what; singular neuter nom. or acc. of qui"
   "quō" "what; singular ablative of quis"
   "quōs" "who; plural masculine accusative of quis"
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
   "reversa" "reversa + est = it returned"
   "reversus" "reversus + est = he returned"
   "rīvulum" "rivulet, small brook"
   "rīvulus, rīvulī" "rivulet, small brook"
   "sāncta" "holy, saint"
   "sānctus" "holy, saint"
   "sānctae" "holy"
   "sānctī" "holy"
   "sānctīs" "holy"
   "sānctō" "holy"
   "sānctōrum" "of the saints; plural masculine gentive from sānctus, sānctī"
   "sānctum" "holy, saint"
   "sapienter" "wisely"
   "scīs" "you know; 2nd person singular present from sciō, scīre, scīvī, scītum"
   "sēcrētum" "secret; singular neuter nominative or accusative from sēcrētum, sēcrētī"
   "se" "himself"
   "sed" "but"
   "semper" "always"
   "sex" "six"
   "sextam" "sixth"
   "sī" "if"
   "sibi" "to himself; singular dative of se"
   "sīcut" "as, same as, like"
   "similiter" "similarly"
   "simul" "at the same time as"
   "spontāneē" "spontaneously"
   "statim" "immediately"
   "sua" "her/its; sing. fem. nom. or abl. or neuter nom. or acc. from suus"
   "sufficere" "to be sufficient"
   "sufficiō, sufficere, suffēcī, suffectum" "to be sufficient"
   "sufficienter" "sufficiently"
   "suōs" "their; plural accusative of suus"
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
   "tibi" "to you, singular dative of tu"
   "trahō, trahere, trāxī, tractum" "to draw, to drag, to haul"
   "trāxissent" "they (might) have had drawn"
   "trīduum, trīduī" "three days"
   "trīduum" "three days"
   "tunc" "then"
   "ubī" "where, when if"
   "unde" "from where?"
   "ūniūs" "of one (genitive of ūnus)"
   "ūnus" "one"
   "ūsque" "until, all the way, up until"
   "ut" "so that"
   "valdē" "very"
   "vel" "or"
   "veniō, venīre, vēnī, ventus" "to come"
   "vēnērant" "they had came"
   "vēnissent" "they (might) have had come"
   "vergō, vergere, -, -" "to lay, to incline, to slope"
   "vergentem" "laying"
   "vērō" "truly, even so, still"
   "vestra" "your"
   "vīctū" "food; singular masculine ablative from victus, victūs"
   "vīctum" "food; singular masculine accussative from victus, victūs"
   "videō, vidēre, vīdī, vīsus" "to see"
   "vīdērunt" "they saw"
   "vīgintī" "20"
   "vōbīs" "you; plural dative or ablative from tu"
   "vōtum" "vow"
   })

(def dictionary-map
  {"abbās" "abbot"
   "abbās, abbātis" "abbot"
   "abscondō, abscondere, abscondī, absconditus" "to hide, to conceal"
   "absconditōrum" "of things hidden"
   "abstinentia" "abstinence, self-restraint"
   "abstinentia, abstinentiae" "abstinence, self-restraint"
   "acceptā" "having been accepted"
   "accipiamus" "let us accept"
   "accipimus" "we accept, we take"
   "accipiō, accipere, accēpī, acceptus" "to take, to grasp, to receive, to accept"
   "accipite" "accept! receive!"
   "addidit" "he added"
   "addō, addere, addidī, additus" "to add"
   "adiūtōrium" "help, support"
   "adiūtōrium, adiūtōriī" "help, support"
   "aequālī" "equal"
   "aequālis, aequāle, aequālior -or -us, aequālissimus -a -um" "equal"
   "aequor" "level surface"
   "aequor, aequōris" "level surface"
   "aequōra" "level surfaces"
   "āēr, āeris" "air"
   "āeris" "air"
   "agitābātur" "to be stirred up"
   "agitō, agitāre, agitāvī, agitātus" "to act, to put in motion"
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
   "alimōnia" "food, nourishment"
   "alimōnia, alimōniae" "food, nourishment"
   "ālīs" "wings"
   "aliēnāvit" "he alienated"
   "aliēnō, aliēnāre, aliēnāvī, aliēnātus" "to alienate, to give up"
   "aliōrum" "of others"
   "alium" "other"
   "alius, alia, aliud" "other"
   "alter" "the other"
   "alter, altera, alterum" "the other"
   "altitūdinis" "height, depth"
   "altitūdō, altitūdinis" "height, depth"
   "alveum" "cavity, trough"
   "alveus, alveī" "cavity, trough"
   "ambulābant" "they were walking"
   "ambulō, ambulāre, ambulāvī, ambulātus" "to walk"
   "amīcus" "friend"
   "amīcus, amīcī" "friend"
   "angelī" "angel"
   "angelus, angelī" "angel"
   "angustiam" "small space, narrow passage, being boxed in"
   "angustia, angustiae" "small space, narrow passage, being boxed in"
   "angustum, angustī" "small space, narrow passage, being boxed in"
   "angustus" "small space, narrow passage, being boxed in"
   "anima, animae" "soul, mind, life"
   "animae" "soul, mind, life"
   "annus, annī" "year"
   "annō" "year"
   "annum" "year"
   "antīquī" "of the ancient"
   "antīquus, antīqua -um, antīquior -or -us, antīquissimus -a -um" "antique"
   "aperiō, aperīre, aperuī, apertus" "to open"
   "aperiēs" "you will open"
   "appāreō, appārēre, appāruī, appāritus" "to appear";; no past perfect participle?
   "appāruērunt" "they appeared"
   "appāruit" "he appeared"
   "appropinquō, appropinquāre, appropinquāvī, appropinquātus" "to approach"
   "appropinquāvisset" "he (might) have had approached"
   "appropinquāvissent" "they (might) have had approached"
   "aqua, aquae" "water"
   "aquae" "water"
   "aquam" "water"
   "aquās" "water"
   "arbor" "tree"
   "arbor, arboris" "tree"
   "arbōre" "tree"
   "arbōrēs" "trees"
   "ascendentibus" "ascending"
   "ascendō, ascendere, ascendī, ascēnsus" "to ascend"
   "aspicere" "to look at, to contemplate"
   "aspiciō, aspicere, aspēxī, aspectus" "to look at, to contemplate"
   "ablātīs" "things having been carried away"
   "auferō, auferre, abstulī, ablātus" "to carry away, to remove"
   "aurōra" "dawn, sunrise"
   "aurōra, aurōrae" "dawn, sunrise"
   "avem" "bird"
   "avis" "bird"
   "avis, avis" "bird"
   "avium" "of birds"
   "avibus" "birds"
   "benedictiō, benedictiōnis" "benediction, blessing"
   "benedictiōne" "benediction, blessing"
   "bibere" "to drink"
   "bibō, bibere, bibī, pōtus" "to drink"
   "bibendum" "drinking"
   "bibet" "he will drink"
   "bīduānum" "two days"
   "bīduānus, bīduāna, bīduānum" "two days"
   "bonum" "good"
   "bonum, boni" "good"
   "Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "caelum" "heaven, sky"
   "caelus" "heaven, sky"
   "caelus, caelī" "heaven, sky"
   "candidus, candida -um, candidior -or -us, candidissimus -a -um" "bright, white, clean"
   "candidissimīs" "most bright/white, very bright/white"
   "candidissimus" "most bright/white, very bright/white"
   "cantābant" "they were singing"
   "cantāre" "to sing"
   "cantāvērunt" "they sang"
   "cantāvisset" "he (might) have had sung"
   "cantō, cantāre, cantāvī, cantātus" "to sing"
   "cantus" "song"
   "cantus, cantūs" "song"
   "carmen" "song, poem, prayer"
   "carmen, carminis" "song, poem, prayer"
   "causa, causae" "cause, reason"
   "causa" "cause, reason"
   "celebrābis" "you will celebrate"
   "celebrāvistī" "you celebrated"
   "celebrābitis" "you will celebrate"
   "celebrāvistis" "you celebrated"
   "celebrō, celebrāre, celebrāvī, celebrātus" "to celebrate"
   "cēnā" "dinner"
   "cēna, cēnae" "dinner"
   "chrīstus" "annointed one, Christ"
   "Chrīstus, Chrīstī" "Christ"
   "circuitum" "circuit, outer shore"
   "circuitus, circuitūs" "circuit, outer shore"
   "clārus" "clear, bright, famous"
   "clārus, clāra -um, clārior -or -us, clārissimus -a -um" "clear, bright, famous"
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
   "complentur" "it is completed, it is filled up"
   "compleō, complēre, complēvī, complētus" "to complete, to fill up"
   "cōnsēnsū" "consensus"
   "cōnsēnsus, cōnsēnsūs" "consensus"
   "cōnsentiō, cōnsentīre, cōnsēnsī, cōnsēnsus" "to be in agreement"
   "cōnsortiō" "fellowship"
   "cōnsortiō, cōnsortiōnis" "fellowship"
   "cōnsummātīs" "being accomplished, being ended"
   "cōnsummō, cōnsummāre, cōnsummāvī, cōnsummātus" "to accomplish, to end, to consume"
   "contigit" "to come to, to touch"
   "contingō, contingere, contigī, contāctus" "to come to, to touch"
   "cooperta" "covered"
   "cooperiō, cooperīre, cooperuī, coopertus" "to cover"
   "cooperuērunt" "they covered"
   "cor, cordis" "heart"
   "corde" "heart"
   "cordis" "heart"
   "corporibus" "bodies"
   "corpus" "body, flesh"
   "corpum" "body, flesh"
   "corpora" "bodies, flesh"
   "corpus, corporis" "body, flesh"
   "creātor, creātōris" "creator"
   "creātōrem" "creator"
   "crēber, crēbra -um, crēbrior -or -us, crēberrimus -a -um" "frequent, repeated, thick"
   "crēbrīs" "frequent, repeated, thick"
   "creō, creāre, creāvī, creātum" "to create"
   "creātī" "of the thing created"
   "crēdō" "I believe"
   "crēdō, crēdere, crēdidī, crēditum" "to believe"
   "dēbēs" "you should"
   "dēbeō, dēbēre, dēbuī, dēbitus" "to owe, to ought"
   "decet" "it is fitting"
   "decet, decēre, decuit, -" "it is fitting"
   "dedērunt" "they gave"
   "dēficiō, dēficere, dēfēcī, dēfectus" "to run short, to lack"
   "dēliciōsa" "delicious"
   "dēliciōsam" "delicious"
   "dēliciōsus, dēliciōsa, dēliciōsum" "delicious"
   "deī" "god, diety"
   "dēpreco, dēprecāre, dēprecāvī, dēprecātus" "to pray"
   "dēprecor" "I prayed"
   "dēprecātiō, dēprecātiōnis" "deprecation; averting by prayer"
   "dēprecātiōnum" "of deprecations"
   "dēprecāvisset" "they (might) have had prayed"
   "deō" "god"
   "deum" "god"
   "deus" "god"
   "deus, deī" "god, diety"
   "dīcam" "I will say"
   "dīcēns" "saying"
   "dīcentēs" "saying"
   "dictīs" "things having been said"
   "dīcō, dīcere, dīxī, dictus" "to say"
   "diēs" "day"
   "diē" "day"
   "diēī" "day"
   "diēbus" "days"
   "diem" "day"
   "diēs, diēī" "day"
   "dīgnēris" "you (might) be deemed worthy"
   "dignitās, dignitātis" "worth, honor, esteem, rank"
   "dignitātis" "worth, honor, esteem, rank"
   "dīgnō, dīgnāre, dīgnavī, dīgnatus" "to deem worthy, to deign"
   "discubuissent" "he (might) have had reclined at table/laid down"
   "discumbō, discumbere, discubuī, discubitus" "to recline at table, to lie down"
   "dīversās" "diverse"
   "dīversus" "diverse"
   "dīversus, dīversa, dīversum" "diverse"
   "dīvīna" "divine"
   "dīvīnus, dīvīna -um, dīvīnior -or -us, dīvīnissimus -a -um" "divine"
   "dīxērunt" "they said"
   "dīxisset" "he (might) have had said"
   "dīxit" "he said"
   "dedit" "he gave"
   "dispendia" "pay, nourishment"
   "dispendium, dispendiī" "pay, nourishment, expense, cost"
   "distribuit" "he distributed"
   "distribuō, distribuere, distribuī, distribūtus" "to distribute"
   "dō, dare, dedī, datum" "to give (irregular)"
   "domine" "lord, master"
   "dominī" "of the lord"
   "dominō" "lord"
   "dominum" "lord"
   "dominicīs" "Sundays"
   "Dominica, Dominicae" "Sunday"
   "dominicam" "Sunday"
   "dominicum" "Sunday"
   "dominus" "lord, master"
   "dominus, dominī" "lord, master"
   "dorsum" "back"
   "dorsum, dorsī" "back"
   "ductīs" "to have been lead"
   "dūcō, dūcere, dūxī, ductus" "to lead"
   "effundō, effundere, effūdī, effūsus" "to pour out"
   "effūdisset" "he (might) have had poured out"
   "ego" "I"
   "eius" "his, hers, its"
   "eō" "I go"
   "eōdem" "the same"
   "erant" "they were"
   "erat" "he was"
   "eritis" "you will be"
   "es" "you are"
   "esset" "he (might) have been"
   "est" "he is"
   "ēvigilāns" "awakening"
   "ēvigilat" "he wakes up, he rouses"
   "ēvigilō, ēvigilāre, ēvigilāvī, ēvigilātus" "to awaken"
   "exaudī" "hear!"
   "exaudiō, exaudīre, exaudīvī, exaudītus" "to hear clearly"
   "extendere" "to extend"
   "extendō, extendere, extendī, extentus" "to extend"
   "fābula" "story"
   "fābulam" "story"
   "fābula, fābulae" "story"
   "faciō, facere, fēcī, factus" "to do, to make"
   "familia" "family"
   "familia, familiās" "family"
   "familiae" "family"
   "famulīs" "servant, companions"
   "famulus, famulī" "servant, companions"
   "fēcērunt" "they did, they made"
   "fēcī" "I did, I made"
   "fēcit" "he did"
   "fēstī" "festive"
   "festīnābant" "they were hastening"
   "festīnāre" "to hasten, to hurry"
   "festīnō, festīnāre, festīnāvī, festīnātus" "to hasten, to hurry"
   "fēstīvitāte" "festivity"
   "fēstīvitās, fēstīvitātis" "festivity"
   "fēstīs" "festive"
   "fēstus, fēsta, fēstum" "festive"
   "fīliolī" "young sons"
   "fīliolus, fīliolī" "young son"
   "fīliī" "sons"
   "fīlium" "son"
   "fīlius, fīlī" "son"
   "fīniō, fīnīre, fīnīvī, fīnītus" "to limit, to finish"
   "fīnis, fīnis" "boundary, end, limit"
   "fīnium" "boundary, end, limit"
   ;;   "fīnītus, fīnīta, fīnītum"
   "firmāmentī" "strengthening, support"
   "firmāmentum, firmāmentī" "strengthening, support"
   "fleō, flēre, flēvī, flētus" "to cry"
   "flētū" "weeping"
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
   "fontēs" "fountains"
   "fortis" "strong"
   "fortis, forte, fortior -or -us, fortissimus -a -um" "strong"
   "frāter" "brother"
   "frāter, frātris" "brother"
   "frātrēs" "brothers"
   "frātribus" "brothers"
   "fretō" "strait, channel"
   "fretum, fretī" "strait, channel"
   "fuērunt" "they were"
   "fuimus" "we were"
   "fuisset" "he (might) have had been"
   "fuit" "he was"
   "fuistis" "you were"
   "fūnēs" "ropes"
   "fūnis, fūnis" "rope"
   "futūrō" "future"
   "futūrus, futūra, futūrum" "future"
   "genibus" "knee"
   "genu, genūs" "knee"
   "gȳrum" "circle, ring, circuit, course"
   "gȳrus, gȳrī" "circle, ring, circuit, course"
   "habēbat" "he had"
   "habeō, habēre, habuī, habitus" "to have"
   "habēs" "you have"
   "habet" "he has"
   "habētis" "you have"
   "habitāre" "to inhabit"
   "habitō, habitāre, habitāvī, habitātus" "to inhabit"
   "habuissēmus" "we (might) have had"
   "habuit" "he had"
   "hauriendam" "drawing, drinking, exhausting"
   "hauriō, haurīre, hausī, haustus" "to draw up, to drink, to exhaust"
   "herbōsam" "grassy, herbaceous"
   "herbōsus" "grassy, herbaceous"
   "hōram" "hour, time"
   "hōra" "hour, time"
   "hōrae" "hour, time"
   "hōra, hōrae" "hour, time"
   "hostis" "enemy"
   "hostis, hostis" "enemy"
   "hymnus" "hymn"
   "hymnus, hymnī" "hymn"
   "ībimus" "we will go"
   "illicitus, illicita, illicitum" "unallowed"
   "impleō, implēre, implēvī, implētus" "to fill up"
   "implēre" "to fill up"
   "incipere" "to start"
   "incipiēns" "starting"
   "incipiō, incipere, incēpī, inceptus" "to start"
   "incōgnitōrum" "unknown, untested"
   "incōgnitus, incōgnita, incōgnitum" "unknown, untested"
   "indicāre" "to indicate, to point out, to show"
   "indicō, indicāre, indicāvī, indicātus" "to indicate, to point out, to show"
   "inlūminā" "illuminate!"
   "inlūminō, inlūmināre, inlūmināvī, inlūminātus" "to illuminate"
   "īnsula" "island"
   "īnsula, īnsulae" "island"
   "īnsulae" "island"
   "īnsulam" "island"
   "interveniente" "come between, intervene"
   "invēnērunt" "they found"
   "invenietis" "finding"
   "invenientis" "finding"
   "inveniēs" "you will find"
   "invenīre" "to find"
   "inveniō, invenīre, invēnī, inventum" "to find"
   "iōcundum" "pleasant, jocund"
   "iōcundus" "pleasant, jocund"
   "iōcundus, jōcunda -um, jōcundior -or -us, jōcundissimus -a -um" "pleasant, jocund"
   "īre" "to go"
   "irruet" "it will rush in"
   "irruō, irruere, irruī, irrutus" "to rush into, to force way to"
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
   "labia" "lip"
   "labia, labiae" "lip"
   "lacrima, lacrimae" "tear"
   "lacrimās" "tears"
   "lāpsum" "fall, slipping"
   "lāpsus" "fall, slipping"
   "lāpsus, lāpsūs" "fall, slipping"
   "laetitia, laetitiae" "joy, gladness, fruitfulness"
   "laetitiae" "joy, gladness, fruitfulness"
   "lassitūdine" "faintness, weariness, exhaustion"
   "lassitūdō, lassitūdinis" "faintness, weariness, exhaustion"
   "lātitūdinis" "breadth, width, latitude"
   "lātitūdō" "breadth, width, latitude"
   "lātitūdō, lātitūdinis" "breadth, width, latitude"
   "lātum" "wide"
   "latera" "side"
   "latus, lateris" "side"
   "lātus, lāta, lātum" "wide"
   "laudāmus" "we praise"
   "laudāte" "praise!"
   "laudēs" "praises"
   "laudibus" "praises"
   "laudō, laudāre, laudāvī, laudātus" "to praise"
   "lavāre" "to wash"
   "lavō, lavāre, lāvī, lautus" "to wash"
   "levāvit" "he raised up"
   "licentia" "license, liberty"
   "licentia, licentiae" "license, liberty"
   "lītus" "beach, shore"
   "lītus, lītoris" "beach, shore"
   "locō" "place"
   "locum" "place"
   "locus, locī" "place"
   "longē" "long"
   "longitūdine" "length, longitude"
   "longitūdō, longitūdinis" "length, longitude"
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
   "manet" "he remains"
   "mānsit" "he remained"
   "manūs" "hand"
   "manus, manūs" "hand"
   "mare" "sea"
   "mare, maris" "sea"
   "marī" "sea"
   "mātūtīnum, mātūtīnī" "morning"
   "mātūtīnīs" "mornings"
   "mea" "my"
   "meī" "my"
   "meīs" "my"
   "mēnsēs" "months"
   "mēnsis" "month"
   "mēnsis, mēnsis" "month"
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
   "miserēre" "to pity, to have compassion"
   "misereō, miserēre, miseruī, miseritus" "to pity, to have compassion"
   "misericordia, misericordiae" "pity, compassion, mercy"
   "misericordiam" "pity, compassion, mercy"
   "mīsērunt" "they sent"
   "mīsit" "he sent"
   "missa, missae" "Mass"
   "missam" "Mass"
   "mittō, mittere, mīsī, missus" "to send"
   "mittuntur" "they are being sent"
   "modō" "mode, manner, way, measure, size"
   "modulātiō, modulātiōnis" "melody, modulation"
   "modulātiō" "melody, modulation"
   "modulātiōne" "melody, modulation"
   "modus, modī" "mode, manner, way, measure, size"
   "monachus" "monk"
   "monachus, monachī" "monk"
   "multitūdō" "multitude, great number"
   "multitūdō, multitūdinis" "multitude, great number"
   "multus, multa -um, -, plūrimus -a -um" "many"
   "nārrā" "narrate!"
   "nārrō, nārrāre, nārrāvī, nārrātus" "to narrate, to tell about"
   "nātīvitās" "birth, nativity"
   "nātīvitās, nātīvitātis" "birth, nativity"
   "nātīvitātem" "birth, nativity"
   "nāvem" "boat"
   "nāvī" "boat"
   "nāvigā" "sail (imperative)"
   "nāvigābant" "they were sailing"
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
   "nocte" "night"
   "noctem" "night"
   "noctīs" "nights"
   "nox" "night"
   "nox, noctis" "night"
   "nūntius" "messenger"
   "nūntius, nūntiī" "messenger"
   "observāre" "to observe, to watch"
   "observō, observāre, observāvī, observātus" "to observe, to watch"
   "ōceanī" "ocean"
   "ōceanus, ōceanī" "ocean"
   "ōceanum" "ocean"
   "occīdī" "I killed"
   "occīdō" "I kill"
   "occīdō, occīdere, occīdī, occīsus" "to kill"
   "octō" "8"
   "oculīs" "eyes"
   "oculus, oculī" "eye"
   "omnēs" "all, every"
   "omnī" "all, every"
   "omnia" "all, every"
   "omnis, omnis, omne" "all, every"
   "omnium" "of all"
   "omnibus" "all"
   "onerāre" "to load, to burden"
   "onerō, onerāre, onerāvī, onerātus" "to load, to burden"
   "opus" "work, deed"
   "opus, operis" "work, deed"
   "ōrātiō, ōrātiōnis" "oration, speech, discourse"
   "ōrātiōnibus" "oration, speech, discourse"
   "ōrāvērunt" "they prayed"
   "ōre" "mouth"
   "ōrō, ōrāre, ōrāvī, ōrātus" "to pray"
   "ōs, ōris" "mouth"
   "pāne, pānis" "bread"
   "pānēs" "bread"
   "paradīsus, paradīsī" "paradise"
   "paradīsus" "paradise"
   "pars, partis" "part"
   "partem" "part"
   "partēs" "parts"
   "pascha" "Passover, Easter"
   "pascha, paschae" "Passover, Easter"
   "paschae" "Passover, Easter"
   "paschālī" "Paschal"
   "paschālia" "Paschal"
   "paschālis, paschālis, paschāle" "Paschal"
   "pater" "father"
   "pater, patris" "father"
   "patre" "father"
   "patrem" "father"
   "patris" "father"
   "peccātōrī" "sinner"
   "peccātor, peccātōris" "sinner"
   "peccandō" "sinning"
   "peccō, peccāre, peccāvī, peccātus" "to sin"
   "pedēs" "feet"
   "pentēcostē, pentēcostēs" "Pentecost"
   "pentēcostēn" "Pentecost"
   "peragere" "to carry through, to complete"
   "peragō, peragere, perēgī, perāctus" "to carry through, to complete"
   "percutiō, percutere, percussī, percussus" "to strike, to beat"
   "percutientēs" "striking, beating"
   "permaneō, permanēre, permansī, permansus" "to last, to remain"
   "permansissent" "having had remained"
   "pēs, pedis" "foot"
   "placidō" "placid, gentle, quiet"
   "placidus, placida, placidum" "placid, gentle, quiet"
   "plāgam" "coast"
   "plāga, plāgae" "coast"
   "plānctus" "beating, wailing, lamentation"
   "plānctūs" "beating, wailing, lamentation"
   "plānctus, plānctūs" "beating, wailing, lamentation"
   "plēnā" "full"
   "plēnam" "full"
   "plēnum" "full"
   "plēnus, plēna -um, plēnior -or -us, plēnissimus -a -um" "full"
   "poena, poenae" "penalty, punishment"
   "poenās" "penalty, punishment"
   "pōnō, pōnere, posuī, positus" "to put, to place"
   "posuistī" "you placed"
   "porta, portae" "door, entrance"
   "portans" "carrying"
   "portāre" "to carry"
   "portō, portāre, portāvī, portātum" "to carry, to bring"
   "portum" "harbor, port"
   "portus" "harbor, port"
   "portus, portūs" "harbor, port"
   "possum, posse, potuī, -" "to be able (irregular)"
   "possumus" "we are able to"
   "poterant" "they were able to"
   "potest" "he can"
   "potestis" "you can"
   "potuī" "I was able"
   "potuit" "he was able"
   "potuērunt" "they were able"
   "potuisset" "he (might) have had been able"
   "potuissent" "they (might) have had been able"
   "praecipiō, praecipere, praecēpī, praeceptus" "to order"
   "praecēpit" "he ordered"
   "praedicta" "the aforesaid"
   "praedictō" "the aforesaid"
   "praedictum" "the aforesaid"
   "praedictus" "the aforesaid"
   "praedīcō, praedīcere, praedīxī, praedictus" "to say before"
   "praesentia, praesentiae" "present time"
   "praesentiam" "present time"
   "praestō, praestāre, praestitī, praestātum" "to excel, to surpass"
   "praesūmō" "to presume, to anticipate"
   "praesūmō, praesūmere, praesūmpsī, praesūmptus" "to presume, to anticipate"
   "prandium" "breakfast, meal"
   "prandium, prandiī" "breakfast, meal"
   "prōcūrātor" "procurator"
   "prōcūrātor, prōcūrātōris" "procurator"
   "prōra" "prow"
   "prōra, prōrae" "prow"
   "prōrae" "prow"
   "prōram" "prow"
   "prōvolō, prōvolāre, prōvolāvī, prōvolātus" "to fly forward"
   "prōvolūtīs" "fallen, rolled"
   "prōvolvō, prōvolvere, prōvolvī, prōvolūtus" "to roll forward, to bowl over"
   "psallēbant" "they were singing a Psalm"
   "psallendī" "singing a Psalm"
   "psallite" "singing a Psalm"
   "psallō, psallere, psallī, -" "to sing a Psalm"
   "quiēs, quiētis" "rest, respose, quiet"
   "quiētem" "rest, respose, quiet"
   "rāmī" "branches"
   "rāmus, rāmī" "branch"
   "receptiō" "reception"
   "receptiō, receptiōnis" "reception"
   "reciprocābant" "they were going back and forth"
   "reciprocō, reciprocāre, reciprocāvī, reciprocātus" "to go back and forth"
   "reddēbant" "they were rending, they were returning"
   "reddō, reddere, reddidī, redditus" "to return, to render"
   "reddētur" "to be returned"
   "refectiō, refectiōnis" "refreshing, restoring, repairing"
   "refectiōne" "refreshing, restoring, repairing"
   "reficiō, reficere, refēcī, refectus" "to rebuild, to repair, to restore"
   "reficiēbant" "they were rebuilding/repairing/restoring"
   "reficiēbat" "he was rebuilding/repairing/restoring"
   "reficite" "restore!"
   "refocilātiō" "refreshment"
   "refocillātiō, refocillātiōnis" "refreshment"
   "refulsit" "it shone"
   "refulgeō, refulgēre, refulsī, -" "to shine"
   "reprōmissiō, reprōmissiōnis" "promise"
   "reprōmissiōnis" "promise"
   "rē" "thing"
   "rem" "thing"
   "rēs, reī" "thing"
   "resēdit" "he sat, he settled"
   "resideō, residēre, resēdī, resessus" "to sit down, to settle"
   "resēdisset" "he (might) have had sat down"
   "resonābant" "they were resounding"
   "resonō, resonāre, resonāvī, resonātus" "to resound"
   "restant" "they stay behind, they remain"
   "restat" "it remains"
   "restō, restāre, restitī, -" "to stay behind, to remain"
   "revēlō, revēlāre, revēlāvī, revēlātus" "to show, to reveal"
   "revēlāre" "to reveal"
   "revēlātor" "revealer"
   "revertērunt" "they returned"
   "revertō, revertere, revertī, reversum" "to return"
   "rēgī" "king"
   "rēx, rēgis" "king"
   "ruīna" "collapse, ruin, destruction"
   "ruīna, ruīnae" "collapse, ruin, destruction"
   "salūtāris" "salutary, redeeming"
   "salūtāris, 	salūtāre" "salutary, redeeming"
   "sapor" "taste"
   "sapor, sapōris" "taste"
   "sapōrem" "taste"
   "satelles, satellitis" "attendant, guard, assistant"
   "satellitibus" "attendants, guards, assistants"
   "satiō, satiāre, satiāvī, satiātus" "to satisfy"
   "satiatae" "those that have been satisfied"
   "sēcrētum, sēcrētī" "secret"
   "sedēbat" "he was sitting"
   "sedēbant" "they were sitting"
   "sedeō, sedēre, sēdī, sessus" "to sit"
   "sēdit" "he sat"
   "sententia" "opinion, judgement, thought"
   "sententia, sententiae" "opinion, judgement, thought"
   "siccōs" "dry, thirsty"
   "siccus, sicca, siccum" "dry, thirsty"
   "signō" "sign"
   "signum, signī" "sign"
   "sit" "he (might) be"
   "sonābant" "they were making sounds"
   "sono, sonare, sonavi, sonatus" "to make a sound"
   "sonus" "sound"
   "sonus, sonī" "sound"
   "sopor" "deep sleep, lethargy"
   "sopor, sopōris" "deep sleep, lethargy"
   "spatium" "space"
   "spatium, spatiī" "space"
   "spēs" "hope"
   "spēs, speī" "hope"
   "spīritus" "spirit, breath"
   "spīritus, spīritūs" "spirit, breath"
   "splendor" "splendor, brightness"
   "splendor, splendōris" "splendor, brightness"
   "spontāneus, spontānea, spontāneum" "spontaneous"
   "stetērunt" "they stood"
   "stīpendia" "stipend, supplies"
   "stīpendium, stīpendiī" "stipend, supplies"
   "stō, stāre, stetī, status" "to stand, to remain"
   "suāvitās, suāvitātis" "sweetness, pleasantness"
   "suāvitāte" "sweetness, pleasantness"
   "sum, esse, fuī, futūrus" "to be (irregular)"
   "summitās, summitātis" "summit, top"
   "summitāte" "summit, top"
   "sumus" "we are"
   "sunt" "they are"
   "suscitāre" "to encourage, to awaken, to stir up"
   "suscitō, suscitāre, suscitāvī, suscitātus" "to encourage, to awaken, to stir up"
   "sustinēmus" "we sustain"
   "sustineō, sustinēre, sustinuī, sustentus" "to sustain"
   "suum" "his"
   "taedium" "weariness, tedium"
   "taedium, taediī" "weariness, tedium"
   "tālia" "such"
   "tālis, tālis, tāle" "such"
   "tanta" "so much, so great, this many"
   "tantum" "so much, so great, this many"
   "tantus, tanta, tantum" "so much, so great, this many"
   "tempus" "time, period"
   "tempus, temporis" "time, period"
   "terra" "land"
   "terrae" "land"
   "terra, terrae" "land"
   "terrārum" "of lands"
   "tintinnābulum" "bell"
   "tintinnābulum, tintinnābulī" "bell"
   "tractāre" "to haul, to drag, to handle, to discuss"
   "tractō, tractāre, tractāvī, tractātum" "to haul, to drag, to handle, to discuss"
   "trāxit" "he hauled, he discussed"
   "trāns" "across, beyond"
   "tertiam" "third"
   "trēs" "three"
   "trēs -es -ia, tertius -a -um, terni -ae -a, ter" "third"
   "tribuam" "I will assign"
   "tribuent" "they will assign"
   "tribuō, tribuere, tribuī, tribūtus" "to divide, to assign, to attribute"
   "triduānum" "three days"
   "triduāna, triduānae" "three days"
   "tu" "you"
   "tuae" "your"
   "tuam" "your"
   "tuīs" "yours"
   "tuō" "your"
   "turbidus" "turbid, troubled, muddy"
   "turbidus, turbida, turbidum" "turbid, troubled, muddy"
   "tuum" "your"
   "ūna" "one"
   "ūnum" "one"
   "ūnus -a -um, prīmus -a -um, singulī -ae -a, semel" "one"
   "vagor, vagārā, vagātus sum" "to wander, to roam"
   "vagāmur" "we wander"
   "vāscula" "small vessel"
   "vāsculīs" "small vessels"
   "vāsculum, vāsculī" "small vessel"
   "vēla" "sail, cloth"
   "vēlum, vēlī" "sail, cloth"
   "vēnērunt" "they came"
   "veniō, venīre, vēnī, ventus" "to come"
   "vēnit" "he came"
   "vērāx" "true"
   "vērāx, vērācis (gen.), vērācior -or -us, vērācissimus -a -um" "true"
   "versiculum" "verse, poetic line"
   "versiculus, versiculī" "verse, poetic line"
   "vesperā" "evening"
   "vesperās" "evening"
   "vespera, vesperae" "evening"
   "vespertīnum" "evening"
   "vespertīna" "evening"
   "vespertīnus, vespertīna, vespertīnum" "evening"
   "vestīmenta" "clothes"
   "vestīmentum, vestīmentī" "clothing, clothes"
   "vidēbātur" "he were appearing"
   "vidēbantur" "they were appearing"
   "videō" "I see"
   "videō, vidēre, vīdī, vīsus" "to see"
   "vidēs" "you see"
   "vidēre" "to see"
   "vīdit" "he saw"
   "vīdērunt" "they saw"
   "vidērentur" "he (may) have appeared"
   "vīdisset" "he (might) have had seen"
   "vīdissent" "they (might) have had seen"
   "vigiliam" "vigil, watch"
   "vigiliās" "vigil, watch"
   "vigilia, vigiliae" "vigil, watch"
   "vir" "man"
   "virī" "man"
   "vir, virī" "man"
   "virō" "man"
   "virtūs" "virtue, manliness"
   "virtūtēs" "virtue, manliness"
   "virtūs, virtūtis" "virtue, manliness"
   "vīrēs" "strength"
   "vīs, vīs" "strength, power"
   "vīvēbat" "he was living"
   "vīvō, vīvere, vīxī, vīctus" "to live"
   "vocātur" "to be called"
   "vocō, vocāre, vocāvī, vocātus" "to call, to summon"
   "volātū" "flying, flight"
   "volātus" "flying, flight"
   "volātus, volātūs" "flying, flight"
   "volēbant" "they were wanting"
   "volō" "I want"
   "volō, velle, voluī, -" "to want"
   "volābat" "he was flying"
   "volō, volāre, volāvī, volātus" "to fly"
   "voluit" "he wanted"
   "vōx, vōcis" "voice"
   "vōce" "voice"
   "volāre" "to fly"
   "vōtum, vōtī" "vow"
   "vōtum" "vow"
   "vultū" "face, expression, appearance"
   "vultum" "face, expression, appearance"
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
