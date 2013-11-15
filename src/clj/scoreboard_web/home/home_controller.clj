(ns scoreboard-web.home.home-controller
  (:require [compojure.core :refer (GET defroutes)]
            [joodo.views :refer (render-template)]))

(defroutes home-controller
  (GET "/" [] (render-template "home/index"
                               :template-root "scoreboard_web"
                               :ns `scoreboard-web.util.view-helpers)))
