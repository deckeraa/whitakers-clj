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
farmer, cultivator, gardener, agriculturist; plowman, countryman, peasant;
agricolar.um         ADJ    3 2 GEN P X POS             
agricolaris, agricolaris, agricolare  ADJ   [XAXES]    uncommon
farmer-; relating to farmers;")

(deftest parse-single-word-output-test
  (testing "amo"
    (let [parsed-obj (parse-single-word-output amo-paragraph)]
      (is (= (:sectioned-word parsed-obj) "am.o"))
      (is (= (:part-of-speech parsed-obj) :verb))
      (is (= (:conjugation parsed-obj) 1))))
  (testing "agricolarum"
    (let [parsed-obj (parse-single-word-output agricolarum-paragraph)]
      (is (= (:stem parsed-obj) "agricol"))
      (is (= (:ending parsed-obj) "arum"))
      (is (= (:part-of-speech parsed-obj) :noun))
      (is (= (:declension parsed-obj) 1))
      (is (= (:case parsed-obj) :genitive))
      (is (= (:number parsed-obj) :plural))
      (is (= (:gender parsed-obj) :masculine))
      (is (= (:dictionary-entry parsed-obj) "agricola, agricolae"))
      (is (= (:definition parsed-obj) "farmer, cultivator, gardener, agriculturist; plowman, countryman, peasant;"))
      (is (= (get-in parsed-obj [:dictionary-code :freq-text]) "In top 10 percent")))))

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

[{:dictionary-entry "cornus, cornus"
  :definition "cornel-cherry-tree (Cornus mas); cornel wood; javelin (of cornel wood);"
  :options [{:stem "corn"
             :ending "u"
             :case :ablative
             }]}
 {:dictionary-entry "cornu, cornus"
  :definition "horn; hoof; beak/tusk/claw; bow; horn/trumpet; end, wing of army; mountain top;"
  :option [{:stem "corn"
            :ending "u"
            :case :nominative}
           {:stem "corn"
            :ending "u"
            :case :vocative}]}]

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

(deftest is-parsing-options-line?-test
  (is (= (is-parsing-options-line? "bon.um               ADJ    1 1 NOM S N POS             ") true))
  (is (= (is-parsing-options-line? "bonum, boni  N (2nd) N   [XXXAO]  ") false)))

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
          ])))
