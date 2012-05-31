lolg
====

A simple logging library, shamelessly ripped off from [ClojureScript One] [1]
source code. Here's a quick example:

```clojure
(defn ^:export start-app []
  (start-display (console-output))
  (info "Application started!")
  (fine {:state [:started :just :now]}))
```

[1]: http://clojurescriptone.com
