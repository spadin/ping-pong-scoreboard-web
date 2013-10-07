(ns scoreboard-web.core
  (:require
    [compojure.core :refer [defroutes GET]]
    [compojure.route :refer [not-found]]
    [joodo.middleware.view-context :refer [wrap-view-context]]
    [joodo.views :refer [render-template render-html]]
    [joodo.controllers :refer [controller-router]]))

(defroutes scoreboard-web-routes
  (GET "/" [] (render-template "home/index"))
  (controller-router 'scoreboard-web.controller)
  (not-found (render-template "util/not_found" :template-root "scoreboard_web" :ns `scoreboard-web.util.view-helpers)))

(def app-handler
  (->
    scoreboard-web-routes
    (wrap-view-context :template-root "scoreboard_web" :ns `scoreboard-web.util.view-helpers)))

