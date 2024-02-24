(ns whitakers-clj.core
  (:require [whitakers-clj.dictionary-codes :refer [parse-dictionary-code]]))

(def part-of-speech
  {"N" :noun
   "V" :verb
   "ADJ" :adjective})

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

(def adjective-type
  {"POS" :positive
   "COMP" :comparitive
   "SUPER" :superlative})

(defn dictionary-entry-from-pieces [pieces]
  (->> (take-while #(not (part-of-speech %)) pieces)
       (clojure.string/join " " )
       clojure.string/trim))

(defn add-verb-pieces [pieces]
  {:sectioned-word (get-in pieces [0 0])
   :part-of-speech (part-of-speech (get-in pieces [0 1]))
   :conjugation (parse-long (get-in pieces [0 2]))})

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

(defn add-noun-pieces [pieces]
  (let [sectioned-word (get-in pieces [0 0])
        [stem ending] (clojure.string/split sectioned-word #"\.")
        dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:options (mapv parse-noun-option-line (drop-last 2 pieces))
     :part-of-speech :noun
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (get-in pieces [1 5]))}))

(defn parse-adjective-option-line [pieces]
  (let [sectioned-word (get pieces 0)
        [stem ending] (clojure.string/split sectioned-word #"\.")]
    {:sectioned-word sectioned-word
     :stem stem
     :ending ending
     :part-of-speech :adjective
     :declension (parse-long (get pieces 2))
     ;; :variant (parse-long (get pieces 3)) ;; not sure this means anything grammatical
     :case (grammatical-case (get pieces 4))
     :number (grammatical-number (get pieces 5))
     :gender (gender (get pieces 6))
     :type (adjective-type (get pieces 7))}))

(defn add-adjective-pieces [pieces]
  (let [sectioned-word (get-in pieces [0 0])
        [stem ending] (clojure.string/split sectioned-word #"\.")
        dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:options (mapv parse-noun-option-line (drop-last 2 pieces))
     :part-of-speech :adjective
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
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
