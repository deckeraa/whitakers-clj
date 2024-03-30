(ns whitakers-clj.core-test
  (:require [clojure.test :refer :all]
            [whitakers-clj.core :refer :all]))

(def amo-paragraph
"am.o                 V      1 1 PRES ACTIVE  IND 1 S    
amo, amare, amavi, amatus  V (1st)   [XXXAO]  
love, like; fall in love with; be fond of; have a tendency to;")

(def agricolarum-paragraph
"agricol.arum         N      1 1 GEN P M                 
agricola, agricolae  N (1st) M   [XAXBO]  
farmer, cultivator, gardener, agriculturist; plowman, countryman, peasant;")

(def agricolarum-paragraphs
"agricol.arum         N      1 1 GEN P M                 
agricola, agricolae  N (1st) M   [XAXBO]  
farmer, cultivator, gardener, agriculturist; plowman, countryman, peasant;
agricolar.um         ADJ    3 2 GEN P X POS             
agricolaris, agricolaris, agricolare  ADJ   [XAXES]    uncommon
farmer-; relating to farmers;")

(def vis-paragraphs
"vis                  V      6 2 PRES ACTIVE  IND 2 S    
vis  X   [XXXAX]  
be willing; wish;
vis                  N      3 3 NOM S F                 
vis                  N      3 3 VOC S F                 
v.is                 N      3 3 GEN S F                 
v.is                 N      3 3 ACC P F                   Early   
vis, vis  N (3rd) F   [XXXAX]  
strength (sg. only), force, power, might, violence;
vis                  N      3 3 NOM S F                 
vis                  N      3 3 VOC S F                 
vis, viris  N (3rd) F   [XXXAX]  
strength (bodily) (pl.), force, power, might, violence; resources; large body;")

(def cornu-paragraphs
"corn.u               N      4 1 ABL S F                 
cornus, cornus  N (4th) F   [XXXCO]  
cornel-cherry-tree (Cornus mas); cornel wood; javelin (of cornel wood);
corn.u               N      4 2 NOM S N                 
corn.u               N      4 2 VOC S N                 
corn.u               N      4 2 DAT S N                 
corn.u               N      4 2 ABL S N                 
corn.u               N      4 2 ACC S N                 
cornu, cornus  N (4th) N   [XXXAO]  
horn; hoof; beak/tusk/claw; bow; horn/trumpet; end, wing of army; mountain top;")

(def ego-paragraph
"ego                  PRON   5 1 NOM S C                 
 [XXXAX]  
I, me (PERS); myself (REFLEX);")

(def illud-paragraph
"ill.ud               PRON   6 1 NOM S N                 
ill.ud               PRON   6 1 ACC S N                 
ille, illa, illud  PRON   [XXXAX]  
that; those (pl.); also DEMONST; that person/thing; the well known; the former;
*"
  )

(def bonum-paragraphs
"bon.um               N      2 1 ACC S M                 
bonus, boni  N (2nd) M   [XXXCO]  
good/moral/honest/brave man; man of honor, gentleman; better/rich people (pl.);
bon.um               N      2 2 NOM S N                 
bon.um               N      2 2 VOC S N                 
bon.um               N      2 2 ACC S N                 
bonum, boni  N (2nd) N   [XXXAO]  
good, good thing, profit, advantage; goods (pl.), possessions, wealth, estate;
bon.um               ADJ    1 1 NOM S N POS             
bon.um               ADJ    1 1 VOC S N POS             
bon.um               ADJ    1 1 ACC S M POS             
bon.um               ADJ    1 1 ACC S N POS             
bonus, bona -um, melior -or -us, optimus -a -um  ADJ   [XXXAO]  
good, honest, brave, noble, kind, pleasant, right, useful; valid; healthy;
*")

(def edere-paragraphs
"ed.ere               V      3 1 PRES ACTIVE  INF 0 X    
ed.ere               V      3 1 PRES PASSIVE IMP 2 S    
ed.ere               V      3 1 FUT  PASSIVE IND 2 S    
ed.ere               V      3 1 PERF ACTIVE  IND 3 P    
edo, edere, edi, esus  V (3rd) TRANS   [XXXCO]  
edo, edere, edi, essus  V (3rd) TRANS   [XXXCO]  
eat/consume/devour; eat away (fire/water/disease); destroy; spend money on food
ed.ere               V      1 1 PRES PASSIVE SUB 2 S    
edo, edare, edidi, editus  V (1st) TRANS   [XXXAO]  
eject/emit; put/give forth (buds); beget; bear (fruit); display/evince/exhibit;
utter solemnly; pronounce/decree (oracle); deliver (message); issue (command);
publish; disclose, tell, relate, make known; declare, make formal statement;
cause; see birth of; be birthplace/breeding ground of; debouch (river PASS);
bring forth,  produce/yield (crops), give birth to (often PASS PERF VPAR);
notify of suit; nominate for jury; appoint/set (a time); bring witnesses;
present (documents for inspection; put on (play); hold (banquet); uplift;
*")

(def olim-paragraph
"olim                 ADV    POS                         
olim  ADV   [XXXAX]  
formerly; once, once upon a time; in the future;")

(def fortiter-paragraph
"fortiter             ADV    POS                         
fortiter, fortius, fortissime  ADV   [XXXDX]    lesser
strongly; bravely; boldly;")

(def unknown-paragraphs
  "Phoebus                        ========   UNKNOWN    ")

(def sed-paragraph
  "sed                  CONJ                               
sed  CONJ   [XXXAX]  
but, but also; yet; however, but in fact/truth; not to mention; yes but;")

(def in-paragraphs
"in                   PREP   ABL                         
in  PREP  ABL   [XXXAX]  
in, on, at (space); in accordance with/regard to/the case of; within (time);
in                   PREP   ACC                         
in  PREP  ACC   [XXXAX]  
into; about, in the mist of; according to, after (manner); for; to, among;")

(def mare-adjective-paragraph
"mare                 ADJ    3 1 NOM S N POS             
mare  X   [XXXFO]    veryrare
male; masculine, of the male sex; manly, virile, brave, noble; G:masculine;")

(def ic-paragraph
"ic                   SUFFIX                             
-ic; of, pertaining/belonging to; connected with; derived/coming from (place);")

(deftest dictionary-entry-from-pieces-test
  (testing "adjective"
    (is (= (dictionary-entry-from-pieces (clojure.string/split "agricolaris, agricolaris, agricolare  ADJ   [XAXES]    uncommon" #" "))
           "agricolaris, agricolaris, agricolare"))
    ;; TODO -- for some reason Whitaker's Words sends an "X" as the part of speech in this line?
    ;; (is (= (dictionary-entry-from-pieces (clojure.string/split "mare  X   [XXXFO]    veryrare" #" "))
    ;;        "mare"))
    )
  (testing "adverb"
    (is (= (dictionary-entry-from-pieces (clojure.string/split "olim  ADV   [XXXAX]  " #" "))
           "olim"))
    (is (= (dictionary-entry-from-pieces (clojure.string/split "fortiter, fortius, fortissime  ADV   [XXXDX]    lesser" #" "))
           "fortiter, fortius, fortissime")))
  (testing "conjunction"
    (is (= (dictionary-entry-from-pieces (clojure.string/split "sed  CONJ   [XXXAX]  " #" "))
           "sed")))
  (testing "preposition"
    (is (= (dictionary-entry-from-pieces (clojure.string/split "in  PREP  ACC   [XXXAX]  " #" "))
           "in"))))

(deftest dictionary-code-from-pieces-test
  (testing "adjective"
    (is (= (dictionary-code-from-pieces (clojure.string/split "agricolaris, agricolaris, agricolare  ADJ   [XAXES]    uncommon" #" "))
           "[XAXES]"))
    (is (= (dictionary-code-from-pieces (clojure.string/split "mare  X   [XXXFO]    veryrare" #" "))
           "[XXXFO]")))
  (testing "adverb"
    (is (= (dictionary-code-from-pieces (clojure.string/split "olim  ADV   [XXXAX]  " #" "))
           "[XXXAX]"))
    (is (= (dictionary-code-from-pieces (clojure.string/split "fortiter, fortius, fortissime  ADV   [XXXDX]    lesser" #" "))
           "[XXXDX]"))
    )
  (testing "conjunction"
    (is (= (dictionary-code-from-pieces (clojure.string/split "sed  CONJ   [XXXAX]  " #" "))
           "[XXXAX]")))
  (testing "noun"
    (is (= (dictionary-code-from-pieces (clojure.string/split "agricola, agricolae  N (1st) M   [XAXBO]  " #" "))
           "[XAXBO]")))
  (testing "preposition"
    (is (= (dictionary-code-from-pieces (clojure.string/split "in  PREP  ACC   [XXXAX]  " #" "))
           "[XXXAX]")))
  (testing "pronoun"
    (is (= (dictionary-code-from-pieces (clojure.string/split "is, ea, id  PRON   [XXXAX]  " #" "))
           "[XXXAX]")))
  (testing "verb"
    (is (= (dictionary-code-from-pieces (clojure.string/split "amo, amare, amavi, amatus  V (1st)   [XXXAO]  " #" "))
           "[XXXAO]")))
  (testing "verb with an X?"
    "vis  X   [XXXAX]  "
    (is (= (dictionary-code-from-pieces (clojure.string/split "amo, amare, amavi, amatus  V (1st)   [XXXAO]  " #" "))
           "[XXXAO]")))
  (testing "no dictionary entry (e.g. 'ego')"
    (is (= (dictionary-code-from-pieces (clojure.string/split " [XXXAX]  " #" "))
           "[XXXAX]"))))

(deftest parse-single-word-output-test
  (testing "amo"
    (let [parsed-obj (parse-single-word-output amo-paragraph)]
      (is (= (get-in parsed-obj [:options 0 :stem]) "am"))
      (is (= (get-in parsed-obj [:options 0 :ending]) "o"))
      (is (= (get-in parsed-obj [:options 0 :part-of-speech]) :verb))
      (is (= (get-in parsed-obj [:options 0 :conjugation]) 1))
      (is (= (get-in parsed-obj [:options 0 :tense]) :present))
      (is (= (get-in parsed-obj [:options 0 :voice]) :active))
      (is (= (get-in parsed-obj [:options 0 :mood]) :indicative))
      (is (= (get-in parsed-obj [:options 0 :number]) :singular))
      (is (= (get-in parsed-obj [:options 0 :person]) 1))
      (is (= (get-in parsed-obj [:sectioned-word]) "am.o"))
      (is (= (get-in parsed-obj [:part-of-speech]) :verb))
      (is (= (get-in parsed-obj [:conjugation]) 1))
      (is (= (get-in parsed-obj [:dictionary-entry]) "amo, amare, amavi, amatus"))
      (is (= (get-in parsed-obj [:definition]) "love, like; fall in love with; be fond of; have a tendency to;"))
      (is (= (get-in parsed-obj [:dictionary-code :freq-code]) :A))
      ))
  (testing "agricolarum"
    (let [parsed-obj (parse-single-word-output agricolarum-paragraph)]
      (is (= (get-in parsed-obj [:options 0 :stem]) "agricol"))
      (is (= (get-in parsed-obj [:options 0 :ending]) "arum"))
      (is (= (get-in parsed-obj [:options 0 :part-of-speech]) :noun))
      (is (= (get-in parsed-obj [:options 0 :declension]) 1))
      (is (= (get-in parsed-obj [:options 0 :case]) :genitive))
      (is (= (get-in parsed-obj [:options 0 :number]) :plural))
      (is (= (get-in parsed-obj [:options 0 :gender]) :masculine))
      (is (= (get-in parsed-obj [:part-of-speech]) :noun))
      (is (= (get-in parsed-obj [:dictionary-entry]) "agricola, agricolae"))
      (is (= (get-in parsed-obj [:definition]) "farmer, cultivator, gardener, agriculturist; plowman, countryman, peasant;"))
      (is (= (get-in parsed-obj [:dictionary-code :freq-text]) "In top 10 percent"))))
  (testing "ego"
    (let [parsed-obj (parse-single-word-output ego-paragraph)]
      (is (= (get-in parsed-obj [:options 0 :word]) "ego"))
      (is (= (get-in parsed-obj [:options 0 :part-of-speech]) :pronoun))
      (is (= (get-in parsed-obj [:options 0 :declension]) 5))
      (is (= (get-in parsed-obj [:options 0 :case]) :nominative))
      (is (= (get-in parsed-obj [:options 0 :number]) :singular))
      (is (= (get-in parsed-obj [:options 0 :gender]) :common))
      (is (= (get-in parsed-obj [:part-of-speech]) :pronoun))
      (is (= (get-in parsed-obj [:dictionary-entry]) nil))
      (is (= (get-in parsed-obj [:definition]) "I, me (PERS); myself (REFLEX);"))
      (is (= (get-in parsed-obj [:dictionary-code :freq-code]) :A))))
  (testing "olim"
    (let [parsed-obj (parse-single-word-output olim-paragraph)]
      (is (= (get-in parsed-obj [:word]) "olim"))
      (is (= (get-in parsed-obj [:part-of-speech]) :adverb))
      (is (= (get-in parsed-obj [:dictionary-entry]) "olim"))
      (is (= (get-in parsed-obj [:degree]) :positive))
      (is (= (get-in parsed-obj [:definition]) "formerly; once, once upon a time; in the future;"))
      (is (= (get-in parsed-obj [:dictionary-code :freq-code]) :A)))
    )
  (testing "sed"
    (let [parsed-obj (parse-single-word-output sed-paragraph)]
      (is (= (get-in parsed-obj [:word]) "sed"))
      (is (= (get-in parsed-obj [:part-of-speech]) :conjunction))
      (is (= (get-in parsed-obj [:dictionary-entry]) "sed"))
      (is (= (get-in parsed-obj [:definition]) "but, but also; yet; however, but in fact/truth; not to mention; yes but;"))
      (is (= (get-in parsed-obj [:dictionary-code :freq-code]) :A))))
  (testing "ic"
    (let [parsed-obj (parse-single-word-output ic-paragraph)]
      (is (= (get-in parsed-obj [:word]) "ic"))
      (is (= (get-in parsed-obj [:part-of-speech]) :suffix))
      (is (= (get-in parsed-obj [:definition]) "-ic; of, pertaining/belonging to; connected with; derived/coming from (place);")))))

(deftest parse-paragraphs-test
  (testing "agricolarum"
    (let [parsed-obj (parse-paragraphs agricolarum-paragraphs)]
      (is (= (count parsed-obj) 2))
      (is (= (get-in parsed-obj [0 :dictionary-entry "agricola, agricolae"])))
      (is (= (get-in parsed-obj [1 :dictionary-entry "agricolaris, agricolaris, agricolare"])))))
  (testing "vis"
    (let [parsed-obj (parse-paragraphs vis-paragraphs)]
      (is (= (count parsed-obj) 3))
      (is (= (get-in parsed-obj [0 :dictionary-entry "vis"])))
      (is (= (get-in parsed-obj [1 :dictionary-entry "vis, vis"])))
      (is (= (get-in parsed-obj [1 :dictionary-entry "vis, viris"])))))
  (testing "unknown"
    (let [parsed-obj (parse-paragraphs unknown-paragraphs)]
      (is (= (count parsed-obj) 1))
      (is (= (get-in parsed-obj [0 :word "Phoebus"])))
      (is (= (get-in parsed-obj [0 :part-of-speech :unknown])))))
  (testing "in"
    (let [parsed-obj (parse-paragraphs in-paragraphs)]
      (is (= (count parsed-obj) 2))
      (is (= (get-in parsed-obj [0 :word "in"])))
      (is (= (get-in parsed-obj [0 :part-of-speech :preposition])))
      (is (= (get-in parsed-obj [0 :case :ablative])))
      (is (= (get-in parsed-obj [0 :word "in"])))
      (is (= (get-in parsed-obj [0 :part-of-speech :preposition])))
      (is (= (get-in parsed-obj [0 :case :accusative]))))))

(deftest is-parsing-options-line?-test
  (is (= (is-parsing-options-line? "bon.um               ADJ    1 1 NOM S N POS             ") true))
  (is (= (is-parsing-options-line? "bonum, boni  N (2nd) N   [XXXAO]  ") false)))

(deftest is-parsing-dictionary-entry-line?-test
  (is (= (is-parsing-dictionary-entry-line? "edo, edere, edi, esus  V (3rd) TRANS   [XXXCO]  ") true))
  (is (= (is-parsing-dictionary-entry-line? "publish; disclose, tell, relate, make known; declare, make formal statement;") false)))

(deftest split-paragraphs-test
  (is (= (split-paragraphs cornu-paragraphs)
         ["corn.u               N      4 1 ABL S F                 
cornus, cornus  N (4th) F   [XXXCO]  
cornel-cherry-tree (Cornus mas); cornel wood; javelin (of cornel wood);"
          
          "corn.u               N      4 2 NOM S N                 
corn.u               N      4 2 VOC S N                 
corn.u               N      4 2 DAT S N                 
corn.u               N      4 2 ABL S N                 
corn.u               N      4 2 ACC S N                 
cornu, cornus  N (4th) N   [XXXAO]  
horn; hoof; beak/tusk/claw; bow; horn/trumpet; end, wing of army; mountain top;"
          ]))
  (is (= (split-paragraphs bonum-paragraphs)
         ["bon.um               N      2 1 ACC S M                 
bonus, boni  N (2nd) M   [XXXCO]  
good/moral/honest/brave man; man of honor, gentleman; better/rich people (pl.);"
          
          "bon.um               N      2 2 NOM S N                 
bon.um               N      2 2 VOC S N                 
bon.um               N      2 2 ACC S N                 
bonum, boni  N (2nd) N   [XXXAO]  
good, good thing, profit, advantage; goods (pl.), possessions, wealth, estate;"
          
          "bon.um               ADJ    1 1 NOM S N POS             
bon.um               ADJ    1 1 VOC S N POS             
bon.um               ADJ    1 1 ACC S M POS             
bon.um               ADJ    1 1 ACC S N POS             
bonus, bona -um, melior -or -us, optimus -a -um  ADJ   [XXXAO]  
good, honest, brave, noble, kind, pleasant, right, useful; valid; healthy;"
          ]))
  (is (= (split-paragraphs edere-paragraphs)
         ["ed.ere               V      3 1 PRES ACTIVE  INF 0 X    
ed.ere               V      3 1 PRES PASSIVE IMP 2 S    
ed.ere               V      3 1 FUT  PASSIVE IND 2 S    
ed.ere               V      3 1 PERF ACTIVE  IND 3 P    
edo, edere, edi, esus  V (3rd) TRANS   [XXXCO]  
eat/consume/devour; eat away (fire/water/disease); destroy; spend money on food"
          
          "ed.ere               V      1 1 PRES PASSIVE SUB 2 S    
edo, edare, edidi, editus  V (1st) TRANS   [XXXAO]  
eject/emit; put/give forth (buds); beget; bear (fruit); display/evince/exhibit; utter solemnly; pronounce/decree (oracle); deliver (message); issue (command); publish; disclose, tell, relate, make known; declare, make formal statement; cause; see birth of; be birthplace/breeding ground of; debouch (river PASS); bring forth,  produce/yield (crops), give birth to (often PASS PERF VPAR); notify of suit; nominate for jury; appoint/set (a time); bring witnesses; present (documents for inspection; put on (play); hold (banquet); uplift;"
          ]))
  )

(def mare-parsed-snipped
  [{:options :snipped
   :part-of-speech :adjective,
   :dictionary-entry "mare X [XXXFO] veryrare",
   :definition
   "male; masculine, of the male sex; manly, virile, brave, noble; G:masculine;",
   :dictionary-code
   {:age nil,
    :area nil,
    :geo nil,
    :freq-code :F,
    :freq-text "Very rare, having only single citation in OLD or L+S",
    :source "Oxford Latin Dictionary, 1982 (OLD)"}}
  {:options :snipped
   :part-of-speech :noun,
   :dictionary-entry "mare, maris",
   :definition "sea; sea water;",
   :dictionary-code
   {:age nil,
    :area nil,
    :geo nil,
    :freq-code :A,
    :freq-text "Very frequent, in all Elementry Latin books",
    :source nil}}
  {:options :snipped
   :part-of-speech :noun,
   :dictionary-entry "mas, maris",
   :definition "male (human/animal/plant); man;",
   :dictionary-code
   {:age nil,
    :area nil,
    :geo nil,
    :freq-code :C,
    :freq-text "In top 10,000 words",
    :source "Oxford Latin Dictionary, 1982 (OLD)"}}
  {:options :snipped
   :part-of-speech :adjective,
   :dictionary-entry "mas, (gen.), maris",
   :definition
   "male; masculine, of the male sex; manly, virile, brave, noble; G:masculine;\r",
   :dictionary-code
   {:age nil,
    :area nil,
    :geo nil,
    :freq-code :C,
    :freq-text "In top 10,000 words",
    :source "Oxford Latin Dictionary, 1982 (OLD)"}}])

(deftest get-most-frequent-test
  (is (= (:definition (get-most-frequent mare-parsed-snipped))
         "sea; sea water;"))
  (is (= (:definition (get-most-frequent
                       [{:definition "no freq-code"}
                        {:definition "freq-code"
                         :dictionary-code {:freq-code :C}}]))
         "freq-code")))
