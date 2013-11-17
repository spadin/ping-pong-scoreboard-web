(ns scoreboard-web.util
  (:require [domina :as dom]
            [domina.events :as event]))

(defn override-click! [nodes action]
  (event/listen! nodes
    :click (fn [evt]
             (event/prevent-default evt)
             (action evt))))
