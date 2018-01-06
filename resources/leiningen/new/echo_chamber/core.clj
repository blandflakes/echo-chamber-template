(ns {{namespace}} .core
  (:require [{{namespace}} .app :as app]
    [ring.adapter.jetty :as jetty]
    [{{namespace}} .ring :refer [wrap-handler]])
  (:gen-class :main true))

(def handler (wrap-handler app/app-handler))

(defn -main
  []
  (jetty/run-jetty handler {:port 8080}))
