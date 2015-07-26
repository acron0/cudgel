# cudgel
A ClojureScript API for [Phaser.io](http://phaser.io).

```clojure
(defgame my-game
  "app"
  640 480
  #js { :create (fn []
                  (c/add my-game :text 10 10
                         "phaser from clojurescript :)"
                         #js { :font "20px Arial" :fill "#ff0044" :align "center" }))})
```
![http://i.imgur.com/ffKfAJj.png](http://i.imgur.com/ffKfAJj.png)
## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 

## License

Copyright © 2014 Antony Woods

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
