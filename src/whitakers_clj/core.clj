(ns whitakers-clj.core
  (:require [whitakers-clj.dictionary-codes :refer [parse-dictionary-code]]
            [whitakers-clj.dictionary-override :refer [dictionary-override dictionary macronized-words]]
            [clojure.java.shell :refer [sh]]
            [clojure.java.io :as io])
  (:use clojure.pprint)
  (:gen-class))

(def parts-of-speech-not-yet-implemented
  {"PACK" :propack?
   "SUPINE" :supine
   ;; TODO also need to handle deponent verbs better
   })

(def part-of-speech
  {"ADJ" :adjective
   "ADV" :adverb
   "CONJ" :conjunction
   "INTERJ" :interjection
   "N" :noun
   "NUM"  :numeral
   "VPAR" :participle
   "PREP" :preposition
   "PRON" :pronoun
   "SUFFIX" :suffix
   "TACKON" :tackon
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

(def numeral-type
  {"CARD" :cardinal
   "ORD" :ordinal})

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

(defn add-interjection-pieces [pieces]
  (let [word (get-in pieces [0 0])
        dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:word word
     :part-of-speech :interjection
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))}))

(defn parse-noun-option-line [pieces]
  (let [sectioned-word (get pieces 0)
        [stem ending] (clojure.string/split sectioned-word #"\.")]
    {:sectioned-word sectioned-word
     :stem stem
     :ending ending
     :part-of-speech :noun
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

(defn parse-numeral-option-line [pieces]
  (let [sectioned-word (get pieces 0)
        [stem ending] (clojure.string/split sectioned-word #"\.")]
    {:sectioned-word sectioned-word
     :stem stem
     :ending ending
     :part-of-speech :numeral
     :declension (parse-long (get pieces 2))
     :case (grammatical-case (get pieces 4))
     :number (grammatical-number (get pieces 5))
     :gender (gender (get pieces 6))
     :numeral-type (numeral-type (get pieces 7))
}))

(defn add-numeral-pieces [pieces]
  (let [dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:options (mapv parse-numeral-option-line (drop-last 2 pieces))
     :sectioned-word (get-in pieces [0 0])
     :part-of-speech :numeral
     :declension (parse-long (get-in pieces [0 2]))
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))
     }))

(defn parse-participle-option-line [pieces]
  (let [sectioned-word (get pieces 0)
        [stem ending] (clojure.string/split sectioned-word #"\.")]
    {:sectioned-word sectioned-word
     :stem stem
     :ending ending
     :part-of-speech :participle
     :conjugation (parse-long (get pieces 2))
     :case (grammatical-case (get pieces 4))
     :number (grammatical-number (get pieces 5))
     :gender (gender (get pieces 6))
     :tense (tense (get pieces 7))
     :voice (voice (get pieces 8))}))

(defn add-participle-pieces [pieces]
  (let [dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:options (mapv parse-participle-option-line (drop-last 2 pieces))
     :sectioned-word (get-in pieces [0 0])
     :part-of-speech :participle
     :conjugation (parse-long (get-in pieces [0 2]))
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))
     }))

(defn  add-preposition-pieces [pieces]
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
   :part-of-speech :pronoun
   :declension (parse-long (get pieces 2))
   :case (grammatical-case (get pieces 4))
   :number (grammatical-number (get pieces 5))
   :gender (gender (get pieces 6))})

(defn add-pronoun-pieces [pieces]
  (let [sectioned-word (get-in pieces [0 0])
        [stem ending] (clojure.string/split sectioned-word #"\.")
        dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)
        options (mapv parse-pronoun-option-line (drop-last 2 pieces))
        word (:word (first options))
        word (or ({"m.e" "me" "s.e" "se" "qu.o" "quo"
                   "e.ius" "eius" "ill.am" "illam"
                   "ill.is" "illīs" "ill.ius" "illīus" "ill.ud" "illud"
                   "ill.um" "illum" "ist.o" "istō" "s.ibi" "sibi"
                   "n.obis" "nōbīs" "h.aec" "haec" "h.ic" "hic" "ill.arum" "illarum"
                   "m.ei" "meī" "m.ihi" "mihī" "ist.ae" "istae" "qu.a" "qua" "qu.ae" "quae"
                   "qu.id" "quid" "qu.od" "quod" "ill.a" "illa" "ist.um" "istum" "n.os" "nos"
                   "qu.i" "qui" "nostr.um" "nostrum" "t.e" "te" "t.ibi" "tibi"
                   "e.um" "eum" "h.is" "hīs" "qu.am" "quam" "nostr.i" "nostrī"
                   "ill.os" "illōs" "h.oc" "hōc" "ill.orum" "illōrum" "qu.os" "quōs"
                   "v.obis" "vōbīs" "aliqu.id" "aliquid" "ill.o" "illō" "ist.ud" "istud"
                   "e.orum" "eōrum" "h.ac" "hac" "h.as" "has" "qu.as" "quas" "cu.jus" "cuius"
                   "e.is" "eīs" "ist.i" "istī" "qu.is" "quis" "s.ui" "suī" "qu.ibus" "quibus"
                   "aliqu.am" "aliquam" "qu.em" "quem" "cu.i" "cui" "alicu.i" "alicui"
                   "aliqu.od" "aliquod" "i.d" "id"
                   "v.os" "vōs"
                   } word) word)]
    {:options options
     :word word
     :part-of-speech :pronoun
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))}))

(defn add-suffix-pieces [pieces]
  (let [word (get-in pieces [0 0])
        definition-line (last pieces)]
    {:part-of-speech :suffix
     :word word
     :dictionary-entry word
     :definition (clojure.string/join " " definition-line)}))

(defn add-tackon-pieces [pieces]
  (let [word (get-in pieces [0 0])
        dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:word word
     :part-of-speech :tackon
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)}))

(defn add-unknown-pieces [pieces]
  (let [word (get-in pieces [0 0])]
    {:word word
     :part-of-speech :unknown
     }))

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

(defn add-verb-pieces [pieces]
  (let [dictionary-entry-line (last (drop-last pieces))
        definition-line (last pieces)]
    {:options (mapv parse-verb-option-line (drop-last 2 pieces))
     :sectioned-word (get-in pieces [0 0])
     :part-of-speech :verb
     :conjugation (parse-long (get-in pieces [0 2]))
     :dictionary-entry (dictionary-entry-from-pieces dictionary-entry-line)
     :definition (clojure.string/join " " definition-line)
     :dictionary-code (parse-dictionary-code (dictionary-code-from-pieces dictionary-entry-line))
     }))

(def parse-by-part-of-speech
  {:adjective add-adjective-pieces
   :adverb add-adverb-pieces
   :conjunction add-conjunction-pieces
   :interjection add-interjection-pieces
   :noun add-noun-pieces
   :numeral add-numeral-pieces
   :participle add-participle-pieces
   :preposition add-preposition-pieces
   :pronoun add-pronoun-pieces
   :suffix add-suffix-pieces
   :tackon add-tackon-pieces
   :unknown add-unknown-pieces
   :verb add-verb-pieces})

(defn part-of-speech-from-pieces [pieces]
  (or (part-of-speech (get-in pieces [0 1])) ;; most entries have an option line with this
      (let [first-line (get pieces 0)
            penultimate (->> first-line
                               drop-last
                               (remove empty?)
                               last)]
        (part-of-speech penultimate)) ;; some, like beatus, don't, so grab the penultimate piece
      (first (remove nil? (map part-of-speech (get pieces 0))))
      ;; (let [first-line (get pieces 0)]
      ;;   (part-of-speech (get first-line (- (count first-line) 4))))
      ;; some like ire (see the iris entry) have it third from the end
      ))

(defn parse-single-word-output [paragraph]
  (let [lines (clojure.string/split-lines paragraph)
        pieces (->> lines
                    (map #(clojure.string/split % #" +"))
                    (remove empty?)
                    vec)
        part-of-speech (part-of-speech-from-pieces pieces)]
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
           lines (remove #(re-matches #"Syncopated.*" %) lines)
           lines (remove #(re-matches #"Syncope.*" %) lines)
           lines (remove #(re-matches #"Word mod.*" %) lines)
           lines (remove #(re-matches #"An internal.*" %) lines)
           lines (remove #(re-matches #"Two words.*" %) lines)
           lines (remove #(re-matches #"May be.*" %) lines)
           lines (map clojure.string/trim lines)
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

(defn get-most-frequent [entries]
  (first (sort (fn [a b]
                 (compare (str (or (get-in a [:dictionary-code :freq-code]) :Z))
                          (str (or (get-in b [:dictionary-code :freq-code]) :Z))))
               entries)))

(defn parse-sections
  ([sections]
   (parse-sections sections {:condense-entries? true
                             :condensation-method :most-frequent}))
  ([sections {:keys [condense-entries? condensation-method]}]
   (let [parsed (mapv parse-paragraphs (split-sections sections))]
     (if condense-entries?
       (case
           :first (mapv first parsed)
           :most-frequent (mapv get-most-frequent parsed)) ;; TODO do by word frequency
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

(defn pretty-person [person]
  (str
   ({1 "1st"
     "1" "1st"
     2 "2nd"
     "2" "2nd"
     3 "3rd"
     "3" "3rd"} person)
   " person"))

(defn append-character-if-needed [s c]
  (if (= c (last s))
    s
    (str s c)))

(defn parsed-word->word [parsed-word]
  ;; TODO this should really be handled already by parsed-word...
  (let [selected-opt (first (:options parsed-word))
        sectioned-word (:sectioned-word selected-opt)
        un-sectioned-word (if sectioned-word
                            (clojure.string/replace sectioned-word #"\." "")
                            (or (:word parsed-word) (:dictionary-entry parsed-word)))
        word (or (macronized-words un-sectioned-word)
                 un-sectioned-word)
        word (or ({"ess.e" "esse" "sc.is" "scīs" "laud.ate" "laudāte"
                   "fin.itis" "fīnītīs" "consumm.atis" "cōnsummātīs"
                   "custod.ite" "custōdīte" "occurr.it" "occurrit"
                   "gravit.atis" "gravitātis" "pleb.em" "plēbem"
                   "sanctific.ate" "sanctificāte" "dux.erunt" "dūxērunt" "lav.atis" "lavātis"
                   "dux.imus" "dūximus" "gravit.ate" "gravitāte"
                   } word) word)]
    word))

(defn conjugated-definition [parsed-word]
  (let [selected-opt (first (:options parsed-word))
        word (parsed-word->word parsed-word)
        definition (or (dictionary word) (:definition parsed-word))
        definition (append-character-if-needed definition \;)
        dict-entry (or (macronized-words (:dictionary-entry parsed-word))
                       (:dictionary-entry parsed-word))]
    (if (dictionary-override word)
      (str word ": " (dictionary-override word))
      (case (or (:part-of-speech selected-opt) (:part-of-speech parsed-word))
        :unknown (str "UNKNOWN: " parsed-word)
        :preposition (str word ": " definition "(preposition)")
        :pronoun (str word ": " definition "(pronoun)")
        :verb (str word ": " definition " "
                   (when-let [v (:person selected-opt)]
                     (pretty-person v)) " "
                   (when-let [v (:number selected-opt)]
                     (str (name v) " "))
                   (when-let [v  (:tense selected-opt)]
                     (str (name v) " "))
                   (when (= (:voice selected-opt) :passive)
                     (str (name (:voice selected-opt)) " "))
                   (when (= (:mood selected-opt) :subjunctive)
                     (str (name (:mood selected-opt)) " "))
                   "from " dict-entry)
        :noun (str word ": " definition " "
                   (when-let [v (:number selected-opt)]
                     (str (name v) " "))
                   (when-let [v (:gender selected-opt)]
                     (str (name v) " "))
                   (when-let [v (:case selected-opt)]
                     (str (name v) " "))
                   "from " dict-entry)
        :adjective (str word ": " definition " "
                        (when-let [v (:number selected-opt)]
                          (str (name v) " "))
                        (when-let [v (:gender selected-opt)]
                          (str (name v) " "))
                        (when-let [v (:case selected-opt)]
                          (str (name v) " "))
                        "from " dict-entry)
        :numeral (str word ": " definition " "
                        (when-let [v (:number selected-opt)]
                          (str (name v) " "))
                        (when-let [v (:gender selected-opt)]
                          (str (name v) " "))
                        (when-let [v (:case selected-opt)]
                          (str (name v) " "))
                        "from " dict-entry)
        :participle (str word ": " definition " "
                         (when-let [v (:number selected-opt)]
                           (str (name v) " "))
                         (when-let [v (:gender selected-opt)]
                           (str (name v) " "))
                         (when-let [v (:case selected-opt)]
                           (str (name v) " "))
                         (when-let [v  (:tense selected-opt)]
                           (str (name v) " "))
                         (when (= (:voice selected-opt) :passive)
                           (str (name (:voice selected-opt)) " "))
                         (when (= (:mood selected-opt) :subjunctive)
                           (str (name (:mood selected-opt)) " "))
                         "participle from " dict-entry)
        (str word ": from " dict-entry parsed-word)))))

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
      (clojure.string/replace #"Ū" "U")
      (clojure.string/replace #"ȳ" "y")))

(defn double-complete-vocabulary [parsed]
  (let [lines (distinct (map conjugated-definition parsed))]
    (clojure.string/join "\n" (sort (fn [a b]
                                      (compare (clojure.string/lower-case (remove-macrons a))
                                               (clojure.string/lower-case (remove-macrons b))))
                                    lines))))

(defn unknown-words [parsed]
  (filter #(= (:part-of-speech %) :unknown) parsed))

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

(defn avg-sentence-length [text]
  (/ (count (clojure.string/split text #" "))
     (let [num-periods (count (filter #(= % \.) text))]
       (if (> num-periods 0)
         num-periods
         1))))

(defn words-not-found-in-dictionary [parsed]
  (sort (distinct (remove #(dictionary %) (map parsed-word->word parsed)))))

;; Whitaker's Words must be run as ./bin/words from the project folder,
;; otherwise it says "There is no INFLECTS.SEC file."
(def PATH_TO_WHITAKERS_WORDS_ROOT_FOLDER "../whitakers-words")

(defn -main [& args]
  (let [latin-text (if (and (= 1 (count args))
                            (.exists (io/file (first args))))
                     (slurp (first args))
                     (clojure.string/join " " args))
        args-to-passthrough (-> latin-text remove-macrons remove-troublesome-puncuation)
        number-of-words (count (clojure.string/split args-to-passthrough #" "))
        uuid (random-uuid)
        temp-file-name (str uuid ".txt")
        full-file-name (str PATH_TO_WHITAKERS_WORDS_ROOT_FOLDER "/" temp-file-name)
        _ (spit full-file-name args-to-passthrough)
        ;; _ (println args-to-passthrough)
        result (sh "./bin/words" temp-file-name
                   :dir PATH_TO_WHITAKERS_WORDS_ROOT_FOLDER)
        _ (println (:out result))
        parsed (parse-sections (:out result) {:condense-entries? true})
        freqs (word-frequency parsed)]
    ;; (println "Output from shell command:")
    ;; (pprint parsed)
    (println "\n")
    ;; (pprint (printed-vocabulary parsed))
    (println "Doubly-completed vocab")
    (print (double-complete-vocabulary parsed))
    ;; (println "\n")
    ;; (pprint (unknown-words parsed))
    (println "\n")
    (println (words-not-found-in-dictionary parsed))
    ;; (pprint freqs)
    (println "\n")
    (println (count freqs) "unique words," number-of-words "words total. Unique"
             (str (float (* 100 (/ (count freqs) (if (> number-of-words 0) number-of-words 1)))) "%"))
    (println "Average sentence length:" (float (avg-sentence-length latin-text)) "words.")
    (System/exit 0)))
