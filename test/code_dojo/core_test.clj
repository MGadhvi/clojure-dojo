(ns code-dojo.core-test
  (:require [clojure.test :refer :all]
            [code-dojo.core :refer :all]))

(deftest test-split-time
  (testing "Time does not split correctly"
    (is (= [00 00] (split-time "00:00")))))

(deftest test-human-digital-time
  (is (= [00 00] (human-digital-time 00 00)))
  (is (= [15 -15] (human-digital-time 14 45)))
  )
