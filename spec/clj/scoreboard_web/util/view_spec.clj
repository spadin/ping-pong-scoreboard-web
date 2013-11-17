(ns scoreboard-web.util.view-spec
  (:require [speclj.core :refer :all]
            [scoreboard-web.util.view :as util-view]))

(def ^:dynamic link)
(def ^:dynamic elem)
(def ^:dynamic attrs)
(def ^:dynamic text)

(describe "scoreboard-web.util-spec"
  (with action "action")
  (with params "params")
  (with link-text "text")

  (around [it]
    (binding [link (util-view/create-remote-link @link-text @action @params)]
      (binding [elem  (nth link 0)
                attrs (nth link 1)
                text  (nth link 2)]
        (it))))

  (context "/create-remote-link"
    (it "creates an anchor element"
      (should= :a elem))

    (it "creates an anchor element with data-remote attribute"
      (should-contain :data-remote attrs)
      (should= true (get attrs :data-remote)))

    (it "adds the action as a data-action attribute"
      (should-contain :data-action attrs)
      (should= "action" (get attrs :data-action)))

    (it "adds the action params as a data-params attribute"
      (should-contain :data-params attrs)
      (should= "params" (get attrs :data-params)))

    (it "links to #"
      (should-contain :href attrs)
      (should= "#" (get attrs :href)))

    (it "adds the link text"
      (should= "text" text))))
