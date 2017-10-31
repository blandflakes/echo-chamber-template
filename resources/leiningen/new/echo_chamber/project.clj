(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: This is an Echo app server that..."
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [echo-chamber "0.3.0"]
                 [echo-chamber-middleware "0.1.6"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-defaults "0.3.1"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [ring/ring-json "0.4.0"]
                 [ring-logger-timbre "0.7.6"]]
  :main {{namespace}}.core)
