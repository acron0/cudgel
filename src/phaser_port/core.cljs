(ns ^:figwheel-always phaser-port.core
    (:require [cudgel.core :as c :refer-macros [defgame]]
              [cudgel.tween :as t]
              [cudgel.debug :as dbg]))

(enable-console-print!)

(def images
  {:einstein-img    (c/Image. "img/ra_einstein.png")
   :phaser-logo-img (c/Image. "img/phaser.png")})

(def sprites
  {:einstein (c/Sprite. 20 20 (:einstein-img images))
   :phaser   (c/Sprite. 0 0 (:phaser-logo-img images))})

(def text (c/Text. 10
                   10
                   "phaser.io from clojurescript :)"
                   {:font "30px Arial" :fill "#ff0044" :align "center"}))

(defn preload [game]
  (c/load game images))

(defn create  [game]
  (let [sprite-handles (c/add game sprites)
        text-handle    (c/add game text)]

    ;;
    (c/set-anchor (:phaser sprite-handles) 0.5)

    ;; tween stuff
    (let [t1 (t/tween-from game text-handle {:x 600} 3000)
          t2 (t/tween-to   game text-handle {:x 50}  1000)]
      (t/start (t/chain t1 t2)))))

(defn render [game]
  (dbg/input-info game 32 32))

(defgame example-game
  "app"
  800 600
  {:preload preload
   :create create
   :render render})
