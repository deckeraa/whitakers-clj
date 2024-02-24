(ns whitakers-clj.dictionary-codes
  "Contains definitions for dictionary codes
  See whitakers-words/src/latin_utils/latin_utils-dictionary_package.ads")

(def area
  {
   "A" "Agriculture, Flora, Fauna, Land, Equipment, Rural"
   "B" "Biological, Medical, Body Parts"
   "D" "Drama, Music, Theater, Art, Painting, Sculpture"
   "E" "Ecclesiastic, Biblical, Religious"
   "G" "Grammar, Retoric, Logic, Literature, Schools"
   "L" "Legal, Government, Tax, Financial, Political, Titles"
   "P" "Poetic"
   "S" "Science, Philosophy, Mathematics, Units/Measures"
   "T" "Technical, Architecture, Topography, Surveying"
   "W" "War, Military, Naval, Ships, Armor"
   "Y" "Mythology"
   }
  ;; {"A" "Agriculture"
  ;;  "B" "Biological"
  ;;  "D" "Drama"
  ;;  "E" "Ecclesiastic"
  ;;  "G" "Grammar"
  ;;  "L" "Legal"
  ;;  "P" "Poetic"
  ;;  "S" "Science"
  ;;  "T" "Technical"
  ;;  "W" "War"
  ;;  "Y" "Mythology"}
  )

(def geo
  {"A" "Africa"
   "B" "Britian"
   "C" "China"
   "D" "Scandinavia"
   "E" "Egypt"
   "F" "France, Gaul"
   "G" "Germany"
   "H" "Greece"
   "I" "Italy, Rome"
   "J" "India"
   "K" "Balkans"
   "N" "Netherlands"
   "P" "Persia"
   "Q" "Near East"
   "R" "Russia"
   "S" "Spain, Iberia"
   "U" "Eastern Europe"})

(def source
  {
   "B" "C.H.Beeson, A Primer of Medieval Latin, 1925 (Bee)"
   "C" "Charles Beard, Cassell's Latin Dictionary 1892 (Cas)"
   "D" "J.N.Adams, Latin Sexual Vocabulary, 1982 (Sex)"
   "E" "L.F.Stelten, Dictionary of Eccles. Latin, 1995 (Ecc)"
   "F" "Roy J. Deferrari, Dictionary of St. Thomas Aquinas, 1960 (DeF)"
   "G" "Gildersleeve + Lodge, Latin Grammar 1895 (G+L)"
   "H" "Collatinus Dictionary by Yves Ouvrard"
   "I" "Leverett, F.P., Lexicon of the Latin Language, Boston 1845"
   "J" "Bracton: De Legibus Et Consuetudinibus Angliae"
   "K" "Calepinus Novus, modern Latin, by Guy Licoppe (Cal)"
   "L" "Lewis, C.S., Elementary Latin Dictionary 1891"
   "M" "Latham, Revised Medieval Word List, 1980 (Latham)"
   "N" "Lynn Nelson, Wordlist (Nel)"
   "O" "Oxford Latin Dictionary, 1982 (OLD)"
   "P" "Souter, A Glossary of Later Latin to 600 A.D.,"
   "Q" "Other, cited or unspecified dictionaries"
   "R" "Plater + White, A Grammar of the Vulgate, Oxford 1926 (Plater)"
   "S" "Lewis and Short, A Latin Dictionary, 1879 (L+S)"
   "T" "Found in a translation  --  no dictionary reference"
   "V" "Vademecum in opus Saxonis - Franz Blatt (Saxo)"
   "W" "My personal guess, mostly obvious extrapolation (Whitaker or W)"}
  )

;; See whitakers-words/src/latin_utils/latin_utils-inflections_package.ads
;; (def freq-to-key
;;   {"A" :A "B" :B "C" :C "D" :D "E" :E "F" :F "I" :I "M" :M "N" :N})

(def freq-for-dictionary-entries-helptext
  {"A" "Very frequent, in all Elementry Latin books"
   "B" "In top 10 percent"
   "C" "In top 10,000 words"
   "D" "In top 20,000 words"
   "E" "Uncommon, 2 or 3 citations"
   "F" "Very rare, having only single citation in OLD or L+S"
   "I" "Only citation is inscription"
   "M" "Presently not much used (graffiti)"
   "N" "Appearing (almost) only in Pliny Natural History"})

(def freq-for-inflections-helptext
  {"A" "Very frequent: the most common"
   "B" "Sometimes: a not unusual variant"
   "C" "Uncommon: occasionally seen"
   "D" "Infrequent: recognizable variant, but unlikely"
   "E" "Rare: for a few cases, very unlikely"
   "F" "Very rare: singular examples"
   "I" "Inscription: only citation is inscription"})


;; See whitakers-words/src/words_engine/words_engine-list_package.adb
(def inflection-age
  {"X" "Always  "
    "A" "Archaic "
    "B" "Early   "
    "C" "Classic "
    "D" "Late    "
    "E" "Later   "
    "F" "Medieval"
    "G" "Scholar "
    "H" "Modern  "})

(def dictionary-age
  {"A" "Archaic "
   "B" "Early   "
   "C" "Classic "
   "D" "Late    "
   "E" "Later   "
   "F" "Medieval"
   "G" "NeoLatin"
   "H" "Modern  " })

(defn parse-dictionary-code
  "The Dictionary Codes always contain five letters and are bracketed.
   The letters signify things for AGE, AREA, GEO, FREQ, SOURCE, respectively
   E.g. [XAXBO]"
  ([dict-string]
   (parse-dictionary-code dict-string false))
  ([dict-string inflection?]
   {:age (if inflection?
           (inflection-age (str (get dict-string 1)))
           (dictionary-age (str (get dict-string 1))))
    :area (area (str (get dict-string 2)))
    :geo (geo (str (get dict-string 3)))
    :freq-code (keyword (str (get dict-string 4)))
    :freq-text (if inflection?
                 (freq-for-inflections-helptext (str (get dict-string 4)))
                 (freq-for-dictionary-entries-helptext (str (get dict-string 4))))
    :source (source (str (get dict-string 5)))}))
