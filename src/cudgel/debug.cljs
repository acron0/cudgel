(ns ^:figwheel-always cudgel.debug)

;; http://phaser.io/docs/2.4.3/Phaser.Utils.Debug.html#inputInfo
(defn input-info
  [game x y & color]
  (-> game .-debug (.inputInfo x y)))
