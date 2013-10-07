(defproject scoreboard-web "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [joodo "1.2.2"]]
  :profiles {:dev {:dependencies [[speclj "2.7.5"]
                                  [specljs "2.7.4"]]}}
  :plugins [[speclj "2.7.5"]
            [specljs "2.7.4"]
            [joodo/lein-joodo "1.2.0"]
            [lein-cljsbuild "0.3.2"]]
  :cljsbuild ~(let [run-specs ["phantomjs" "bin/specljs_runner.js" "public/javascript/scoreboard-web_dev.js"]]
    {:builds {:dev {:source-paths ["src/cljs" "spec/cljs"]
                    :compiler {:output-to "public/javascript/scoreboard-web_dev.js"
                               :optimizations :whitespace
                               :pretty-print true}
                    :notify-command run-specs}
              :prod {:source-paths ["src/cljs"]
                     :compiler {:output-to "public/javascript/scoreboard-web.js"
                                :optimizations :simple}}}
     :test-commands {"test" run-specs}})
  :source-paths ["src/clj" "src/cljs"]
  :test-paths ["spec/clj"])
