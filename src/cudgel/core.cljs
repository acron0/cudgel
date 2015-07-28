(ns ^:figwheel-always cudgel.core)

(defn- to-string-key
  [the-key]
  (apply str (interpose "." ((juxt namespace name) the-key))))

(defmulti add (fn [_ primitive _] primitive))

(defmethod add :text
  [game _ x y text style]
  (-> game .-add (.text x y text style)))

(defmethod add :sprite
  [game _ x y key]
  (-> game .-add (.sprite x y (to-string-key key))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defmulti load (fn [_ primitive _] primitive))

(defmethod load :image
  [game _ key uri]
  (-> game .-load (.image (to-string-key key) uri)))
