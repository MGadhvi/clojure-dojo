(ns code-dojo.core
  (:gen-class)
  (:require [clojure.string :as str]
            [clojure.pprint :as pp]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn split-time [time]
  (map (fn [x] (Integer/parseInt x))
       (str/split time #":")))

(defn human-digital-time [hour minute]
  (if (< minute 31)
    [hour minute]
    [(inc hour) (- minute 60)]))

(defn print-num [x]
  (pp/cl-format nil "~R" x))

(defn hours [hour]
  (cond
    (= hour 12) "noon"
    (or
     (= hour 0)
     (= hour 24)) "midnight"
    (< hour 12) (str (print-num hour) " am")
    :else (str (print-num (- hour 12)) " pm")))

(defn mins [min]
  (cond
    (= min 30) "half past "
    (= min 15) "quarter past "
    (= min -15) "quarter to "
    (= min 0) ""
    (< min 0) (str (print-num (- min)) " to ")
    :else (str (print-num min) " past ")))

    )
(defn say-time [time]
  (as-> time x
    (split-time x)
    (apply human-digital-time x)
    (apply (fn [h m] (str (mins m) (hours h))) x )
    ))




