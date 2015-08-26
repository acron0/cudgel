(ns ^:figwheel-always cudgel.debug)

;; http://phaser.io/docs/2.4.3/Phaser.Utils.Debug.html#inputInfo
(defn input-info
  [game x y & color] ;; TODO color isn't being used
  (-> game .-debug (.inputInfo x y)))

(defn sprite-info
  [game sprite x y & color]
  (-> game .-debug (.spriteInfo sprite x y)))
