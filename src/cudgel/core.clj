(ns cudgel.core
  (:require
   [clojure.string :as str]
   [cljs.core]))

(defmacro defgame
  ([sym id w h funcs]
   (let [node (gensym 'node)]
   `(do
      ;; this allows us to avoid 'defonce'
      (let [~node (.getElementById js/document ~id)]
        (while (.-firstChild ~node) (.removeChild ~node (.-firstChild ~node))))
      ;; game defined here
      (def ~sym (js/Phaser.Game. ~w ~h Phaser.AUTO ~id
                                 ;; TODO find a better way...
                                 (cljs.core/js-obj
                                  ~''preload (cljs.core/fn []
                                               (if (:preload ~funcs)
                                                 ((:preload ~funcs) ~sym)))
                                  ~''create (cljs.core/fn []
                                               (if (:create ~funcs)
                                                 ((:create ~funcs) ~sym)))
                                  ~''update (cljs.core/fn []
                                               (if (:update ~funcs)
                                                 ((:update ~funcs) ~sym)))
                                  ~''render (cljs.core/fn []
                                               (if (:render ~funcs)
                                                 ((:render ~funcs) ~sym))))
                                 false false))))))
