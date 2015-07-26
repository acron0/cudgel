(ns ^:figwheel-always phaser-port.core
    (:require [cudgel.core :as c])
    (:require-macros [cudgel.macros :refer [defgame]]))

(enable-console-print!)

(defgame my-game
  "app"
  640 480
  #js { :create (fn []
                  (c/add my-game :text
                         10 10
                         "phaser from clojurescript :)"
                         #js { :font "20px Arial" :fill "#ff0044" :align "center" }))})

