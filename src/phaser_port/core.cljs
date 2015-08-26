(ns ^:figwheel-always phaser-port.core
    (:require [cudgel.core :as c :refer-macros [defgame]]
              [cudgel.tween :as t]
              [cudgel.debug :as dbg]
              [cudgel.input :as i]))

(enable-console-print!)

(def images
  {:einstein-img    (c/Image. "img/ra_einstein.png")
   :phaser-logo-img (c/Image. "img/phaser.png")})

(def sprites
  {:einstein (c/Sprite. 20 20 (:einstein-img images))
   :phaser   (c/Sprite. 100 100 (:phaser-logo-img images))})

(def text (c/Text. 10
                   10
                   "phaser.io from clojurescript :)"
                   {:font "30px Arial" :fill "#ff0044" :align "center"}))

(def phaser-sprite-handle (atom nil))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn preload [game]
  (c/load game images))

(defn create  [game]
  (let [sprite-handles (c/add game sprites)
        text-handle    (c/add game text)
        phaser-sprite (:phaser sprite-handles)]

    ;;
    (c/set-anchor phaser-sprite 0.5)
    ;;(c/set-scale  phaser-sprite 2)
    (reset! phaser-sprite-handle phaser-sprite)

    ;; tween stuff
    (let [t1 (t/tween-from game text-handle {:x 600} 3000)
          t2 (t/tween-to   game text-handle {:x 50}  1000)]
      (t/start (t/chain t1 t2)))))

(defn render [game]
  ;;
  #_(dbg/input-info game 32 32)
  (dbg/sprite-info game @phaser-sprite-handle 32 32))

(defn update-loop [game]
  (c/set-x @phaser-sprite-handle (i/x game))
  (c/set-y @phaser-sprite-handle (i/y game)))

(defgame example-game
  "app"
  800 600
  {:preload preload
   :create create
   :render render
   :update update-loop})
