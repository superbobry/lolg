(defproject lolg "0.1.0-SNAPSHOT"
  :description "Nice and easy logging for ClojureScript."
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2173"]
                 [org.clojure/google-closure-library "0.0-2029"]]
  :plugins [[lein-cljsbuild "1.0.2"]]
  :cljsbuild {:builds [{:source-paths ["src"],
                        :compiler {:output-to "out/lolg.js"
                                   :output-dir "out"
                                   :optimizations :whitespace
                                   :pretty-print true}}]})
