(ns scoreboard-web.util.view)

(defn create-remote-link [text action params]
  [:a {:data-remote true
       :data-action action
       :data-params params
       :href "#"}
   text])
