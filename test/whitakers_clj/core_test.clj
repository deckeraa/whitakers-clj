(ns whitakers-clj.core-test
  (:require [clojure.test :refer :all]
            [whitakers-clj.core :refer :all]))

(def amo-paragraph
"am.o                 V      1 1 PRES ACTIVE  IND 1 S    
amo, amare, amavi, amatus  V (1st)   [XXXAO]  
love, like; fall in love with; be fond of; have a tendency to;")

(deftest parse-single-word-output-test
  (let [parsed-obj (parse-single-word-output amo-paragraph)]
    (is (= (:sectioned-word parsed-obj) "am.o"))
    (is (= (:part-of-speech parsed-obj) :verb))
    (is (= (:declension parsed-obj) 1))))
