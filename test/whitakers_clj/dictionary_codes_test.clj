(ns whitakers-clj.dictionary-codes-test
  (:require [clojure.test :refer :all]
            [whitakers-clj.dictionary-codes :refer :all]))

(deftest parse-dictionary-code-test
  (testing "Dictionary entries"
    (let [out (parse-dictionary-code "[XAXBO]" false)]
      (is (= (:age out) nil))
      (is (= (:area out) "Agriculture, Flora, Fauna, Land, Equipment, Rural"))
      (is (= (:geo out) nil))
      (is (= (:freq-code out) :B))
      (is (= (:freq-text out) "In top 10 percent"))
      (is (= (:source out) "Oxford Latin Dictionary, 1982 (OLD)"))))
  (testing "Inflections"
    ;; TODO
    ))
