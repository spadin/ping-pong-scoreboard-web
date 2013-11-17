(ns scoreboard-web.main-spec
  (:require-macros [hiccups.core :as h]
                   [specljs.core :refer [around before context describe it should-contain should-not= should= with]])
  (:require [domina :as dom]
            [domina.css :as css]
            [domina.events :as event]
            [hiccups.runtime :as rt]
            [specljs.core]
            [scoreboard-web.util.view :as util-view]
            [scoreboard-web.main :as main]))

(describe "scoreboard-web.main"
  (context "/init"

    (with remote-link
      (dom/single-node
        (rt/render-html (util-view/create-remote-link "link-text" "link-action" "link-params"))))

    (before (dom/append! (css/sel "body") @remote-link))

    (it "adds a click handler to anchor tags with data-remote attribute"
      (should= "link-text"
               (dom/text (dom/single-node (css/sel "a[data-remote]")))))))
