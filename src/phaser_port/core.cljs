(ns ^:figwheel-always phaser-port.core
    (:require [cudgel.core :as c :refer-macros [defgame]]))

(enable-console-print!)

(defgame game
  "app"
  800 600
  #js {
       :preload (fn []
                  (c/load game :image
                             :sprites/einstein
                             "img/ra_einstein.png"))
       :create (fn []
                  (c/add game :sprite
                            20 20
                            :sprites/einstein)

                  (c/add game :text
                         10 10
                         "phaser.io from clojurescript :)"
                         #js {
                              :font "20px Arial"
                              :fill "#ff0044"
                              :align "center" }))})
