(ns {{namespace}} .app
  (:require [echo.core :as echo]
    [echo.response :as response]))

(defn hello-world
  [_request]
  (response/respond {:should-end? true
                     :speech      (response/plaintext-speech "Hello world!")
                     :card        (response/simple-card "Hello world" "Request received. Goodbye!")}))

; FIXME: Implement your own logic below!
(def app {
          :requests {echo/launch      hello-world
                     echo/end-session hello-world}
          :intents  {"HelloWorldIntent" hello-world}})

(def app-handler (echo/request-dispatcher app))