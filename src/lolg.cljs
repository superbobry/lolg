(ns lolg
  (:require [goog.debug.Console :as console]
            [goog.debug.DivConsole :as div-console]
            [goog.debug.FancyWindow :as fancy]
            [goog.debug.Logger :as logger]))


(def ^{:doc "Maps log level keywords to goog.debug.Logger.Levels."}
  levels {:severe logger/Level.SEVERE
          :warning logger/Level.WARNING
          :info logger/Level.INFO
          :config logger/Level.CONFIG
          :fine logger/Level.FINE
          :finer logger/Level.FINER
          :finest logger/Level.FINEST})

(defn get-logger
  "Given a name, return an existing logger if one exists or create a
  new logger."
  [name]
  (logger/getLogger (str name)))

(def ^{:doc "Global default logger, nothing more."
       :private true}
  *default*
  (get-logger "default"))

(defn set-level
  "Set the logging level of `logger` or `*default*` logger to `level`."
  ([level] (set-level *default* level))
  ([logger level]
     {:pre [(keyword? level) (contains? level levels)]}
     (.setLevel logger (get levels level))))

(defn severe
  "Write the message to the log with a logging level of `severe`."
  ([s] (severe *default* s))
  ([logger s] (.severe logger s)))

(defn warning
  "Write the message to the log with a logging level of `warning`."
  ([s] (warning *default* s))
  ([logger s] (.warning logger s)))

(defn info
  "Write the message to the log with a logging level of `info`."
  ([s] (info *default* s))
  ([logger s] (.info logger s)))

(defn config
  "Write the message to the log with a logging level of `config`."
  ([s] (config *default* s))
  ([logger s] (.config logger s)))

(defn fine
  "Write the message to the log with a logging level of `fine`."
  ([s] (config *default* s))
  ([logger s] (.fine logger s)))

(defn finer
  "Write the message to the log with a logging level of `finer`."
  ([s] (finer *default* s))
  ([logger s] (.finer logger s)))

(defn finest
  "Write the message to the log with a logging level of `finest`."
  ([s] (finest *default* s))
  ([logger s] (.finest logger s)))


(defprotocol ILogViewer
  (start-display [this] "Start displaying log messages in this viewer.")
  (stop-display  [this] "Stop displaying log messages in this viewer."))

(extend-protocol ILogViewer
  goog.debug.Console
  (start-display [this]
    (.setCapturing this true))
  (stop-display [this]
    (.setCapturing this false))

  goog.debug.DivConsole
  (start-display [this]
    (.setCapturing this true))
  (stop-display [this]
    (.setCapturing this false))

  goog.debug.FancyWindow
  (start-display [this]
    (doto this
      (.setEnabled true)
      (.init ())))
  (stop-display [this]
    (.setCapturing this false)))


(defn console-output
  "Returns a log viewer which will direct log messages to the
  browser's `console` window. Use the `start-display` and
  `stop-display` functions to start and stop printing log messages to
  the console."
  []
  (goog.debug.Console.))

(defn div-output
  "Returns a log viewer which will direct log messages to a given
  `element`. Use the `start-display` and `stop-display` functions
  to start and stop printing log messages to the console."
  [element]
  (goog.debug.DivConsole. element))

(defn fancy-output
  "Returns a log viewer which will open a fancy logging window and
  direct log messages to it. Use the `start-display` and
  `stop-display` functions to start and stop printing log messages in
  this window."
  [name]
  (goog.debug.FancyWindow. name))
