(ns ^:figwheel-always phaser-port.core
    (:require [cudgel.core :as c :refer-macros [defgame]]))

(enable-console-print!)

(def images
  {:einstein-img (c/Image. "img/ra_einstein.png")})

(def sprites
  {:einstein (c/Sprite. 20 20 (:einstein-img images))})

(defn preload [game]
  (c/load game images))
(defn create  [game]
  (c/add game sprites)
  (c/add game (c/Text. 10
                       10
                       "phaser.io from clojurescript :)"
                       {:font "30px Arial" :fill "#ff0044" :align "center"})))

(defgame example-game
  "app"
  800 600
  {:preload preload
   :create create})
