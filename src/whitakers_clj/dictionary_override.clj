(ns whitakers-clj.dictionary-override
  "Contains macronized versions of words since Whitaker's Words doesn't support that yet."
  (:require [whitakers-clj.dict-a :refer [dict-a]]
            [whitakers-clj.dict-b :refer [dict-b]]
            [whitakers-clj.dict-c :refer [dict-c]]
            [whitakers-clj.dict-d :refer [dict-d]]
            [whitakers-clj.dict-e :refer [dict-e]]
            [whitakers-clj.dict-f :refer [dict-f]]
            [whitakers-clj.dict-g :refer [dict-g]]
            [whitakers-clj.dict-h :refer [dict-h]]
            [whitakers-clj.dict-i :refer [dict-i]]
            [whitakers-clj.dict-l :refer [dict-l]]
            [whitakers-clj.dict-m :refer [dict-m]]
            [whitakers-clj.dict-n :refer [dict-n]]
            [whitakers-clj.dict-o :refer [dict-o]]
            [whitakers-clj.dict-p :refer [dict-p]]
            [whitakers-clj.dict-q :refer [dict-q]]
            [whitakers-clj.dict-r :refer [dict-r]]
            [whitakers-clj.dict-s :refer [dict-s]]
            [whitakers-clj.dict-t :refer [dict-t]]
            [whitakers-clj.dict-v :refer [dict-v]]
            ))

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
   "ab" "from, out of, by, since"
   "abs" "from, out of, by, since"
   "Abbā" "father, abbot"
   "abbā" "father, abbot"
   "abinde" "from that place, thence, since"
   "Abraham" "Abraham, the Old Testament patriarch"
   "absit" "forbid it! May it be absent!"
   "Achardus" "Achard, Castellan of Montmerie"
   "adūnātim" "together; adverb from adūnāre, which means to unite or join"
   "aemilia" "Aemilia"
   "aemiliae" "of Aemilia (genitive case)"
   "aemiliam" "Aemilia (accusative case)"
   "albānōrum" "of the people of Alba Longa"
   "ac" "and"
   "ācriter" "sharply"
   "āctīs" "acts, ablative from ācta, a plural-only second declension noun"
   "ad" "to, towards, at, according to"
   "adam" "Adam, the first man"
   "adeō" "that far"
   "adfore" "to be present (in the future); future infinitive from adsum"
   "adhūc" "until now"
   "adinvicem" "mutually, each other, reciprocally (Medieval Latin adverb from ad invicem)"
   "aditum" "approach, access; singular masculine accusative from aditus, aditūs"
   "admīrātī" "admīrātī + sunt = were admired"
   "admīrātus" "admīrātus + est = was admired"
   "adiūtōrium" "adiūtōrium: help, support; plural neuter nominative or accusative from adiūtōrium, adiūtōriī"
   "admodum" "very"
   "Aduatucī" "The Aduatucī, a Germanic tribe (nominative case)"
   "Aduatucīs" "The Aduatucī, a Germanic tribe (dative or ablative case)"
   "aegrē" "scarcely"
   "aegypto" "Egypt, dative or ablative case"
   "aegyptiōs" "Egyptians, plural accusative case"
   "aeneae" "Aeneas, Trojan prince and legendary founder of Alba Longa, birthplace of Romulus and Remus (genitive case)"
   "aeneas" "Aeneas, Trojan prince and legendary founder of Alba Longa, birthplace of Romulus and Remus"
   "aequāliter" "equally"
   "aethiopum" "Ethiopian, black"
   "Ailbēī" "The name of a group of monks living on an island."
   "Airde" "An Irish man"
   "Alamannī" "the Alamanni, a confederation of Germanic tribes"
   "Alamannōrum" "of the Alamanni, a confederation of Germanic tribes"
   "albīnī" "Albinus, the name of a certain shopkeeper (accusative case)"
   "Albīnī" "Albinus, the name of a certain shopkeeper (accusative case)"
   "albīnum" "Albinus, the name of a certain shopkeeper (accusative case)"
   "Albīnum" "Albinus, the name of a certain shopkeeper (accusative case)"
   "albīnus" "Albinus, the name of a certain shopkeeper (nominative case)"
   "Albīnus" "Albinus, the name of a certain shopkeeper (nominative case)"
   "aleph" "Aleppo"
   "Alexandrēta" "Alexandriola a.k.a. Alexandretta a.k.a. İskenderun, a city about 10 miles north of Antioch, near the Gulf of Alexandretta"
   "aliam" "other, another; singular feminine accusative from alius, alia, aliud"
   "alibī" "elsewhere"
   "alicui" "to anyone; singular dative from aliqui"
   "aliōquī" "also"
   "aliōquīn" "also"
   "aliquā" "anyone"
   "aliquam" "anyone"
   "aliquandō" "some day"
   "aliquanta" "some"
   "aliquem" "anyone; singular masculine accusative from aliquī"
   "aliqui" "anyone"
   "aliquī" "someone; plural masculine nominative from aliquis"
   "aliquid" "someone"
   "aliquis" "someone"
   "aliquod" "anyone; neuter singular nominative or accusative from aliqui"
   "aliquōs" "someone"
   "aliquot" "quite a lot"
   "aliter" "otherwise"
   "alleluia" "hallelujah"
   "allobrogēs" "Allobrogi, A Gaulish tribe (nom. or acc. case)"
   "allobrogibus" "Allobrogi, A Gaulish tribe (dative or ablative case)"
   "allobrogum" "Of the Allobrogi, A Gaulish tribe (plural genitive case)"
   "alterīus" "of the other; singular genitive from alius, alia, aliud"
   "alternātim" "alternately (adverb)"
   "Ambiorīx" "Ambiorīx, king of the Eburones with Catuvolcus"
   "ambiorīx" "Ambiorīx, king of the Eburones with Catuvolcus"
   "Ambiorīgis" "Ambiorīx, king of the Eburones with Catuvolcus (genitive case)"
   "ambiorīgis" "Ambiorīx, king of the Eburones with Catuvolcus (genitive case)"
   "ambiorige" "Ambiorix, king of the Eburones with Catuvolcus (ablative case)"
   "ambiorigem" "Ambiorix, king of the Eburones with Catuvolcus (accusative case)"
   "ambō" "both"
   "ambrōnum" "of the Ambrones, a tribe of Denmark"
   "amen" "amen, truly, verily"
   "amīcissimē" "friendly"
   "admiraliī" "of the emir, leader, admiral; loanword from Arabic"
   "Ammiraliī" "of the emir, leader, admiral; loanword from Arabic"
   "ammiraliī" "of the emir, leader, admiral; loanword from Arabic"
   "ammiralīō" "emir, leader, admiral; loanword from Arabic (dative case)"
   "ammiraliōs" "emirs, leaders, admirals; loanword from Arabic (accusative case)"
   "ammiralium" "emir, leader, admiral; loanword from Arabic (accusative case)"
   "Ammirālius" "emir, leader, admiral; loanword from Arabic"
   "ammiralius" "emir, leader, admiral; loanword from Arabic"
   "ammirātī" "emirs, leaders, admirals; loanword from Arabic"
   "ammirātus" "emir, leader, admiral; loanword from Arabic"
   "āmodo" "from now on"
   "an" "or? rather?"
   "andreās" "Andrew"
   "Andreās" "Andrew"
   "angariī" "The Angarians, a Saxon tribe"
   "Angulānī" "Aghlabids (North African muslims)"
   "Angulānōrum" "of Aghlabids (North African muslims)"
   "angulānōrum" "of Aghlabids (North African muslims)"
   "Agulānī" "Aghlabids (North African muslims)"
   "Agulānōs" "Aghlabids (North African muslims)"
   "Annā" "Ablative of Annas, a high priest involved with the crucifixion of Christ."
   "annōn" "Was it not? Can it be that? Expects positive answer."
   "ante" "before, in front, forwards"
   "anteā" "before"
   "antequam" "before"
   "Antōnius" "Anthony"
   "anxiebantur" "they were anxious"
   "April" "The month of April"
   "aptota" "indeclinable, from άπτωτος"
   "aptoton" "indeclinable, from άπτωτος"
   "apud" "at, by, near"
   "Āpūliam" "Apulia, a region in eastern Italy; singular feminine accusative from Āpulia, Āpuliae"
   "arbalistae" "crossbowmen; plural feminine nominative from arbalista, arbalistae"
   "Ariovistus" "A German king"
   "Ariovistī" "Ariovistus, a German King (genitive case)"
   "ariovistī" "Ariovistus, a German King (genitive case)"
   "Armoriācās" "The Amoriacas, a region of northern Gaul that includes the Brittany Peninsula"
   "Arpinēius" "Arpinēius, a Roman family name"
   "Ascaniō" "Ascanius, legendary king of Alba Longa, son of Aeneas (ablative or dative case)"
   "Ascanius" "Ascanius, legendary king of Alba Longa, son of Aeneas (ablative or dative case)"
   "asportāte" "take away! Plural imperative from asportō, asportāre, asportāvī, asportātus"
   "assāte" "Roast! Bake! Broil! Plural imperative from assō, assāre, assāvī, assātus"
   "assiduē" "permanently" 
   "at" "and"
   "atque" "and"
   "Atrebās" "An Atrebatian. The Atrebates were a tribe in Gallia Belgica."
   "attamen" "nevertheless"
   "audācter" "audaciously"
   "Aurunculēius" "Aurunculēius, a Roman family name"
   "Ausoniae" "of Ausonia, a poetic name for Italy"
   "aut" "or"
   "autem" "but, however, moreover"
   "avēs" "birds; plural feminine nominative or accusative from avis, avis"
   "avium" "of birds; plural feminine genitive from avis, avis"
   "Azimītārum" "of the Armenians (according to Hagenmeyer (p. 297, note 19)). The name stems from the Greek άζυμος, which means unleavened, and refers to the Armenian's practice of using unleavened bread in the Eucharist."
   "Azimītās" "Armenians (according to Hagenmeyer (p. 297, note 19)). The name stems from the Greek άζυμος, which means unleavened, and refers to the Armenian's practice of using unleavened bread in the Eucharist."
   "balbum" "Part of Julius's name, Lūcius Iūlius Balbus (accusative case"
   "Balduīnō" "Baldwin"
   "Balduīnus" "Baldwin"
   "bari" "Bari, a large city on the eastern coast of Italy"
   "Barim" "Bari, a large city on the eastern coast of Italy (accusative case)"
   "Basipila" "baseball; singular feminine nominative from basipila, basipilae"
   "basipila" "baseball; singular feminine nominative from basipila, basipilae"
   "baubaū" "woof, bark"
   "Baubaū" "woof, bark"
   "beccus" "An Irish prophet who died around AD 553 or 557."
   "Beccus" "An Irish prophet who died around AD 553 or 557."
   "Beccī" "of Beccus, an Irish prophet who died around AD 553 or 557. (genitive case)"
   "beccī" "of Beccus, an Irish prophet who died around AD 553 or 557. (genitive case)"
   "bene" "good; adverb of bonus -a -um"
   "bifāriē" "in two ways, variant spelling of bifāriam"
   "bifāriam" "in two ways"
   "bis" "twice"
   "bisantēōs" "Coins of a type common in the Byzantine Empire called bisanteus."
   "bizantēīs" "Coins of a type common in the Byzantine Empire called bisanteus."
   "bisantīō" "Coins of a type common in the Byzantine Empire called bisanteus."
   "boiōs" "the Boii, who live across the Rhine from the Helvetii"
   "Bonifacius" "Saint Boniface, AD 675-754"
   "Boamundō" "Bohemond"
   "Boamundum" "Bohemond"
   "Boamundus" "Bohemond"
   "Boamunde" "Bohemond (vocative case)"
   "Boamundī" "of Bohemond"
   "Botrenthrot" "The Valley of Gülek Boğaz a.k.a. Cilician Gates, about 40 miles north of Tarsus"
   "bovēs" "cows; plural masc. or fem. nom. or acc. from bōs, bovis"
   "Brāchium" "the Bosporus; from Brāchium Sānctī Georgīī"
   "brāchium" "the Bosporus; from Brāchium Sānctī Georgīī"
   "Brandosim" "Brindisi, a city on the eastern coast of Italy"
   "Brendānī" "(genitive case) Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "Brendānō" "(ablative or dative case) Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "Brendānum" "(accusative case) Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "Brendānus" "Brendan of Clonfert (c. AD 484 – c. 577), an Irish abbot who sailed the Atlantic"
   "Brittannī" "Britons"
   "Brittannīs" "Britons (dative or ablative case)"
   "Brittannōs" "Britons (accusative case)"
   "Brittannia" "Britain"
   "Brittanniae" "Britain (nominative plural or genitive singular case)"
   "Brittanniam" "Britain (accusative case)"
   "Brittannicae" "of the Brittannic (genitive case)"
   "Brittannīcō" "Britannic (dative case)"
   "brittannīcō" "Britannic (dative case)"
   "Brittannicīs" "Britannic (ablative case)"
   "būfalōrum" "of buffaloes"
   "bulgariam" "Bulgaria (accusative case)"
   "Caiphā" "Ablative of Caiphas, a high priest involved with the crucifixion of Christ."
   "candida" "bright, white, clean; singular feminine nominative from candidus, candida, candidum"
   "cantāte" "Sing! Plural imperative from cantāre"
   "Cappadocia" "Cappadocia, a region in modern-day eastern Turkey"
   "Cappadociae" "of Cappadocia, a region in modern-day eastern Turkey"
   "Carnotensis" "of Chartres"
   "carnūtēs" "A Celtic tribe of Gallia Lugdunensis (nominative or accusative)"
   "carnūtibus" "A Celtic tribe of Gallia Lugdunensis (dative or ablative)"
   "Carolomannus" "Carloman, son of Pepin the Short and co-ruler of the Frankish kingdom with Charlemagne"
   "carolī" "Charlemagne, AD 748-814, King of the Franks and Emperor of the Western Roman Empire, member of the Carolingian Dynasty"
   "carolō" "Charlemagne, AD 748-814, King of the Franks and Emperor of the Western Roman Empire, member of the Carolingian Dynasty"
   "carolum" "Charlemagne, AD 748-814, King of the Franks and Emperor of the Western Roman Empire, member of the Carolingian Dynasty"
   "carolus" "Charlemagne, AD 748-814, King of the Franks and Emperor of the Western Roman Empire, member of the Carolingian Dynasty"
   "cassiānī" "of Yağısıyan, the Turkish governor of Antioch (genitive case)"
   "Cassiānus" "Yağısıyan, the Turkish governor of Antioch"
   "cassium" "Lucius Cassius Longinus (c. 151 - 107 BC), a consul who was killed at the Battle of Burdigala"
   "cāsū" "accidentally, by chance (adverb)"
   "Catamantaloedis" "Catamantaledes (one of the Sequani)"
   "Catuvolcō" "Catuvolcus, king of the Eburones with Ambiorix (ablative or dative case)"
   "Catuvolcus" "Catuvolcus, king of the Eburones with Ambiorix (nominative case)"
   "cāusāliter" "causally"
   "cautē" "cautiously"
   "celebrāte" "Celebrate!"
   "celeriter" "quickly"
   "cepsitāvit" "he stumbled; singular perfect from cespitō, cespitāre, cespitāvi, cespitas"
   "Cesaream" "Caesarea (accusative case)"
   "ceu" "as, like, in the same way"
   "Chrīstō" "Christ"
   "cibō" "food; singular masculine ablative from cibum cibum, cibī"
   "cicerōnem" "Cicerō (accusative case)"
   "cicerōnī" "Cicerō (dative case)"
   "citrā" "on this side"
   "ciula" "longship; singular feminine nominative variant spelling from ceola, ceolae"
   "ciulās" "longships; plural feminine accusative variant spelling from ceola, ceolae"
   "ciulae" "longship; singular feminine genitive or plural nominative variant spelling from ceola, ceolae"
   "ciulīs" "longship; plural feminine dative or ablative variant spelling from ceola, ceolae"
   "circā" "around, about, concerning"
   "circiter" "near, close, about"
   "circum" "about, around, near"
   "circumquaque" "on every side; all around"
   "citissimē" "very swiftly"
   "citō" "quickly"
   "Civītōt" "Civetot, modern-day Altinova, Turkey"
   "clam" "secretly, stealthily, without the knowledge of"
   "clāmāte" "shout: plural imperative from clāmāre"
   "clementer" "gently, leniently; adverb from clēmēns"
   "Cleopolimus" "A mis-heard version of Tlepolemus, the name of the messenger"
   "Commius" "Commius, a Roman ambassador"
   "Cosdras" "Codrus, the last King of Athens (r. ca 1089-1068 BC)"
   "Cosdrī" "of Codrus, the last King of Athens (r. ca 1089-1068 BC)"
   "coepērunt" "they started; from coepī, coepisse, coepī, coeptum"
   "cōminus" "in close-quarters combat, hand-to-hand (alternative form of comminus)"
   "commendātīs" "you commend; 2nd person plural present from commendāre"
   "commodē" "suitably"
   "commorantur" "they dwell, 3rd person present of commoror, commorārī, commorātum (dep.)"
   "complicātum" "folded up, rolled up; singular neuter accusative past passive participle from complicāre"
   "concordābilī" "unified, agreeably; singular ablative from concordābilis, concordābilis, concordābile"
   "cōnfestim" "immediately"
   "cōnsīderāte" "consider! plural imperative from cōnsīderō, cōnsīderāre, cōnsīderāvī, cōnsīderātus"
   "cōnstanter" "constantly"
   "cōnstitūtī" "cōnstitūtī + sunt = are arranged"
   "cōnsummāta" "finished, consummated; singular feminine nom. or abl. or plural neuter nom. or acc. from cōnsummātus, cōnsummāta, cōnsummātum"
   "cōnsummātō" "finished, consummated; singular masculine or neuter dative or ablative from cōnsummātus, cōnsummāta, cōnsummātum"
   "contentus" "content, satisfied, eager, from contentus, contenta, contentum"
   "contere" "grind! exhaust!; singular imperative from conterō, conterere, contrīvī, contrītus"
   "continenter" "continually"
   "contrā" "against, away from, facing"
   "convocātis" "you call together; 2nd person plural present from convocō, convocāre, convocāvī, convocātus"
   "cōram" "in the presence of"
   "Corrozānae" "of Khorasan, a region in modern-day Iran"
   "Corrozānam" "Khorasan, a region in modern-day Iran"
   "Corrozānum" "Khorasan, a region in modern-day Iran"
   "Corrozānī" "of Khorasan, a region in modern-day Iran"
   "Corrozāniā" "Khorasan, a region in modern-day Iran (ablative case)"
   "cucurrū" "cock-a-doodle-doo (the sound a rooster makes) (not a real Latin word)"
   "cūrpalātium" "palace minister (cūrpalātius, accusative case)"
   "cūrpalātius" "palace minister (cūrpalātius, nominative case)"
   "Cōrpalātius" "palace minister (cūrpalātius, nominative case)"
   "corporāliter" "bodily, physically, corporeally"
   "cotīdiē" "daily"
   "cottīdiē" "daily"
   "cottae" "Cotta, a Roman cognomen (genitive or dative case)"
   "crās" "tomorrow"
   "crūdēliter" "crudely"
   "cui" "to whom; singular dative from quī"
   "cuius" "whose; singular genitive from quī"
   "cultum" "cult, civilization; singular masculine accusative from cultus, cultūs"
   "cum" "with"
   "cumque" "and with"
   "cūr" "why"
   "Curbaram" "Qiwam al-Dawla Kerbogha, Turkish leader of Mosul"
   "Curtōs" "Kurds"
   "damascī" "of Damascus (genitive case)"
   "damascō" "Damascus (ablative case)"
   "Danihelem" "Daniel, the Old Testament prophet"
   "David" "David, the king of Israel that slew Goliath."
   "dāve" "Davus (vocative case)"
   "Dāve" "Davus (vocative case)"
   "Dāvum" "Davus (accusative case)"
   "Dāvus" "Davus"
   "dē" "of, from, away from, down from"
   "decem" "ten"
   "deciēs" "ten"
   "decimō" "tenth"
   "decimum" "tenth"
   "dehinc" "from now on, from this place"
   "deinceps" "successively, thereafter"
   "dein" "after; alterative spelling from deinde"
   "deinde" "after"
   "dēlia" "Dēlia"
   "dēlicātīs" "delicate, plural dative or ablative dēlicātus, -a, -um"
   "dēliciārum" "of delights, from dēliciae"
   "Dēmētrius" "Demetrius"
   "dēmorātī" "dēmorātī + sunt = they were detained"
   "dēnāriōrum" "of denarii"
   "dēnique" "finally"
   "deorsum" "downwards, below"
   "Dēsīderius" "King Desiderius, final King of the Lombards (720-786)"
   "dēsuper" "above"
   "dēterius" "worse, unfavorably"
   "dēvōtissimē" "very faithfully, devoutedly"
   "dīligenter" "diligently"
   "diū" "for a long time"
   "diūtius" "for a longer time"
   "dīvīnitus" "divinely, of heaven (adverb)"
   "dōnec" "while, as long as, until"
   "Dorensēs" "The Dorians, a Greek ethnic group invading Athens"
   "dūdum" "since some time"
   "dum" "while, as long as, until"
   "dumnorix" "Dumnorix, an Aeduan, the brother of Divitiacus"
   "dumtaxat" "only"
   "duo" "two"
   "duodecim" "twelve"
   "duodecimō" "twelfth (ablative of duodecim)"
   "duodecimum" "twelve"
   "duōs" "two"
   "Durachium" "Durrës, a large city on the western coast of Albania"
   "dūrēscere" "to become hard"
   "ē" "out of, from"
   "ea" "it; singular feminine nominative or plural neuter nom. or acc. from is, ea, id"
   "eā" "there, that way"
   "eadem" "the same, singular feminine nominative or plural neuter nominative or ablative"
   "eae" "they; plural feminine nominative from is, ea, id"
   "eam" "her; singular feminine accusative from is, ea, id"
   "eārum" "their; plural feminine genitive from is, ea, id"
   "eās" "their; plural feminine accusative from is, ea, id"
   "ebdomadās" "weeks"
   "eīs" "them; plural dative or ablative from is, ea, id"
   "Euboniā" "The Isle of Man, an island between Great Britain and Ireland."
   "euboniā" "The Isle of Man, an island between Great Britain and Ireland."
   "euboniam" "The Isle of Man, an island between Great Britain and Ireland (accusative case)."
   "eburōnēs" "A Gallic-Germanic tribe of Gallia Belgica (nominative or accusative)"
   "eburōnum" "A Gallic-Germanic tribe of Gallia Belgica (genitive)"
   "ex" "out of, from"
   "ecce" "Look! Behold!"
   "edī" "to be eaten; passive present infinitive from edō, edere, ēdī, ēsus"
   "Egidīō" "Raimundus comes dē Sānctō Egidīō = Raymond of Saint-Gilles"
   "Egidīī" "Egidīī: comes dē Sānctō Egidīō = Raymond of Saint-Gilles"
   "eī" "to him, her, or it; singular dative from is, ea, id"
   "eōs" "them; plural masculine accusative from is, ea, id"
   "eius" "his/her/its"
   "ēiusmodī" "of this sort"
   "ēgressa" "having gone out; singular nominative perfect passive participle from ēgredior, ēgredī, ēgressum (deponent)"
   "ēgressī" "going out; genitive singular perfect passive participle from ēgredior, ēgredī, ēgressum (deponent)"
   "ēgressus" "ēgressus + est = he went out"
   "ēn" "behold!"
   "enim" "for, truly, really, indeed"
   "enimvērō" "the fact is"
   "eōrum" "their; plural masculine or neuter genitive"
   "Ercī" "Erc, Bishop of Slane (-513 A.D.)"
   "Ercō" "Erc, Bishop of Slane (-513 A.D.)"
   "Ērēsburg" "a Saxon refuge castle near modern-day Obermarsberg"
   "ergā" "towards, opposite"
   "ergō" "therefore"
   "esse" "to be"
   "et" "and"
   "etiam" "still"
   "etenim" "as a matter of fact"
   "etsī" "even so"
   "eugē" "Hey-o! (An untranslatable interjection)"
   "eum" "him; singular masculine accusative from is, ea, id"
   "Eurardus" "Everard III of Le Puiset"
   "exceptā" "except"
   "exceptō" "except"
   "exercitū" "army; singular masculine ablative from exercitus, exercitūs"
   "exercitum" "army; singular masculine accusative from exercitus, exercitūs"
   "exercitus" "army; singular masculine nominative from exercitus, exercitūs"
   "exerta" "having been stretched out, brought forth; singular feminine nominative past passive participle from exere, a variant spelling of exserō"
   "expectāte" "Await! plural imperative from expectō, expectāre, expectāvī, expectātus"
   "expedītīs" "lightly-armed soldiers; dative or ablative case"
   "expedītior" "freer, more unburdened"
   "expedītius" "freer, more unburdened"
   "expergīsciminī" "you awaken; 2nd person plural present active from expergīscor, expergīscī, experrectus"
   "explētis" "You fill; 2nd person plural present from expleō, explēre, explēvī, explētus"
   "extemplō" "immediately"
   "extrā" "outside of, beyond"
   "fabricātus" "having been made; masuline nominative past passive participle from fabricō, fabricāre, fabricāvī, fabricātus"
   "facillimē" "very easily"
   "factū" "to be done, supine of facere"
   "farreum" "The Pōns Farreus extended over the Orontes River, colloquially called the Far. The name is not related to ferreum (iron), although several manuscripts spell it that way."
   "fēlīciter" "happily"
   "ferē" "nearly, almost, about"
   "festīnanter" "hastily, quickly"
   "festīne" "swiftly"
   "fīant" "they might do; 3rd person plural subjunctive present from faciō, facere, fēcī, factus"
   "fidēliter" "faithfully"
   "fīdūciāliter" "confidently"
   "Findluag" "Father of St. Brendan"
   "fīnītā" "end; singular feminine ablative of fīnītus, fīnīta, fīnītum"
   "fīnītīs" "end; plural dative or ablative of fīnītus, fīnīta, fīnītum"
   "fīnītō" "end; singular dative or ablative of fīnītus, fīnīta, fīnītum"
   "firmiter" "strongly"
   "forās" "outside (adverb)"
   "foret" "he (might) have been; subjunctive imperfect from esse"
   "forīs" "outside (adverb)"
   "forsitan" "maybe"
   "fortasse" "maybe, perhaps"
   "forte" "by chance"
   "fortiter" "strongly (adverb from fortis, forte)"
   "francī" "the Franks"
   "franciae" "of the Franks"
   "Francigena" "those born of the Franks, Frankish-born"
   "Francigenae" "those born of the Franks, Frankish-born"
   "Francigenīs" "those born of the Franks, Frankish-born"
   "francīs" "the Franks"
   "francōrum" "of the Franks"
   "francōs" "the Franks"
   "fraudulenter" "fraudulently, deceitfully; dishonestly; falsely;"
   "frēnum" "bridle; ornamental necklace"
   "Frīdēshlar" "Fritzlar, Germany"
   "frīget" "he is cold, freezes; 3rd person singular present from frīgeō, frīgēre, frīxī, -"
   "frīgent" "they are cold, freeze; 3rd person plural present from frīgeō, frīgēre, frīxī, -"
   "frīgentī" "freezing; singular dative or ablative present participle from frīgeō, frīgēre, frīxī, -"
   "frūstrā" "futile"
   "fuerint" "they will have been; 3rd person plural future perfect from esse"
   "fūrtim" "secret, stealthily"
   "gabīniō" "Aulus Gabinius, consul in 58 BC"
   "Garumna"  "The Garonne, a river running in modern-day France and Spain"
   "Garumnam" "The Garonne, a river running in modern-day France and Spain"
   "gāius" "Gāius, a Roman name"
   "gemmātum" "bejeweled; singular masculine accusative from gemmātus -a -um"
   "Geōrgiī" "of George, singular masculine genitive from Geōrgius, Geōrgiī"
   "Georgius" "George, singular masculine nominative from Geōrgius, Geōrgiī"
   "germānī" "Germans"
   "germānīs" "Germans"
   "Germānīs" "Germans"
   "germānōrum" "of Germans"
   "germānōs" "Germans"
   "Germānōs" "Germans"
   "gesta" "deeds, acts"
   "glōriantur" "they glory; 3rd person plural present active from glōrior, glōriārī, glōriātus"
   "Godefridī" "of Godfrey of Bouillon (~1060-1100 AD), first ruler of the Kingdom of Jerusalem (genitive case)"
   "Godefridō" "Godfrey of Bouillon (~1060-1100 AD), first ruler of the Kingdom of Jerusalem (dative or ablative case)"
   "Godefridus" "Godfrey of Bouillon (~1060-1100 AD), first ruler of the Kingdom of Jerusalem"
   "Goliae" "of Goliath, the Philistine giant that David slew; from Golias, Goliae."
   "gosfridī" "of Godfrey"
   "Gosfridī" "of Godfrey"
   "gravissimē" "very gravely"
   "Grifa" "griffin, a lion-eagle hybrid; from grifa, grifae"
   "grifa" "griffin, a lion-eagle hybrid; from grifa, grifae"
   "grifae" "griffin, a lion-eagle hybrid; from grifa, grifae"
   "grifa, grifae" "griffin, a lion-eagle hybrid"
   "grȳphī" "griffin (genitive case), a lion-eagle hybrid; from grȳphus, grȳphī"
   "grȳphum" "griffin (accusative case), a lion-eagle hybrid; from grȳphus, grȳphī"
   "grȳphus" "griffin, a lion-eagle hybrid; from grȳphus, grȳphī"
   "Grȳphus" "griffin, a lion-eagle hybrid; from grȳphus, grȳphī"
   "Gueith" "The Isle of Wight, an island just off the southern coast of Great Britain in the English channel. The name Gueith is from Old Welsh."
   "hae" "these; plural feminine nominative from hic, haec, hoc"
   "Haeduō" "a region in Gallia"
   "haeduō" "a region in Gallia"
   "Harolde" "Harold (vocative case)"
   "Haroldī" "of Harold (genitive case)"
   "Haroldō" "Harold (ablative case)"
   "Haroldum" "Harold (accusative case)"
   "Haroldus" "Harold (nominative case)"
   "haud" "not, not at all"
   "helī" "Eli, Old Testament high priest."
   "Helī" "Eli, Old Testament high priest."
   "herī" "yesterday"
   "Hermeniī" "Armenians"
   "Hermeniōrum" "Of Armenia"
   "Hērōde" "Ablative of Herod, the Roman-installed king of Israel involved with the crucifixion of Christ."
   "hērōde" "Ablative of Herod, the Roman-installed king of Israel involved with the crucifixion of Christ."
   "Hassī" "Hesse, a region in Germany"
   "heu" "Hey! oh! (interjection)"
   "hiberniae" "of Ireland (genitive case)"
   "hibernensium" "of the Irish (plural genitive)"
   "Hierosolymītānō" "Jerusalemite"
   "Hierosolimītānō" "Jerusalemite"
   "Hierosolymītānus" "Jerusalemite"
   "honorabiliter" "honorably"
   "hōs" "these; plural masculine accusative from hic, haec, hoc"
   "Hugō" "Hugh"
   "Hugōnem" "Hugh (accusative case)"
   "Hungāriae" "Hungary"
   "Hybernia" "Ireland (nominative case)"
   "Hyberniae" "of Ireland (genitive case)"
   "ī" "go!; singular imperative from eō, īre, iī, itus (irregular)"
   "Ī" "go!; singular imperative from eō, īre, iī, itus (irregular)"
   "iamdūdum" "long ago"
   "iamiam" "already, now"
   "iamiamque" "at this very moment"
   "iānuatōrem" "door-keeper; singular masculine accusative from iānuatōr, iānuatōris. This word was not in any dictionary I consulted; yet the meaning is clear from the root word iānua"
   "idcircō" "for that reason"
   "ideō" "for that reason"
   "iēiūnābant" "they were fasting"
   "iēiūnāre" "to fast"
   "iēiūnāvit" "he fasted"
   "iēiūnium" "fast, fasting"
   "iīs" "them; plural dative or ablative from is, ea, id"
   "illae" "those; plural feminine nominative from hic, haec, hoc"
   "interim" "during"
   "Iascōnium" "Jascōnius, a sea beast"
   "impedītīs" "impeded, plural masculine dative or ablative from impedītus -a -um"
   "incessanter" "incessantly"
   "īnsēparābiliter" "inseparably"
   "īnsuper" "besides, furthermore"
   "iocantem" "jesting, participle from iocor, iocārī, iocātus (dep.)"
   "Iohanne" "John the Baptist"
   "Iohannem" "John the Baptist (accusative)"
   "Ionam" "Jonah, the prophet to Nineveh who spent three days in the belly of a sea monster; from Ionas, Ionae."
   "Irminsul" "the name of an idol, or type of idol that the Saxons worshipped"
   "Isuardus" "Isoard"
   "Iūram" "Mount Jura"
   "gravitātis" "gravity, weight, importance; singular feminine genitive from gravitās, gravitātis"
   "gravitāte" "gravity, weight, importance; singular feminine ablative from gravitās, gravitātis"
   "gravitātem" "gravity, weight, importance; singular feminine accusative from gravitās, gravitātis"
   "hāc" "this; singular feminine ablative of hic, haec, hoc"
   "haec" "this, these; singular feminine nominative or plural neuter nom. or acc. of hic, haec, hoc"
   "hanc" "this; singular feminine accusative of hic, haec, hoc"
   "hārum" "of these; plural feminine genitive of hic, haec, hoc"
   "hās" "this; plural feminine accusative of hic, haec, hoc"
   "hic" "this; singular masculine nominative of hic, haec, hoc"
   "hinc" "from here"
   "hī" "these; plural masculine nominative of hic, haec, hoc"
   "hīs" "these; plural masculine dative or ablative of hic, haec, hoc"
   "huic" "this; singular dative of hic, haec, hoc"
   "huius" "of this; singular genitive of hic, haec, hoc"
   "hunc" "this; singular masculine accusative of hic, haec, hoc"
   "hierusalem" "Jerusalem"
   "hōc" "this; sing. masc. or neut. abl. of hic, haec, hoc"
   "hodiē" "today"
   "hōrum" "these; plural masc. or neut. gen. of hic, haec, hoc"
   "hūc" "toward here"
   "hūcusque" "up to this point"
   "iam" "already, now, soon"
   "Iascōniī" "of Jasconius (the sea creature); singular masculine genitive from Iascōnius"
   "Iascōnius" "Jasconius, a large sea creature"
   "Iascōniō" "dative or ablative of Jasconius, a large sea creature"
   "ibi" "there"
   "ibīdem" "in the same place"
   "id" "it"
   "Iēsū" "Jesus, ablative singular of Iēsūs"
   "iēsū" "Jesus, ablative singular of Iēsūs"
   "iēsūm" "Jesus, accusative singular of Iēsūs"
   "igitur" "therefore"
   "ignōtum" "unknown"
   "iī" "they, plural masculine nominative of is, ea, id"
   "illīc" "there"
   "īlicō" "in place"
   "illa" "that; singular feminine nominative from ille, illa, illud"
   "illam" "that; singular feminine accusative from ille, illa, illud"
   "illārum" "that; plural feminine genitive from ille, illa, illud"
   "illās" "that; plural feminine accusative from ille, illa, illud"
   "ille" "that; singular masculine nominative from ille, illa, illud"
   "illī" "that; singular dative or plural masculine nominative from ille, illa, illud"
   "illīs" "those; plural dative or ablative from ille, illa, illud"
   "illīus" "of that; singular genitive from ille, illa, illud"
   "illō" "these; singular masculine or neuter ablative from ille, illa, illud"
   "illōrum" "of those; plural masculine or neuter genitive from ille, illa, illud"
   "illōs" "that; plural masculine accusative from ille, illa, illud"
   "illud" "that; singular neuter nominative or accusative from ille, illa, illud"
   "illum" "that; singular feminine accusative from ille, illa, illud"
   "illūc" "over there"
   "immō" "of course, certainly, to the contrary"
   "immolātīs" "having been burned; ablative perfect passive participle from immolō, immolāre, immolāvī, immolātus"
   "imperātor" "emperor; singular masculine nominative from imperātor, imperātōris"
   "implēte" "fill! plural imperative from impleō, implēre, implēvī, implētus"
   "imprōvidē" "suddenly"
   "in" "into (with accusative), in (with ablative)"
   "inaequaliter" "unequally"
   "inde" "from there, since"
   "indēsinenter" "incessantly, ceaselessly"
   "indūtiomarī" "Indūtiomārus, one of the chiefs of the Treviri"
   "indūtiomārus" "Indūtiomārus, one of the chiefs of the Treviri"
   "inferōs" "Hades, plural masculine accusative from īnferus, īnfera, īnferum"
   "īnfrā" "below"
   "ingeniōsē" "cleverly, ingeniously"
   "inibī" "in that place"
   "iniussū" "without an order (ablative)"
   "inlūxit" "he began to shine; from inlūcēscō, inlūcēscere, inlūxī, -"
   "innocenter" "innocently"
   "inquantum" "insofar as"
   "īnsimul" "together, simultaneously"
   "īnstanter" "upcomingly, menacingly (adverb)"
   "īnstar" "as big as"
   "intentē" "intently, attentively"
   "inter" "between, among, during"
   "intereā" "during"
   "interfecta" "interfect est = was killed"
   "intrā" "within, between, during"
   "intus" "inside"
   "invicem" "alternately, mutually"
   "ipse" "itself; singular masculine nominative from ipse, ipsa, ipsum"
   "ipsa" "itself; singular feminine nominative from ipse, ipsa, ipsum"
   "ipsam" "itself; singular feminine accusative from ipse, ipsa, ipsum"
   "ipsum" "itself; singular masculine acc. or neuter nom. or acc. from ipse, ipsa, ipsum"
   "ipsī" "itself; sing. dative or plural masc. nom. from ipse, ipsa, ipsum"
   "ipsīs" "itself; plural dative or ablative from ipse, ipsa, ipsum"
   "ipsīus" "of itself; singular genitive from ipse, ipsa, ipsum"
   "ipsō" "itself; singular masculine or neuter ablative from ipse, ipsa, ipsum"
   "ipsōs" "themselves; plural masculine accusative from ipse, ipsa, ipsum"
   "ipsōrum" "thereselves; plural masc. or neut. genitive from ipse, ipsa, ipsum"
   "īre" "to go; present infinitive from eō, īre, iī, itus (irregular)"
   "irriguissimōs" "very well-watered; superlative from irriguus -a -um."
   "is" "he; singular masculine nominative from is, ea, id"
   "iste" "that; singular masculine nom. from iste, ista, istud"
   "ista" "that; singular feminine nom. or abl, or plural neuter nom. or acc. from iste, ista, istud"
   "istam" "that; singular feminine accusative from iste, ista, istud"
   "istae" "those; plural feminine nominative from iste, ista, istud"
   "istās" "those; plural feminine accusative from iste, ista, istud"
   "istī" "to this, those; singular dative or plural nominative masculine from iste"
   "istīus" "of this; singular genitive from iste, ista, istud"
   "istō" "that; singular masculine or neuter ablative from iste, ista, istud"
   "istud" "that; singuglar neuter nominative and accusative from iste, ista, istud"
   "istum" "that; singular masculine accusative from iste, ista, istud"
   "istīs" "those; plural dative or ablative from iste, ista, istud"
   "Israel" "Israel"
   "ita" "yes"
   "ītaliae" "Italy (genitive or locative case)"
   "ītaliam" "Italy (accusative case)"
   "itaque" "so then, therefore"
   "item" "just like"
   "iterum" "again"
   "itūrī" "to be gone to. future active participle from eō, īre, iī, itum"
   "iudam" "Judas Iscariot"
   "iudas" "Judas Iscariot"
   "Iūliō" "July"
   "iussit" "he commanded; 3rd person singular perfect from iubeō, iubēre, iussī, iussus"
   "iuxtā" "near, nearly"
   "judas" "Judas Iscariot"
   "kal" "Abbreviation for kalendae, the first day of the month"
   "Karolus" "Charlemagne"
   "Kyarragi" "A region in western Ireland"
   "lacrimābiliter" "woefully, with tears (adverb)"
   "lacum" "lake; singular masculine accusative from lacus, lacūs."
   "lātē" "widely; adverb from lātus, -a, -um"
   "latenter" "secretly, privately; in concealment, without being seen/perceived;"
   "Latobrigīs" "Latobrigi, neighbors to the Helvetii"
   "Lāvīniam" "Lavinia, the wife of Aeneas"
   "Lēander" "Lēander"
   "Lēandrum" "Lēander (accusative case)"
   "Lemanno" "Lake Geneva"
   "Lemannus" "Lake Geneva"
   "lemannus" "Lake Geneva"
   "Leviathan" "Leviathan, a sea monster mentioned in Job 40:25."
   "leviathan" "Leviathan, a sea monster mentioned in Job 40:25."
   "libenter" "willingly, gladly, freely"
   "licet" "allow"
   "licēbat" "it was allowed; 3rd person singular imperfect from licet, licēre, licuī"
   "licuit" "allowed"
   "locūtus" "locūtus est = he spoke"
   "Langōbardī" "the Lombards"
   "Langōbardīs" "the Lombards"
   "Langōbardōs" "the Lombards"
   "Longobardī" "the Lombards"
   "Longobardōs" "the Lombards"
   "Longobardus" "Lombard"
   "Lombardī" "the Lombards"
   "Lombardōs" "the Lombards"
   "Lȳdia" "Lydia (nominative case)"
   "Lȳdiā" "Lydia (ablative case)"
   "Lȳdiae" "Lydia's (genitive case)"
   "Lȳdiam" "Lydia (accusative case)"
   "Machomet" "Mohammed, founder of the religion of Islam"
   "Machomāriam" "a certain mosque, according to Hagenmeyer (p. 276, note 7)"
   "Machumāriam" "a certain mosque, according to Hagenmeyer (p. 276, note 7)"
   "magis" "rather, more"
   "magnopere" "much, very, urgently"
   "mala" "evil, bad"
   "malam" "evil, bad; singular feminine accusative from malus -a -um"
   "malī" "evil, bad"
   "malīs" "evil, bad"
   "malō" "evil, bad"
   "malum" "evil, bad"
   "Manau" "The Isle of Man, an island between Great Britain and Ireland."
   "mandātum" "mandate; singular masculine nominative or accusative from mandātum, mandātī"
   "manē" "morning"
   "mānsī" "I remained; singular 1st person perfect from maneō, manēre, mānsī, mānsus"
   "Marchīsī" "of the Marquis"
   "mārcī" "of Marcus (genitive case)"
   "mārcus" "Marcus"
   "mārcum" "Marcus (accusative case)"
   "mārcō" "Marcus (dative or ablative case)"
   "mārce" "O, Marcus (vocative case)"
   "Marra" "the name of a city"
   "martir" "martyr, one who dies for their faith"
   "martirizāvērunt" "they were marytred; 3rd person plural perfecte from martyrizō, martyrizāre"
   "Martis" "March"
   "Massiliam" "Marseille, a city in southern France"
   "maximē" "greatly"
   "Mēde" "Medus (vocative case)"
   "mēde" "Medus (vocative case)"
   "Mēdī" "of Medus (genitive case"
   "mēdī" "of Medus (genitive case"
   "Mēdō" "Medus (dative or ablative case)"
   "mēdō" "Medus (dative or ablative case)"
   "mēdum" "Medus (accusative case)"
   "Mēdus" "Medus (nominative case)"
   "mēdus" "Medus (nominative case)"
   "mē" "to me, accusative from ego"
   "mēcum" "with me (mē + cum)"
   "melius" "better, comparative adverb from bonus"
   "meō" "my; singular masculine or neuter dative or ablative from meus"
   "mercurius" "Mercury. Saint Mercury was a 3rd century warrior saint and martyr credited with killing Julian the Apostate."
   "Mercurius" "Mercury. Saint Mercury was a 3rd century warrior saint and martyr credited with killing Julian the Apostate."
   "Merloi" "Achardus dē Monte Merloi = Achard of Montmerle"
   "messala" "Marcus Messala, consul of Rome in 61 B.C."
   "mīlle" "one thousand"
   "mīlia" "one thousand"
   "minimē" "barely, no, not"
   "minus" "less"
   "mīrābiliter" "marvelously"
   "miserrimē" "miserably"
   "mixtim" "mixedly, in a mixed manner (adverb)"
   "modeste" "modestly, in a disciplined manner"
   "modicum" "a little; singular neuter nominative or accusative from modicum, modica"
   "montānea" "mountain; singular feminine nominative from montāneā, montāneae"
   "montāneae" "of the mountain; singular feminine genitive from montāneā, montāneae"
   "montāneam" "mountain; singular feminine accusative from montāneā, montāneae"
   "montāneās" "mountains; plural feminine accusative from montāneā, montāneae"
   "montaneīs" "mountains; plural feminine dative or ablative from montāneā, montāneae"
   "mox" "soon"
   "muliebriter" "womanly (adverb from muliebris, muliebre)"
   "multipliciter" "numerously"
   "Mumenensī" "of Munster, a south-western region in Ireland. Not to be confused with Münster, the German city."
   "Musōne" "Mousson"
   "Nabuchodonosor" "Nebuchadnezzar (reigned 605-562 BC), the Babylonian king mentioned in Daniel"
   "nam" "yes, truly"
   "Nammeius" "Numeius, a Helvetic legate"
   "namque" "for and in fact, on the other hand"
   "nātūrāliter" "naturally, normally, inherently, by nature"
   "nātūra, nātūrae" "nature, quality"
   "nātūram" "nature, quality"
   "nautor" "sailer; singular masculine nominative from nautor, nautōris. This is a medieval Latin term that is not found in many dictionaries."
   "nautoribus" "sailer; plural masculine ablative from nautor, nautōris. This is a medieval Latin term that is not found in many dictionaries."
   "nāvigātē" "sail! Plural imperative from nāvigō, nāvigāre, nāvigāvī, nāvigātus"
   "nē" "not"
   "nec" "nor, not either"
   "necnōn" "and not"
   "necessāria" "necessities of life"
   "necessāria, necessāriōrum" "necessities of life"
   "nēminem" "no one (accusative cas)"
   "neptūnus" "Neptune"
   "Neptūnus" "Neptune"
   "neque" "not, not either"
   "nēquiter" "wickedly"
   "Nīcēa" "Nicea"
   "Nīcēam" "Nicea"
   "Nicēnam" "Nicea"
   "nihil" "not at all"
   "nimia" "too much"
   "nimiae" "too much"
   "nimiō" "too much"
   "nīmīrum" "certainly"
   "nimis" "too much, extremely"
   "nisī" "if not, unless"
   "nōbīs" "us; singular dative or ablative from ego"
   "nocte" "night; singular feminine ablative from nox, noctis"
   "noctū" "at night"
   "Noe" "Noah, who repopulated the earth after the Flood"
   "nōlī" "be unwilling! imperative singular of nōlō, nōlle, nōluī (irr.)"
   "nōlīte" "be unwilling! imperative plural of nōlō, nōlle, nōluī (irr.)"
   "nōminātim" "by name"
   "nōn" "not"
   "nōna" "ninth"
   "nōnāgintā" "90"
   "nōnam" "the 9th"
   "nōnum" "ninth"
   "nōndum" "not yet"
   "nōngentī" "900"
   "nōnne" "not, expecting an affirmative answer"
   "nonnullī" "some; masculine plural nominative of nonnullus, -a, -um"
   "nōnus" "9th"
   "Noricum" "Noric; belonging to Noreia, a region in Gallia"
   "Nortmannīā" "Norman (ablative case)"
   "Nortmanniae" "Norman (genitive case)"
   "Nortmannus" "Norman"
   "nōs" "us; plural nominative or accusative of ego"
   "nostrae" "our; singular feminine genitive or dative of noster"
   "nostrī" "our; plural masculine nominative from noster"
   "nostrō" "our"
   "nostrōrum" "our"
   "nostrōs" "our"
   "nostrīs" "our"
   "nostram" "our; plural genitive of ego"
   "nostrum" "our; plural genitive of ego"
   "nōtum" "known; singular neuter nom. or acc. perfect passive participle of gnōscō, gnōscere, nōvī, nōtus"
   "Nōviomāgum" "Nijmegen, a city in the modern-day Netherlands (accusative case)"
   "noviter" "recently"
   "nūllātenus" "no way"
   "num" "a word that makes a sentence into a question"
   "Num" "a word that makes a sentence into a question"
   "numquam" "never"
   "nunquam" "never"
   "numquid" "is it possible?"
   "nunc" "now"
   "nūper" "recently"
   "nusquam" "nowhere"
   "nūtrītōrem" "nurse; singular masculine accusative from nūtrītor, nūtrītōrēs"
   "Ō" "O (interjection)"
   "ob" "for, because of, towards"
   "obitum" "death"
   "obvia" "in the path"
   "obviam" "in the path"
   "octāvīs" "octaves, 8th"
   "octāvās" "octaves, 8th"
   "octāvus, octāvī" "octave, 8th"
   "octāvum" "octave, 8th"
   "octāvus" "octave, 8th"
   "octōbrī" "October"
   "ōlim" "one day, once upon a time"
   "omnimodō" "by any means"
   "omnīnō" "entirely, altogether"
   "operātus" "operātus + est = was performed"
   "optime" "very, rightly, best"
   "ōrā" "pray! singular imperative from ōrō, ōrāre, ōrāvī, ōrātus"
   "ōrāte" "pray! plural imperative from ōrō, ōrāre, ōrāvī, ōrātus"
   "Orc" "The Orkney Isles, located off the northern coast of Scotland"
   "Orcades" "The Orkney Isles, located off the northern coast of Scotland"
   "ōrdinātim" "in order, succession"
   "Otrentum" "Otranto, a city on the eastern coast of Italy"
   "orgetorīgis" "Orgetorix, a Helvetic aristocrat (genitive case)."
   "Orgetorīgis" "Orgetorix, a Helvetic aristocrat (genitive case)."
   "orgetorīx" "Orgetorix, a Helvetic aristocrat."
   "Orgetoricem" "Orgetorix, a Helvetic aristocrat (accusative case)."
   "oriundus" "oriundus + est = was descended from"
   "Osterliudī" "Another name of the Eastphalians"
   "Ostvalōs" "Eastphalians, members of a Saxon tribe"
   "Padus" "the Po river, which is the longest river in Italy"
   "paene" "almost"
   "palam" "openly, publicly"
   "parce" "Pardon! Forgive! Singular imperative from parcō, parcere, pepercī, parsum"
   "parem" "equal, sing. masc. or fem. acc. from pār"
   "pārentēs" "parents; plural masculine nominative or accusative from pārentēs, pārentium (which only has plural forms)"
   "pārentibus" "parents (ablative or dative case)"
   "pariter" "equally, together"
   "parte" "part; singular feminine ablative from pars, partis"
   "parumper" "briefly"
   "passus" "passus + est = to have suffered"
   "passī" "passī + est = they suffered"
   "paterentur" "they (might) suffer them, allow them; subjunctive imperfect from patī"
   "patī" "to suffer; present active infinitive from patior, patī, passus"
   "Patriciī" "of Saint Patrick"
   "paulātim" "little by little"
   "pūblicānōrum" "of Paulicans, a Armenian sect considered heretical by the Catholic Church"
   "Pūblicānōrum" "of Paulicans, a Armenian sect considered heretical by the Catholic Church"
   "pūblicānōs" "Paulicans, a Armenian sect considered heretical by the Catholic Church"
   "Pūblicānōs" "Paulicans, a Armenian sect considered heretical by the Catholic Church"
   "paululum" "a little"
   "pēne" "almost; alternate spelling of paene"
   "per" "through"
   "perfectē" "perfectly"
   "perfīnītis" "You finished; 2nd person plural present from perfīnīre"
   "perfīnīta" "perfīnīta + est: it has been finished"
   "Persae" "Persians"
   "persae" "Persians"
   "persīdis" "Persian (genitive case)"
   "petulanter" "impudently, adverb from petulāns"
   "Philomenam" "Philomelium a.k.a. Akşehir, a district in modern-day Turkey"
   "pictōrum" "of the Picts"
   "pigritārētur" "he tarried, was slothful; 3rd person singular subjunctive imperfect from pigritor"
   "Pīlātō" "Ablative of Pontius Pilate, the Roman official involved with the crucifixion of Christ."
   "pīlātō" "Ablative of Pontius Pilate, the Roman official involved with the crucifixion of Christ."
   "pirus" "A soldier charged with keeping watch over three towers during the siege of Antioch."
   "Pirus" "A soldier charged with keeping watch over three towers during the siege of Antioch."
   "pīsōne" "Lucius Piso, consul in 58 BC"
   "plēbem" "common people; singular masculine accusative from plēbs, plēbis"
   "plēbī" "to the common people; singular masculine accusative from plēbs, plēbis"
   "plērum" "most of the time"
   "plūs" "more, from mūltus"
   "Podiēnsī" "of Le Puy Cathedral, in Auvergne, France (dative or ablative case)"
   "Podiēnsis" "of Le Puy Cathedral, in Auvergne, France"
   "porrō" "farther, further, also"
   "post" "behind, after, since"
   "posteā" "thereafter, later"
   "postmodum" "afterwards, presently, later"
   "postquam" "since, since then, after"
   "postrēmō" "finally"
   "pōtū" "drink; singular masculine ablative from pōtus, pōtūs"
   "pōtum" "drink; singular masculine accusative from pōtus, pōtūs"
   "prae" "before, in front, because of"
   "praesertim" "especially"
   "praestō" "present, available"
   "praeter" "more, beyond, besides, except"
   "praetereā" "and also"
   "praeteritō" "previous"
   "praeteritum" "previous"
   "prīdiē" "the day before"
   "prīmitus" "in the beginning, originally"
   "prius" "before"
   "priusquam" "before"
   "prō" "for, in favor of, before, in place of"
   "procul" "far"
   "prōfectī" "prōfectī est = had set out"
   "prope" "near, close"
   "propius" "almost, nearly"
   "proptereā" "because of, that's why"
   "prōtinus" "forward, onward"
   "proximē" "closest, very close, immediately after"
   "Puisātiō" "Eurardus dē Puisātiō = Everard III of Le Puiset"
   "pulsātō" "having been hit; perfect passive dative or ablative participle from pulsō, pulsāre, pulsāvī, pulsātus"
   "propter" "because of, near"
   "prout" "as, just as, exactly as"
   "prudenter" "prudently"
   "pulchrē" "beautifully"
   "quā" "what; singular feminine ablative of qui"
   "quae" "who; plural feminine nom. or neuter nom. or acc. from quī"
   "quam" "how? how much?"
   "quātinus" "how long, how far"
   "quemadmodum" "how"
   "quīdam" "a certain; singular masculine nominative from quīdam"
   "quamdam" "a certain; singular feminine accusative from quīdam"
   "quemdam" "a certain; singular masculine accusative from quīdam"
   "quamdiū" "as long as"
   "quamobrem" "why, for what reason? Derived from quam ob rem."
   "quamquam" "although"
   "quamvīs" "as much, as much as one wants, however"
   "quanta" "how much?"
   "quāpropter" "that's why"
   "quārē" "by what mean?"
   "quārtum" "for the fourth time"
   "quārtus" "fourth"
   "quārum" "what; plural feminine genitive from quī"
   "quās" "who; plural feminine accusative from quī"
   "quattuor" "4"
   "que" "and"
   "quem" "what, singular masculine accusative from quī"
   "quī" "who; singular or plural masculine nominative from quī"
   "quibus" "what; plural dative or ablative from quī"
   "quicquam" "anyone; singular neuter nominative or accusative from quisquam"
   "quid" "who; singular neuter nom. or acc. from quī"
   "quidem" "indeed, at last"
   "quīn" "even, in fact"
   "quīngentī" "500"
   "quīngēntīs" "500"
   "quintum" "fifth"
   "quīnquāgintā" "fifty"
   "quinque" "five"
   "quīntō" "for the fifth time"
   "quīnte" "O Quintus (vocative case)"
   "Quīnte" "O Quintus (vocative case)"
   "Quīntus" "Quintus, a Roman name"
   "quīntus" "Quintus, a Roman name"
   "Quīntī" "Quintus, a Roman name (genitive case)"
   "quīntī" "Quintus, a Roman name (genitive case)"
   "quis" "who"
   "quisquis" "whatever"
   "quod" "what; singular neuter nom. or acc. of qui"
   "quō" "what; singular ablative from quī"
   "quōmodo" "how, by which means"
   "quoniam" "since, after"
   "quōrum" "of whom; plural masc or neut. genitive from quī"
   "quōs" "whom; plural masculine accusative from quī"
   "quōsdam" "certain ones; plural masculine accusative from quīdam"
   "quoūsque" "how far? until when?"
   "quadrāgintā" "40"
   "quaerere" "to seek"
   "quaerō, quaerere, quaesīvī, quaesītus" "to seek"
   "quāliter" "what kind?"
   "quandō" "when, because"
   "quandōque" "whenever"
   "quantōcius" "the sooner the better (adverb)"
   "quantōs" "how much?"
   "quantum" "how much?"
   "quantus" "how much?"
   "quantus, quanta, quantum" "how much?"
   "quasi" "as if, like, as much as"
   "quattuordecim" "14"
   "quia" "because"
   "quicquid" "whatever"
   "quīnta" "fifth"
   "quippe" "surely, indeed, the thing is"
   "quōcumque" "no matter where"
   "quōdam" "a certain one; ablative from quīdam"
   "quondam" "sometimes"
   "quoque" "also"
   "quot" "how many?"
   "quotiēns" "how many times?"
   "quotquot" "however many"
   "Raimundī" "of Raymond"
   "Raimundus" "Raymond"
   "Rainoldus" "a leader of the crusaders chosen by the Lombards and Longobards"
   "raptim" "quickly, hastily"
   "Rauracīs" "Rauraci, neighbors to the Helvetii"
   "recordare" "remember! Singular imperative of recordārī"
   "recordātus" "rememberance, recollection"
   "recordātus, recordātūs" "rememberance, recollection"
   "reddite" "Return! Plural imperated from reddere."
   "Reinaldus" "Reynold"
   "rēmigēs" "oars, oarmen; plural masculine nominative or accusative from rēmex, rēmigēs"
   "repente" "suddenly, unexpectedly"
   "resurrēctiō, resurrēctiōnis" "resurrection"
   "resurrēctiōne" "resurrection"
   "retrō" "behind, backwards"
   "retrōgredientibus" "stepping backwards; plural ablative variant spelling from retrōgradientibus"
   "retrōrsum" "behind, backwards"
   "rēvērā" "actually, in fact"
   "reversa" "reversa + est = it returned"
   "reversus" "reversus + est = he returned"
   "Richardus" "Richardus dē Prīncipātū = Richard of the Principality a.k.a. Richard of Salerno"
   "rīvulum" "rivulet, small brook"
   "rīvulus, rīvulī" "rivulet, small brook"
   "rōmāna" "Roman"
   "rōmānī" "Romans"
   "Rotbertus" "Robert"
   "rubicunditātis" "redness. This word did not appear in any dictionaries I consulted, but the meaning is clear from the context. It appears to be a variant of rubicundus -a -um, meaning red, ruddy, or rubicund."
   "rūrsum" "backwards, on the flipside"
   "rūrsus" "backwards, on the flipside"
   "Rusam" "Ρούσιον, modern-day Keşan, Turkey, which lies about 140 miles from Constantinople"
   "Ryeuall" "Rievaulx, a village about 9 miles from Byland Abbey."
   "sabīnō" "Sabīnus, a Roman name"
   "saepe" "often"
   "saepius" "more often"
   "sagāciter" "cleverly"
   "Samarobrīva" "A town in Gallia (nominative)"
   "Samarobrīvā" "A town in Gallia (ablative)"
   "Samarobrīvae" "A town in Gallia (locative)"
   "sanctificāte" "Sanctify! Plural imperative of sanctificō, sanctificāre, sanctificāvī, sanctificātus"
   "sāncta" "holy, saint"
   "sānctās" "holy, saintly"
   "sānctē" "holy, saint"
   "sānctus" "holy, saint"
   "sānctae" "holy"
   "sānctam" "holy"
   "sānctī" "holy"
   "sānctīs" "holy"
   "sānctō" "holy"
   "sānctōrum" "of the saints; plural masculine gentive from sānctus, sānctī"
   "sānctōs" "holy"
   "sānctum" "holy, saint"
   "sānctissimam" "most holy"
   "sapienter" "wisely"
   "Saracēnās" "Saracenes, muslims"
   "Saracēnī" "Saracenes, muslims"
   "Saracēnōrum" "of Saracenes, muslims"
   "Saracēnōs" "Saracenes, muslims"
   "sat" "enough"
   "Sathānae" "Satan (genitive or dative case)"
   "satis" "enough"
   "Saxonēs" "The Saxons"
   "Saxōnia" "Saxony"
   "Saxōnibus" "The Saxons"
   "Saxōnicus" "Saxon"
   "Saxōnum" "of the Saxons"
   "scabiōsō" "Godefridus dē Monte Scabiōsō = Godfrey of Montescaglioso (a town in Italy)"
   "Scabiōsō" "Godefridus dē Monte Scabiōsō = Godfrey of Montescaglioso (a town in Italy)"
   "scalta" "an unknown type of plant. Ablative plural from scalta, scaltae."
   "scaltae" "an unknown type of plant. Ablative plural from scalta, scaltae."
   "scaltās" "an unknown type of plant. Accusative plural from scalta, scaltae."
   "scaltīs" "an unknown type of plant. Ablative plural from scalta, scaltae."
   "scīs" "you know; 2nd person singular present from sciō, scīre, scīvī, scītus"
   "scītis" "you know; 2nd person plural present from sciō, scīre, scīvī, scītus"
   "sciēbat" "he was knowing; 3rd person singular imperfect from sciō, scīre, scīvī, scītus"
   "scīlicet" "obviously"
   "Sclavī" "Slavs, plural masculine nominative from Sclavus, Sclavī"
   "Sclaviniae" "Slavinia"
   "scoriosam" "slaggy. This is an uncommon word related to scōria, scōriae (slag)."
   "scrībēbat" "he was writing"
   "scrīpsit" "he wrote"
   "scrībō, scrībere, scrīpsī, scrīptus" "to write"
   "sē" "himself or themselves"
   "sēcum" "with oneself"
   "sēcūrē" "safely, securly"
   "sēcrētum" "secret; singular neuter nominative or accusative from sēcrētum, sēcrētī"
   "sectātus" "sectātus + est = he ran after, he sought out"
   "secundō" "second"
   "secundum" "second, following, behind"
   "sēcūtī" "sēcūtī + sunt = they followed"
   "secūtus" "secūtus + est = he followed"
   "sed" "but"
   "sēdecim" "16"
   "semetipsum" "he himself"
   "semper" "always"
   "Sensadolus" "Shams al-Dawla, the son of Yağısıyan, governor of Antioch"
   "seorsum" "separately, apart"
   "sēparātim" "separately, apart"
   "sēpe" "often; variant spelling of saepe"
   "septem" "seven"
   "septēna" "seventh"
   "septimum" "seventh"
   "septimus" "seventh"
   "septimō" "seventh"
   "septingentōs" "700"
   "septuāgintā" "70"
   "sermōcinent" "they might converse, discuss; 3rd person plural subjunctive present variant spelling from sermōcinor, sermōcinārī, sermōcinātus"
   "sēsē" "himself"
   "seu" "or, what if"
   "sex" "six"
   "sexdecim" "sixteen"
   "sexta" "sixth"
   "sextam" "sixth"
   "sextō" "sixth"
   "sextum" "sixth"
   "sextus" "sixth"
   "sexāgintā" "sixty"
   "sī" "if"
   "sibi" "to himself; singular dative of se"
   "sīc" "thus"
   "sīcut" "as, same as, like"
   "sīcutī" "as, same as, like"
   "Sigiburg" "A Saxon hillfort in Western Germany"
   "Silvius" "Silvius, son of Aeneas (or Ascanius)"
   "Silviī" "Silvius, son of Aeneas (or Ascanius) (genitive case)"
   "Simeōnis" "Of Simeon"
   "similiter" "similarly"
   "simul" "at the same time as"
   "sīn" "but if, if on the contrary"
   "sine" "without"
   "singulāriter" "singularly, solitary, peerless; adverb from singulāris, singulāre"
   "sinistrali" "left, singular feminine ablative from sinistra, sinistrae"
   "sinistrē" "badly"
   "sinus" "pocket, fold; singular masculine nominative from sinus, sinūs"
   "sinū" "pocket, fold; singular masculine ablative from sinus, sinūs"
   "sinum" "pocket, fold; singular masculine accusative from sinus, sinūs"
   "siquidem" "however, accordingly, since, if only. In Medieval Latin, synonym of autem."
   "sita" "sita est = is located; idiomatic usage of past passive participle of sinō, sinere, sīvī, situs"
   "sīve" "or"
   "soldānī" "of the Sultan; singular masculine genitive variant spelling from soldanus, soldanī"
   "Soldānī" "of the Sultan; singular masculine genitive variant spelling from soldanus, soldanī"
   "soldānō" "to the Sultan; singular masculine dative variant spelling from soldanus, soldanī"
   "solempnitātibus" "solemnities, festivals; plural feminine dative or ablative from sollemnitās, sollemnitātis"
   "Solimānus" "Kilij Arslan a.k.a. Suleiman II, Seljuk sultan of Rûm and leader of the Turkish forces in Anatolia during the first crusade; son of Suleiman I"
   "Solimānī" "of Kilij Arslan a.k.a. Suleiman II, Seljuk sultan of Rûm and leader of the Turkish forces in Anatolia during the first crusade; son of Suleiman I"
   "sollemniter" "solemnly"
   "sōlum" "only, just, barely, merely"
   "sōlummodo" "only, just, merely, barely, alone"
   "sotiātur" "it is joined; 3rd person singular present passive from a variant spelling of sociāre"
   "speciāliter" "specifically, individually; adverb from speciālis, speciāle"
   "spontāneē" "spontaneously"
   "statim" "immediately"
   "Stephanus" "Stephan"
   "strictum" "narrow, strict, tight"
   "stultē" "stupidly, foolishly; adverb from stultus, stulta, stultum"
   "sua" "her/its; sing. fem. nom. or abl. or neuter nom. or acc. from suus"
   "suae" "her; singular feminine gen. or dat. or plural feminine nom. or voc. from suus"
   "suam" "her; singular feminine acc. from suus"
   "suārum" "of theirs; plural feminine genitive from suus"
   "sub" "below, under"
   "subitō" "suddenly"
   "subsecutī" "subsecutī + est = was following; from subsequor, subsequī, subsecūtum (dep.)"
   "subtus" "under, below"
   "subeunda" "undergoing; gerundive from subīre."
   "subeundā" "undergoing; gerundive from subīre."
   "subtīliter" "finely, precisely, subtly; adverb from subtīlis, subtīle"
   "sufficere" "to be sufficient"
   "sufficiō, sufficere, suffēcī, suffectum" "to be sufficient"
   "sufficienter" "sufficiently"
   "suās" "their; plural accusative feminine of suus"
   "suī" "of him; singular or plural genitive of se"
   "suō" "their; singular dative or ablative of suus"
   "suōrum" "their; plural genitive of suus"
   "suōs" "their; plural accusative of suus"
   "suīs" "their; plural dative or ablative of suus"
   "summitās, summitātis" "summit, top"
   "summitātem" "summit, top"
   "super" "above, on top of"
   "supellē̆ctilī" "furnishings"
   "suprā" "over, above, beyond, before"
   "surānī" "Syrians"
   "surānōrum" "of Syrians"
   "Surānōrum" "of Syrians"
   "Suriānī" "Syrians"
   "sūrsum" "on top, upward"
   "Syon" "Zion"
   "Synai" "Sinai"
   "syra" "Syra"
   "syrae" "of Syra"
   "Syra" "Syra"
   "syram" "Syra (accusative case)"
   "syre" "O, Syra (vocative case)"
   "syrī" "of Syrus (genitive case)"
   "syrō" "Syrus (dative or ablative case)"
   "syriae" "of Syria"
   "syrum" "Syrus (accusative case)"
   "syrus" "Syrus (nominative case)"
   "Talamaniā" "the name of a castle"
   "Tamesis" "Thames river"
   "Tancredī" "of Tancred, Prince of Galilee (1075–1112) (genitive case)"
   "Tancredō" "Tancred, Prince of Galilee (1075–1112) (dative or ablative case)"
   "Tancredus" "Tancred, Prince of Galilee (1075–1112) (nominative case)"
   "Tancredum" "Tancred, Prince of Galilee (1075–1112) (accusative case)"
   "Tasgetī" "Tasgetius, a chief of the Carnutes (genitive case)"
   "Tasgetiī" "Tasgetius, a chief of the Carnutes (genitive case)"
   "Tasgetius" "Tasgetius, a chief of the Carnutes"
   "Tasgetium" "Tasgetius, a chief of the Carnutes (accusative case)"
   "tālī" "such"
   "tam" "as much, as much as"
   "tamen" "however"
   "tandem" "finally"
   "Tarsum" "Tarsus, a city in modern-day Turkey. During the Roman Empire, Tarsus was the capital of Cilicia."
   "temere" "without design, thoughtlessly"
   "tantae" "of such"
   "tē" "you, accusative from tu"
   "tēcum" "with you (tē + cum)"
   "ter" "three times"
   "terra, terrae" "land"
   "terram" "land; singular feminine accusative from terra, terrae"
   "Theophaniam" "Theophany a.k.a. Epiphany, a feast celebrated soon after Christmas that commemorates the visit of the Magi, the baptism of Christ, and the wedding at Cana."
   "tibi" "to you, singular dative of tu"
   "Ticinēnsum" "residents of Pavia a.k.a. Ticinum, capital of the Kingdom of the Lombards from 572 to 774."
   "Ticinum" "Pavia a.k.a. Ticinum, capital of the Kingdom of the Lombards from 572 to 774."
   "Tīthim" "the sea; sea nymph"
   "Tīthis" "the sea; sea nymph"
   "Titūrī" "Titūrius, a Roman family name (genitive case)"
   "Titūrium" "Titūrius, a Roman family name (accusative case)"
   "Titūrius" "Titūrius, a Roman family name (nominative case)"
   "Tlēpolemus" "Tlēpolemus, the name of a messenger (nominative case)"
   "Tlēpolemum" "Tlēpolemus, the name of a messenger (accusative case)"
   "tot" "this many"
   "totidem" "as many, the same number of"
   "trecenta" "300"
   "trecentās" "300"
   "tredecim" "13"
   "trahō, trahere, trāxī, tractum" "to draw, to drag, to haul"
   "trāxissent" "they (might) have had drawn"
   "trēverī" "Treveri, a tribe of Gallia Belgica (plural nominative)"
   "trēverīs" "Treveris, members of a tribe of Gallia Belgica (plural accusative)"
   "tria" "three"
   "trīduum, trīduī" "three days"
   "trīduum" "three days"
   "trīgintā" "thirty"
   "tulingīs" "Tulingi, neighbors to the Helvetii"
   "tum" "then"
   "tunc" "then"
   "Turcā" "the Turk"
   "Turcam" "the Turk"
   "Turcās" "the Turks"
   "Turcīs" "the Turks"
   "Turcōrum" "of the Turks"
   "Turcōs" "the Turks"
   "Turcus" "the Turk"
   "Turcī" "the Turks"
   "Turcopōlīs" "Turcopoles (ablative case): a Turkic group allied with Byzantium. Turcopolis comes from the Greek 'Sons of Turks' τουρκόπουλοι = Τοῦρκος + πουλος"
   "Turcopūlōs" "Turcopoles (accusative case): a Turkic group allied with Byzantium. Turcopolis comes from the Greek 'Sons of Turks' τουρκόπουλοι = Τοῦρκος + πουλος"
   "Turnō" "Turnus, a king of the Rutuli killed by Aeneas (ablative or dative case)"
   "turpiter" "shamefully, disgracefully"
   "tusculī" "Tusculum, a city in ancient Italy. The city was destroyed in April 1191 AD. (locative or genitive case)"
   "tusculum" "Tusculum, a city in ancient Italy. The city was destroyed in April 1191 AD. (nominative or accusative case)"
   "Tusculum" "Tusculum, a city in ancient Italy. The city was destroyed in April 1191 AD. (nominative or accusative case)"
   "ubī" "where"
   "ubicumque" "everywhere"
   "ūllātenus" "up to this point"
   "ultrā" "beyond, further"
   "ultrō" "beyond, further"
   "umquam" "ever"
   "unquam" "ever"
   "ūnanimiter" "unanimously, harmoniously"
   "unde" "from where?"
   "ūndecim" "11"
   "ūndecimum" "eleventh"
   "undique" "from all sides"
   "ūnīcuique" "each one; ablative from ūnusquisque"
   "ūniūs" "of one (genitive of ūnus)"
   "ūnus" "one"
   "ūnusquisque" "each one"
   "ūnīuscuiusque" "of each one; genitive from ūnusquisque"
   "Ursus" "Ursus"
   "ursus" "Ursus"
   "ūsque" "until, all the way, up until"
   "usquequo" "until"
   "ūsum" "have been being used, singular neuter nominative perfect participle from ūtor, ūtī, ūsum (dep.)"
   "ut" "so that"
   "utcumque" "as soon as, by any means"
   "utcunque" "as soon as, by any means"
   "utinam" "if only"
   "utrimque" "both sides"
   "utrinque" "both sides"
   "utrum" "whether"
   "vae" "woe"
   "valdē" "very"
   "vehementer" "vehemently"
   "vel" "or"
   "vēlōciter" "quickly"
   "velut" "same as, for example"
   "veniō, venīre, vēnī, ventus" "to come"
   "vēnērant" "they had came"
   "vēnissent" "they (might) have had come"

   "vergit" "it lies"
   "vergentem" "laying"
   "vergēbat" "it was laying, inclining, sloping"
   "vergō, vergere, -, -" "to lay, to incline, to slope"
      
   "vērō" "and, truly, even so, still"
   "Verucloetius" "A Helvetic legate"
   "vērumtamen" "but certainly"
   "vespertīnāle" "Vespers. This word isn't in any of my dictionaries but the meaning is clear."
   "vestra" "your"
   "vestrae" "your"
   "vestram" "your; singular feminine accusative from vester"
   "vestrās" "your; plural feminine accusative from vester"
   "vestrō" "your; singular masc. or neuter dative or ablative from vester"
   "vestrī" "your; singular masc. or neut. gen. or plural masc. nom. from vester"
   "vestrīs" "your; plural dative or ablative from vester"
   "vestrōrum" "of yours; plural masculine or neuter genitive from vester"
   "vestrōs" "your; plural masculine accusative from vester"
   "vestrum" "your; singular masculine accusative or singular neuter nominative or accusative from vester"
   "vexātī" "vexātī + erant: they had been vexed"
   "vicissim" "in turn"
   "vīctū" "food; singular masculine ablative from victus, victūs"
   "vīctum" "food; singular masculine accussative from victus, victūs"
   "vidēlicet" "namely, that is to say"
   "videō, vidēre, vīdī, vīsus" "to see"
   "vīdērunt" "they saw"
   "vigilāte" "stay alert! plural imperative from vigilō, vigilāre, vigilāvī, vigilātus"
   "vīgintī" "20"
   "violenter" "violently"
   "Virgilius" "Vergil"
   "virīliter" "strongly"
   "vīsae" "vīsae + sunt = having been seen, having appeared"
   "vix" "barely"
   "vōbīs" "you; plural dative or ablative from tu"
   "volunt" "they want; singular 3rd person present from volō, velle, voluī (irr.)"
   "voluntāriē" "voluntarily"
   "vōtum" "vow"
   "vult" "he wants; singular 3rd person present from volō, velle, voluī (irr.)"
   "vultis" "you want; plural 2nd person present from volō, velle, voluī (irr.)"
   "Westfalhōs" "Westphalians, members of a Saxon tribe"
   "Westfalōs" "Westphalians, members of a Saxon tribe"
   "Wido" "Guy of Hauteville, brother of Bohemond, son of Robert Guiscard"
   "Widōnem" "Guy of Hauteville, brother of Bohemond, son of Robert Guiscard (accusative case)"
   "Willelmus" "Wilhelm or William"
   "Wisuram" "The River Weser, the second longest river in Germany"
   "X" "ten"
   "XVIII" "eighteen"
   "XXX" "thirty"
   "VII" "seven"
   "XII" "twelve"
   "XV" "fifteen"
   "zephāriā" "western (alternate spellling of zephyrius -a -um, meaning pertaining to a western breeze)"
   })

(def dictionary-map
  (merge
   dict-a
   dict-b
   dict-c
   dict-d
   dict-e
   dict-f
   dict-g
   dict-h
   dict-i
   dict-l
   dict-m
   dict-n
   dict-o
   dict-p
   dict-q
   dict-r
   dict-s
   dict-t
   dict-v
   {
    "kalendās" "calends, first day of the month"
    "kalendīs" "calends, first day of the month"
    "Kalenda, Kalendae" "calends, first day of the month"

    "zōna" "belt"
    "zōnās" "belts"
    "zōna, zōnae" "belt"
    }))

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

(def full-override
  {"leōnēs" '({:options
               [{:sectioned-word "leōnēs",
                :stem "leōnēs",
                :ending nil,
                :part-of-speech :noun,
                :declension 3,
                :case :nominative,
                :number :plural,
                :gender :masculine}
                {:sectioned-word "leōnēs",
                :stem "leōnēs",
                :ending nil,
                :part-of-speech :noun,
                :declension 3,
                :case :accusative,
                :number :plural,
                :gender :masculine}
               ],
              :part-of-speech :noun,
              :dictionary-entry "leō, leōnis",
              :definition
              "lion",
              :dictionary-code
               {:age nil,
               :area nil
               :geo nil,
               :freq-code "A"
               :freq-text "Very frequent, in all Elementry Latin books",
               :source nil},
              :original-word "leōnēs",
              :parsed-word "leōnēs"})
   "leō" '({:options
               [{:sectioned-word "leō",
                :stem "leō",
                :ending nil,
                :part-of-speech :noun,
                :declension 3,
                :case :nominative,
                :number :singular,
                :gender :masculine}
               ],
              :part-of-speech :noun,
              :dictionary-entry "leō, leōnis",
              :definition
              "lion",
              :dictionary-code
               {:age nil,
               :area nil
               :geo nil,
               :freq-code "A"
               :freq-text "Very frequent, in all Elementry Latin books",
               :source nil},
              :original-word "leō",
              :parsed-word "leō"})
   "quoque" '({:word "quoque",
               :part-of-speech :conjunction,
               :dictionary-entry "quoque",
               :definition "also",
               :dictionary-code
               {:age nil,
                :area nil,
                :geo nil,
                :freq-code :A,
                :freq-text "Very frequent, in all Elementry Latin books",
                :source "Oxford Latin Dictionary, 1982 (OLD)"},
               :original-word "quoque",
               :parsed-word "quoque"})
   "pōnitur" '({:definition "it is placed",
                :part-of-speech :verb,
                :sectioned-word "pōn.itur",
                :dictionary-code
                {:age nil,
                 :area nil,
                 :geo nil,
                 :freq-code nil,
                 :freq-text nil,
                 :source nil},
                :dictionary-entry "pōnō, pōnere, posuī, positus",
                :original-word "pōnitur",
                :conjugation 3,
                :options
                [{:tense :present,
                  :person 3,
                  :number :singular,
                  :part-of-speech :verb,
                  :sectioned-word "pōn.itur",
                  :voice :passive,
                  :mood :indicative,
                  :conjugation 3,
                  :stem "pōn",
                  :ending "itur"}],
                :parsed-word "pōnitur"})
   "pōnī" '({:definition "to be placed",
             :part-of-speech :verb,
             :sectioned-word "pōnī",
             :dictionary-code
             {:age nil,
              :area nil,
              :geo nil,
              :freq-code nil,
              :freq-text nil,
              :source nil},
             :dictionary-entry "pōnō, pōnere, posuī, positus",
             :original-word "pōnī",
             :conjugation 3,
             :options
             [{:tense :present,
               :person nil,
               :number nil,
               :part-of-speech :verb,
               :sectioned-word "pōn.ī",
               :voice :passive,
               :mood :infinitive,
               :conjugation 3,
               :stem "pōn",
               :ending "ī"}
              ],
             :parsed-word "pōnī"})
   "pōnit" '({:definition "he places",
              :part-of-speech :verb,
              :sectioned-word "pōn.it",
              :dictionary-code
              {:age nil,
               :area nil,
               :geo nil,
               :freq-code nil,
               :freq-text nil,
               :source nil},
              :dictionary-entry "pōnō, pōnere, posuī, positus",
              :original-word "pōnit",
              :conjugation 3,
              :options
              [{:tense :present,
                :person 3,
                :number :singular,
                :part-of-speech :verb,
                :sectioned-word "pōn.it",
                :voice :active,
                :mood :indicative,
                :conjugation 3,
                :stem "pōn",
                :ending "it"}],
              :parsed-word "pōnit"})
   "pōne" '({:definition "place!",
             :part-of-speech :verb,
             :sectioned-word "pōne",
             :dictionary-code
             {:age nil,
              :area nil,
              :geo nil,
              :freq-code nil,
              :freq-text nil,
              :source nil},
             :dictionary-entry "pōnō, pōnere, posuī, positus",
             :original-word "pōne",
             :conjugation 3,
             :options
             [{:tense :present,
               :person nil,
               :number nil,
               :part-of-speech :verb,
               :sectioned-word "pōne",
               :voice :active,
               :mood :imperative,
               :conjugation 3,
               :stem "pōn",
               :ending "e"}
              ],
             :parsed-word "pōne"})
   "Tusculī" '({:options
                [{:sectioned-word "Tuscul.ī",
                  :stem "Tuscul",
                  :ending "ī",
                  :part-of-speech :noun,
                  :declension 2,
                  :case :genitive,
                  :number :singular,
                  :gender :neuter}
                 {:sectioned-word "Tuscul.ī",
                  :stem "Tuscul",
                  :ending "ī",
                  :part-of-speech :noun,
                  :declension 1,
                  :case :genitive,
                  :number :singular,
                  :gender :neuter}],
                :part-of-speech :noun,
                :dictionary-entry "Tusculum, Tusculī",
                :definition "Tusculum, a city in ancient Italy. The city was destroyed in April 1191 AD. (locative or genitive case)",
                :dictionary-code
                {:age nil,
                 :area nil,
                 :geo "Italy, Rome",
                 :freq-code :A,
                 :freq-text "Very frequent, in all Elementry Latin books",
                 :source nil},
                :original-word "Tusculī",
                :parsed-word "Tusculī"})
   "Tusculum" '({:options
                [{:sectioned-word "Tuscul.um",
                  :stem "Tuscul",
                  :ending "um",
                  :part-of-speech :noun,
                  :declension 2,
                  :case :accusative,
                  :number :singular,
                  :gender :neuter}],
                :part-of-speech :noun,
                :dictionary-entry "Tusculum, Tusculī",
                :definition "Tusculum, a city in ancient Italy. The city was destroyed in April 1191 AD. (nominative or accusative case)",
                :dictionary-code
                {:age nil,
                 :area nil,
                 :geo "Italy, Rome",
                 :freq-code :A,
                 :freq-text "Very frequent, in all Elementry Latin books",
                 :source nil},
                :original-word "Tusculum",
                :parsed-word "Tusculum"})
   "occīdit" '({:definition "he killed",
             :part-of-speech :verb,
             :sectioned-word "occīd.it",
             :dictionary-code
             {:age nil,
              :area nil,
              :geo nil,
              :freq-code nil,
              :freq-text nil,
              :source nil},
             :dictionary-entry "occīdō, occīdere, occīdī, occīsus",
             :original-word "occīdit",
             :conjugation 3,
             :options
             [{:tense :perfect,
               :person 3,
               :number :singular,
               :part-of-speech :verb,
               :sectioned-word "occīd.it",
               :voice :active,
               :mood :indicative,
               :conjugation 3,
               :stem "occīd",
               :ending "it"},
              {:tense :present,
               :person 3,
               :number :singular,
               :part-of-speech :verb,
               :sectioned-word "occīd.it",
               :voice :active,
               :mood :indicative,
               :conjugation 3,
               :stem "occīd",
               :ending "it"}
              ],
             :parsed-word "occīdit"})
   "quamdam" '({:options
                [{:word "quamdam",
                  :part-of-speech :pronoun,
                  :case :accusative,
                  :number :singular,
                  :gender :feminine}],
                :word "quamdam",
                :part-of-speech :pronoun,
                :dictionary-entry "quīdam",
                :definition "a certain",
                :dictionary-code
                {:age nil,
                 :area nil,
                 :geo nil,
                 :freq-code :A,
                 :freq-text "Very frequent, in all Elementry Latin books",
                 :source nil},
                :original-word "quamdam",
                :parsed-word "quamdam"})
   "quemdam" '({:options
                [{:word "quemdam",
                  :part-of-speech :pronoun,
                  :case :accusative,
                  :number :singular,
                  :gender :feminine}],
                :word "quemdam",
                :part-of-speech :pronoun,
                :dictionary-entry "quīdam",
                :definition "a certain",
                :dictionary-code
                {:age nil,
                 :area nil,
                 :geo nil,
                 :freq-code :A,
                 :freq-text "Very frequent, in all Elementry Latin books",
                 :source nil},
                :original-word "quemdam",
                :parsed-word "quemdam"})
   })
