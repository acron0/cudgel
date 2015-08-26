(ns ^:figwheel-always cudgel.tween
  (:require [cudgel.core :as c :refer [IAddable]]))

;;;;;;;;;;;;;;;;
;; FUNCTIONS ;;;
;;;;;;;;;;;;;;;;
(defn- create-tween
  [game target]
  (-> game .-add (.tween target)))

(defn tween-to
  [game target tween-args time
   & {:keys [ease auto-start delay repeat yoyo]
      :or [ease js/Phaser.Easing.Default
           auto-start false
           delay 0
           repeat 0
           yoyo false]}]
  (let [t (create-tween game target)]
    (.to t (clj->js tween-args) time)
    t))

(defn tween-from
  [game target tween-args time
   & {:keys [ease auto-start delay repeat yoyo]
      :or [ease js/Phaser.Easing.Default
           auto-start false
           delay 0
           repeat 0
           yoyo false]}]
  (let [t (create-tween game target)]
    (.from t (clj->js tween-args) time)
    t))

;;;;;;

(defn chain
  [tween1 tween2]
  (.chain tween1 tween2))

(defn start
  [tween]
  (.start tween))
