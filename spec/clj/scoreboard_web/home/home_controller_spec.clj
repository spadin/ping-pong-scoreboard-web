(ns scoreboard-web.home.home-controller-spec
  (:require [speclj.core :refer [describe context it should= run-specs]]
            [joodo.spec-helpers.controller :refer [do-get rendered-template
                                                   rendered-context with-mock-rendering
                                                   with-routes]]
            [scoreboard-web.home.home-controller :refer [home-controller]]))

(describe "home-controller"
  (with-mock-rendering)
  (with-routes home-controller)

  (context "/home"
    (it "renders the home/index template"
      (let [result (do-get "/")]
        (should= 200 (:status result))
        (should= "home/index" @rendered-template)))))


