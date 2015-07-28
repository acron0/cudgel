(ns cudgel.core
  (:require
   [clojure.string :as str]
   [cljs.core])
  (:import
   [cljs.tagged_literals JSValue]))

(defmacro defgame
  ([sym id w h funcs]
   (let [node (gensym 'node)]
   `(do
      ;; this allows us to avoid 'defonce'
      (let [~node (.getElementById js/document ~id)]
        (while (.-firstChild ~node) (.removeChild ~node (.-firstChild ~node))))
      ;; game defined here
      (def ~sym (js/Phaser.Game. ~w ~h Phaser.AUTO ~id ~funcs false false))))))
