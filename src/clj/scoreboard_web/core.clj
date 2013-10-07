(ns scoreboard-web.core
  (:use
    [compojure.core :only (defroutes GET)]
    [compojure.route :only (not-found)]
    [joodo.middleware.view-context :only (wrap-view-context)]
    [joodo.views :only (render-template render-html)]
    [joodo.controllers :only (controller-router)]))

(defroutes scoreboard-web-routes
  (GET "/" [] (render-template "index"))
  (controller-router 'scoreboard-web.controller)
  (not-found (render-template "not_found" :template-root "scoreboard_web/view" :ns `scoreboard-web.view.view-helpers)))

(def app-handler
  (->
    scoreboard-web-routes
    (wrap-view-context :template-root "scoreboard_web/view" :ns `scoreboard-web.view.view-helpers)))

