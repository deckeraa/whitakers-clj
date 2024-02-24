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
      )))

