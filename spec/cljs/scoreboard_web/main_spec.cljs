(ns scoreboard-web.main-spec
  (:require-macros [hiccups.core :as h]
                   [specljs.core :refer [around before context describe it should-contain should-not= should= with]])
  (:require [domina :as dom]
            [domina.css :as css]
            [domina.events :as event]
            [hiccups.runtime :as rt]
            [specljs.core]
            [scoreboard-web.util.view :as util-view]
            [scoreboard-web.main :as main]
            [shoreleave.remote :refer [remote-callback]]))

(describe "scoreboard-web.main"
  (context "/init"

    (with remote-link
      (dom/single-node
        (rt/render-html (util-view/create-remote-link "link-text" "link-action" "link-params"))))

    (before (dom/append! (css/sel "body") @remote-link))

    (it "calls remote-callback with action when link is clicked"
      (let [remote-callback-args (atom [])]
        (with-redefs [remote-callback (fn [& args] (reset! remote-callback-args args))]
          (main/init)
          (event/dispatch! @remote-link :click {})

          (should= "link-action" (nth @remote-callback-args 0))
          (should= "link-params" (nth @remote-callback-args 1)))))))
