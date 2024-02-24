(ns whitakers-clj.core)

(def part-of-speech
  {"N" :noun
   "V" :verb})

(defn parse-single-word-output [paragraph]
  (let [lines (clojure.string/split-lines paragraph)
        pieces (mapv #(clojure.string/split % #" +") lines)]
    {:sectioned-word (get-in pieces [0 0])
     :part-of-speech (part-of-speech (get-in pieces [0 1]))
     :declension (parse-long (get-in pieces [0 2]))}))

