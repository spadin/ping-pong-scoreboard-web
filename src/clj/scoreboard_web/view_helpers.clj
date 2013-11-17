(ns scoreboard-web.view-helpers
  "Put helper functions for views in this namespace."
  (:require [hiccup.element :refer :all]
            [hiccup.form :refer :all]
            [hiccup.page :refer :all]
            [scoreboard-web.util.view :as util-view]
            [joodo.env :as env]
            [joodo.middleware.asset-fingerprint :refer [path-with-fingerprint]]
            [joodo.views :refer [render-partial *view-context*]]))
