(ns scoreboard-web.main
  (:require-macros [hiccups.core :as h])
  (:require [scoreboard-web.util :as util]
            [domina :as dom]
            [domina.css :as css]
            [domina.events :as event]
            [shoreleave.remote :refer [remote-callback]]))

(defn handle-remote-click [evt]
  (let [current-target (:currentTarget evt)
        action (dom/attr current-target :data-action)
        params (dom/attr current-target :data-params)]
  (remote-callback action params)))

(def remote-links
  (dom/nodes (css/sel "a[data-remote]")))

(defn init []
  (util/override-click! remote-links handle-remote-click))
