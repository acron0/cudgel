(ns ^:figwheel-always cudgel.core)

;;;;;;;;;;;;;;;;
;; PROTOCOLS ;;;
;;;;;;;;;;;;;;;;

(defprotocol ILoadable
  "Type that can be loaded"
  (load-me [this game]))
n
(defprotocol IAddable
  "Type that can be added to a scene"
  (add-me [this game]))

(defprotocol IIdentifiable
  "Type that can be identified"
  (identify-me [this]))

;;;;;;;;;;;;;;;;
;;;; TYPES ;;;;;
;;;;;;;;;;;;;;;;

(deftype Image [url]
  IIdentifiable
  (identify-me [this]
    (-> url hash str))
  ILoadable
  (load-me [this game]
    (-> game .-load (.image (identify-me this) url))))

(deftype Sprite [img x y]
  IAddable
  (add-me [this game]
    (-> game .-add (.sprite x y (identify-me img)))))

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
    (doseq [[k v] candidate]
      (add-me v game))
    (add-me candidate game)))
