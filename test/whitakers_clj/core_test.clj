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

(deftest dictionary-entry-from-pieces-test
  (testing "adjective"
    (is (= (dictionary-entry-from-pieces (clojure.string/split "agricolaris, agricolaris, agricolare  ADJ   [XAXES]    uncommon" #" "))
           "agricolaris, agricolaris, agricolare")))
  (testing "adverb"
    (is (= (dictionary-entry-from-pieces (clojure.string/split "olim  ADV   [XXXAX]  " #" "))
           "olim"))
    (is (= (dictionary-entry-from-pieces (clojure.string/split "fortiter, fortius, fortissime  ADV   [XXXDX]    lesser" #" "))
           "fortiter, fortius, fortissime"))
    ))

(deftest dictionary-code-from-pieces-test
  (testing "adjective"
    (is (= (dictionary-code-from-pieces (clojure.string/split "agricolaris, agricolaris, agricolare  ADJ   [XAXES]    uncommon" #" "))
           "[XAXES]")))
  (testing "adverb"
    (is (= (dictionary-code-from-pieces (clojure.string/split "olim  ADV   [XXXAX]  " #" "))
           "[XXXAX]"))
    (is (= (dictionary-code-from-pieces (clojure.string/split "fortiter, fortius, fortissime  ADV   [XXXDX]    lesser" #" "))
           "[XXXDX]"))
    )
  (testing "noun"
    (is (= (dictionary-code-from-pieces (clojure.string/split "agricola, agricolae  N (1st) M   [XAXBO]  " #" "))
           "[XAXBO]")))
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
    "olim                 ADV    POS                         
olim  ADV   [XXXAX]  
formerly; once, once upon a time; in the future;"
    (let [parsed-obj (parse-single-word-output olim-paragraph)]
      (is (= (get-in parsed-obj [:word]) "olim"))
      (is (= (get-in parsed-obj [:part-of-speech]) :adverb))
      (is (= (get-in parsed-obj [:dictionary-entry]) "olim"))
      (is (= (get-in parsed-obj [:degree]) :positive))
      (is (= (get-in parsed-obj [:definition]) "formerly; once, once upon a time; in the future;"))
      (is (= (get-in parsed-obj [:dictionary-code :freq-code]) :A)))
    ))

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
      (is (= (get-in parsed-obj [1 :dictionary-entry "vis, viris"]))))))

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
