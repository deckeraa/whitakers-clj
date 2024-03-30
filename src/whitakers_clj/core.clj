(ns whitakers-clj.core
  (:require [whitakers-clj.dictionary-codes :refer [parse-dictionary-code]]
            [clojure.java.shell :refer [sh]]
            [clojure.java.io :as io])
  (:use clojure.pprint)
  (:gen-class))

(def parts-of-speech-not-yet-implemented
  {"PACK" :propack?
   "NUM"  :numeral
   "VPAR" :verbal-participle?
   "SUPINE" :supine
   "INTERJ" :interjection
   "TACKON" :tackon
   })

(def part-of-speech
  {"ADJ" :adjective
   "ADV" :adverb
   "CONJ" :conjunction
   "N" :noun
   "PREP" :preposition
   "PRON" :pronoun
   "UNKNOWN" :unknown
   "========" :unknown
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
   "N" :neuter
   "C" :common})

(def degree
  {"POS" :positive
   "COMP" :comparitive
   "SUPER" :superlative})

(def tense
  {"PRES" :present
   "IMPF" :imperfect
   "FUT"  :future
   "PERF" :perfect
   "PLUP" :pluperfect
   "FUTP" :future-perfect})

(def voice
  {"ACTIVE" :active
   "PASSIVE" :passive})

(def mood
  {"IND" :indicative
   "SUB" :subjunctive
   "IMP" :imperative
   "INF" :infinitive
   "PPL" :participle
   })

(defn dictionary-entry-from-pieces [pieces]
  (let [pieces (remove empty? pieces)]
    (if (= 1 (count pieces))
      nil ;; no dictionary entry, see "ego" for an example.
      (->> (take-while #(not (part-of-speech %)) pieces)
           (clojure.string/join " " )
           clojure.string/trim))))

;; (defn dictionary-code-from-pieces [pieces]
;;   (let [pieces (remove empty? pieces)]
;;     (if (= 1 (count pieces))
;;       (clojure.string/trim (first pieces)) ;; no dictionary entry, see "ego" for an example.
;;       (let [pieces (drop-while #(not (part-of-speech %)) pieces)
;;             pos (part-of-speech (first pieces))
;;             pieces (case pos
;;                      :noun (nthrest pieces 3)
;;                      :verb (nthrest pieces 2)
;;                      (rest pieces))]
;;         (->> pieces
;;              first
;;              clojure.string/trim)))))

(defn dictionary-code-from-pieces [pieces]
  (re-find #"\[\w{5}\]" (clojure.string/join " " pieces)))

(defn parse-adjective-option-line [pieces]
  (let [sectioned-word (get pieces 0)
        [stem ending] (clojure.string/split sectioned-word #"\.")]
    {:sectioned-word sectioned-word
     :stem stem
     :ending ending
     :part-of-speech :adjective
     :declension (parse-long (get pieces 2))
     :case (grammatical-case (get pieces 4))
     :number (grammatical-number (get pieces 5))
     :gender (gender (get pieces 6))
     :degree (degree (get pieces 7))}))

(defn add-adjective-pieces [pieces]
  (let [sectioned-word (get-in pieces [0 0])
        [stem ending] (clojure.string/split sectioned-word #"\.")
        dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:options (mapv parse-adjective-option-line (drop-last 2 pieces))
     :part-of-speech :adjective
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))}))

(defn add-adverb-pieces [pieces]
  (let [word (get-in pieces [0 0])
        dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:word word
     :part-of-speech :adverb
     :degree (degree (get-in pieces [0 2]))
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))}))

(defn add-conjunction-pieces [pieces]
  (let [word (get-in pieces [0 0])
        dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:word word
     :part-of-speech :conjunction
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))}))

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
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))}))

(defn  add-participle-pieces [pieces]
  (let [word (get-in pieces [0 0])
        dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:word word
     :part-of-speech :preposition
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :case (grammatical-case (get-in pieces [0 3]))
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))}))

(defn parse-pronoun-option-line [pieces]
  {:word (get pieces 0)
   :part-of-speech (part-of-speech (get pieces 1))
   :declension (parse-long (get pieces 2))
   :case (grammatical-case (get pieces 4))
   :number (grammatical-number (get pieces 5))
   :gender (gender (get pieces 6))})

(defn add-pronoun-pieces [pieces]
  (let [sectioned-word (get-in pieces [0 0])
        [stem ending] (clojure.string/split sectioned-word #"\.")
        dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:options (mapv parse-pronoun-option-line (drop-last 2 pieces))
     :part-of-speech :pronoun
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))}))

(defn parse-verb-option-line [pieces]
  (let [sectioned-word (get pieces 0)
        [stem ending] (clojure.string/split sectioned-word #"\.")]
    {:sectioned-word sectioned-word
     :stem stem
     :ending ending
     :part-of-speech :verb
     :conjugation (parse-long (get pieces 2))
     ;; :variant (parse-long (get pieces 3)) ;; not sure this means anything grammatical
     :tense (tense (get pieces 4))
     :voice (voice (get pieces 5))
     :mood (mood (get pieces 6))
     :person (parse-long (get pieces 7))
     :number (grammatical-number (get pieces 8))}))

(defn add-unknown-pieces [pieces]
  (let [word (get-in pieces [0 0])]
    {:word word
     :part-of-speech :unknown
     }))

(defn add-verb-pieces [pieces]
  (let [dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:options (mapv parse-verb-option-line (drop-last 2 pieces))
     :sectioned-word (get-in pieces [0 0])
     :part-of-speech (part-of-speech (get-in pieces [0 1]))
     :conjugation (parse-long (get-in pieces [0 2]))
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))
     }))

(def parse-by-part-of-speech
  {:adjective add-adjective-pieces
   :adverb add-adverb-pieces
   :conjunction add-conjunction-pieces
   :noun add-noun-pieces
   :preposition add-participle-pieces
   :pronoun add-pronoun-pieces
   :unknown add-unknown-pieces
   :verb add-verb-pieces})

(defn parse-single-word-output [paragraph]
  (let [lines (clojure.string/split-lines paragraph)
        pieces (->> lines
                    (map #(clojure.string/split % #" +"))
                    (remove empty?)
                    vec)
        part-of-speech (part-of-speech (get-in pieces [0 1]))]
    (try
      ((parse-by-part-of-speech part-of-speech) pieces)
      (catch Exception ex
        (println "Hit exception parsing: " part-of-speech paragraph)
        (println ex)))))

(defn is-parsing-options-line? [line]
  (boolean (re-find #"     " line)))

(defn is-parsing-dictionary-entry-line? [line]
  (boolean (re-find #"\[\w{5}\]" line)))

(defn split-paragraphs
  ([paragraphs]
   (split-paragraphs paragraphs []))
  ([paragraphs already-split-paragraphs]
   (if (empty? paragraphs)
     already-split-paragraphs
     (let [lines (remove #(= "*" %) (clojure.string/split-lines paragraphs))
           first-paragraph-options (take-while is-parsing-options-line? lines)
           lines (nthrest lines (count first-paragraph-options))
           dictionary-entry-lines (take-while is-parsing-dictionary-entry-line? lines)
           lines (nthrest lines (count dictionary-entry-lines))
           dictionary-entry-line (first dictionary-entry-lines) ;; TODO decide what to do with multiple dictionary entry lines on one entry. Right now we just pick the first. Example: edere
           definition-lines (take-while #(and (not (is-parsing-options-line? %))
                                              (not (is-parsing-dictionary-entry-line? %))) lines)
           lines (nthrest lines (count definition-lines))
           definition-line (clojure.string/join " " definition-lines)
           first-paragraph (clojure.string/join "\n" (concat first-paragraph-options
                                                             [dictionary-entry-line]
                                                             [definition-line]))]
       (split-paragraphs (clojure.string/join "\n" lines)
                         (concat already-split-paragraphs [first-paragraph]))))))

(defn parse-paragraphs [paragraphs]
  (mapv parse-single-word-output (split-paragraphs paragraphs)))

(defn split-sections [sections]
  (clojure.string/split sections #"(\n\n|\*\n)"))

(defn parse-sections
  ([sections]
   (parse-sections sections {:condense-entries? true}))
  ([sections {:keys [condense-entries?]}]
   (let [parsed (mapv parse-paragraphs (split-sections sections))]
     (if condense-entries?
       (mapv first parsed) ;; TODO do by word frequency
       parsed))))

(defn word-frequency [parsed]
  (as-> parsed $
    (map #(or (:dictionary-entry %) (:word %)) $)
    (frequencies $)
    (sort (fn [[k1 v1][k2 v2]] (> v1 v2)) $)))

(defn printed-vocabulary [parsed]
  (as-> parsed $
    (map #(str (or (:dictionary-entry %) (:word %))
               ": "
               (or (:definition %) "UNKNOWN"))
         $)
    (distinct $)
    (sort (fn [word1 word2]
            (compare (clojure.string/lower-case word1)
                     (clojure.string/lower-case word2)))
          $)))

(defn unknown-words [parsed]
  (filter #(= (:part-of-speech %) :unknown) parsed))

(defn remove-macrons [s]
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
      (clojure.string/replace #"Ū" "U")))

(defn remove-troublesome-puncuation [s]
  (-> s
      (clojure.string/replace #"\"" "")
      (clojure.string/replace #"'" "")
      (clojure.string/replace #"“" "") ;; tricky unicode double quotes (Google docs uses these)
      (clojure.string/replace #"”" "") ;; tricky unicode double quotes (Google docs uses these)
      (clojure.string/replace #"\n" " ")
      (clojure.string/replace #"\(" "")
      (clojure.string/replace #"\)" "")
      ))

;; Whitaker's Words must be run as ./bin/words from the project folder,
;; otherwise it says "There is no INFLECTS.SEC file."
(def PATH_TO_WHITAKERS_WORDS_ROOT_FOLDER "../whitakers-words")

(defn -main [& args]
  (let [latin-text (if (and (= 1 (count args))
                            (.exists (io/file (first args))))
                     (slurp (first args))
                     (clojure.string/join " " args))
        args-to-passthrough (-> latin-text remove-macrons remove-troublesome-puncuation)
        _ (println args-to-passthrough)
        result (sh "./bin/words" args-to-passthrough
                   :dir PATH_TO_WHITAKERS_WORDS_ROOT_FOLDER)
        parsed (parse-sections (:out result) {:condense-entries? true})]
    (println "Output from shell command:")
    (println (:out result))
    (pprint parsed)
    (println "\n")
    (pprint (printed-vocabulary parsed))
    (println "\n")
    (pprint (unknown-words parsed))
    (println "\n")
    (pprint (word-frequency parsed))
    (System/exit 0)))
