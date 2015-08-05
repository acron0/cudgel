(ns ^:figwheel-always cudgel.core)

;;;;;;;;;;;;;;;;
;; PROTOCOLS ;;;
;;;;;;;;;;;;;;;;

(defprotocol ILoadable
  "Type that can be loaded"
  (load-me [this game]))

(defprotocol IAddable
  "Type that can be added to a scene"
  (add-me [this game]))

(defprotocol IIdentifiable
  "Type that can be identified"
  (identify-me [this]))

;;;;;;;;;;;;;;;;
;;;; TYPES ;;;;;
;;;;;;;;;;;;;;;;

;; primitives
(deftype Image [url]
  IIdentifiable
  (identify-me [this]
    (-> url hash str))
  ILoadable
  (load-me [this game]
    (-> game .-load (.image (identify-me this) url))))

(deftype Sprite [x y img]
  IAddable
  (add-me [this game]
    (-> game .-add (.sprite x y (identify-me img)))))

(deftype Text [x y text style]
  IAddable
  (add-me [this game]
    (-> game .-add (.text x y text (clj->js style)))))

;;;;;;;;;;;;;;;;
;; FUNCTIONS ;;;
;;;;;;;;;;;;;;;;

(defn load
  [game candidate]
  (if (map? candidate)
    (doseq [[k v] candidate]
      (load-me v game))
    (load-me candidate game)))

(defn add [game candidate]
  (if (map? candidate)
    (into {} (map (fn[[k v]] (hash-map k (add-me v game))) candidate))
    (add-me candidate game)))
