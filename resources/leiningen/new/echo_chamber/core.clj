(ns {{namespace}}.core
  (:require [{{namespace}}.app :refer [app]]
    [echo-chamber-server.server :refer [app-server]])
  (:gen-class :main true))

(defn -main
  []
  (let [server (app-server "127.0.0.1" 8080 {:skill-fn app :verifiers [] :route "/hello"})]
    ((:start server))))
