(ns ^:figwheel-always cudgel.core)

(defmulti add (fn [_ primitive _] primitive))

(defmethod add :text
  [game _ x y text style]
  (-> game .-add (.text x y text style)))
