(ns ^:figwheel-always phaser-port.core
    (:require [cudgel.core :as c :refer-macros [defgame]]))

(enable-console-print!)

(def images
  {:einstein-img (c/Image. "img/ra_einstein.png")})

(def sprites
  {:einstein (c/Sprite. (:einstein-img images) 20 20)})

(defn preload [game]
  (c/load game images))
(defn create  [game]
  (c/add game sprites))

(defgame example-game
  "app"
  800 600
  {:preload preload
   :create create})
