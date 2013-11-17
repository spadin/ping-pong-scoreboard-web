(ns scoreboard-web.main-spec
  (:require [speclj.core :refer :all]
            [joodo.spec-helpers.controller :refer :all]
            [scoreboard-web.main :refer :all]))

(describe "scoreboard-web"
  (with-mock-rendering)
  (with-routes app-handler)

  (it "handles root"
    (let [result (do-get "/")]
      (should= 200 (:status result))
      (should= "index" @rendered-template))))

(run-specs)
