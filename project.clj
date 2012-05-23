(defproject lolg "0.0.1"
  :description "Nice and easy logging for ClojureScript."
  :plugins [[lein-cljsbuild "0.1.10"]]
  :cljsbuild {:builds [{:source-path "src"
                        :compiler {:output-to "out/lolg.js"
                                   :output-dir "out"
                                   :optimizations :whitespace
                                   :pretty-print true}}]})
