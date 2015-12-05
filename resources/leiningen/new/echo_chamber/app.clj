(ns {{namespace}}.app
  (:require [echo.core :as echo]
            [echo.response :as response]))

(defn hello-world
  [session]
  (response/respond session {:should-end? true
                             :speech (response/plaintext-speech "Hello world!")
                             :card (response/simple-card "Hello world" "Request received." "Goodbye!")}))

; FIXME: Implement your own logic below!
(deftype App []
  echo/IEchoApp
  (on-launch [this request session] (hello-world session))
  (on-intent [this request session] (hello-world session))
  (on-end [this request session] (hello-world session)))

(def app-handler (echo/request-dispatcher (App.)))
