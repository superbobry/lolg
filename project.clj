(defproject lolg "0.1.0-SNAPSHOT"
  :description "Nice and easy logging for ClojureScript."
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/google-closure-library "0.0-1376"]]
  :plugins [[lein-cljsbuild "0.2.1"]]
  :cljsbuild {:builds [{:source-path "src"
                        :compiler {:output-to "out/lolg.js"
                                   :output-dir "out"
                                   :optimizations :whitespace
                                   :pretty-print true}}]})
