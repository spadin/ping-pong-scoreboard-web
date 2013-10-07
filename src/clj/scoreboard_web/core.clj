(ns scoreboard-web.core
  (:require
    [compojure.core :refer [GET defroutes context]]
    [compojure.route :refer [not-found]]
    [scoreboard-web.home.home-controller :refer [home-controller]]
    [joodo.middleware.view-context :refer [wrap-view-context]]
    [joodo.views :refer [render-template]]
    [ring.util.response :refer [redirect]]))

(defroutes scoreboard-web-routes
  (GET "/" [] (redirect "/home"))
  (context "/home" [] home-controller)
  (not-found (render-template "util/not_found" :template-root "scoreboard_web" :layout "util/layout" :ns `scoreboard-web.util.view-helpers)))

(def app-handler
  (->
    scoreboard-web-routes
    (wrap-view-context :template-root "scoreboard_web" :layout "util/layout" :ns `scoreboard-web.util.view-helpers)))

