(ns whitakers-clj.core
  (:require [whitakers-clj.dictionary-codes :refer [parse-dictionary-code]]))

(def part-of-speech
  {"N" :noun
   "V" :verb})

(def grammatical-case
  {"NOM" :nominative
   "GEN" :genitive
   "DAT" :dative
   "ACC" :accusative
   "ABL" :ablative
   "VOC" :vocative})

(def grammatical-number
  {"S" :singular
   "P" :plural})

(def gender
  {"M" :masculine
   "F" :feminine
   "N" :neuter})

(defn parse-noun-option-line [pieces]
  (let [sectioned-word (get pieces 0)
        [stem ending] (clojure.string/split sectioned-word #"\.")]
    {:sectioned-word sectioned-word
     :stem stem
     :ending ending
     :part-of-speech (part-of-speech (get pieces 1))
     :declension (parse-long (get pieces 2))
     ;; :variant (parse-long (get pieces 3)) ;; not sure this means anything grammatical
     :case (grammatical-case (get pieces 4))
     :number (grammatical-number (get pieces 5))
     :gender (gender (get pieces 6))}))

(defn add-verb-pieces [pieces]
  {:sectioned-word (get-in pieces [0 0])
   :part-of-speech (part-of-speech (get-in pieces [0 1]))
   :conjugation (parse-long (get-in pieces [0 2]))})

(defn add-noun-pieces [pieces]
  (let [sectioned-word (get-in pieces [0 0])
        [stem ending] (clojure.string/split sectioned-word #"\.")
        dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:options (mapv parse-noun-option-line (drop-last 2 pieces))
     :part-of-speech :noun
     :dictionary-entry (str (get dictionary-entry-line 0) " " (get dictionary-entry-line 1))
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (get-in pieces [1 5]))}))

(def parse-by-part-of-speech
  {:verb add-verb-pieces
   :noun add-noun-pieces})

(defn parse-single-word-output [paragraph]
  (let [lines (clojure.string/split-lines paragraph)
        pieces (mapv #(clojure.string/split % #" +") lines)
        part-of-speech (part-of-speech (get-in pieces [0 1]))]
    ((parse-by-part-of-speech part-of-speech) pieces)))

(defn is-parsing-options-line? [line]
  (boolean (re-find #"     " line)))

(defn split-paragraphs
  ([paragraphs]
   (split-paragraphs paragraphs []))
  ([paragraphs already-split-paragraphs]
   (if (empty? paragraphs)
     already-split-paragraphs
     (let [lines (clojure.string/split-lines paragraphs)
           first-paragraph-options (take-while is-parsing-options-line? lines)
           num-option-lines (count first-paragraph-options)
           first-paragraph (clojure.string/join "\n" (take (+ 2 num-option-lines) lines))
           remainder (clojure.string/join "\n" (drop (+ 2 num-option-lines) lines))]
       (split-paragraphs remainder (concat already-split-paragraphs [first-paragraph]))))))
