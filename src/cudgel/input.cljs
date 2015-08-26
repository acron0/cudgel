(ns ^:figwheel-always cudgel.input)

(defn x
  [game]
  (.. game -input -x))

(defn y
  [game]
  (.. game -input -y))
