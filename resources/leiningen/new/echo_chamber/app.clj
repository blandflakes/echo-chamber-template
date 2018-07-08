(ns {{namespace}}.app
  (:require
    [echo.core :as echo]
    [echo.match :refer [request-type intent]]
    [echo.response :as response]))

(defn hello-world
  [_request]
  (response/respond (response/say "Hello world!")
                    (response/card "Hello world" "Request received. Goodbye!")))

; FIXME: Implement your own logic below!
(def app (echo/skill
           (request-type "LaunchRequest") hello-world
           (request-type "SessionEndedRequest") hello-world
           (intent "HelloWorldIntent") hello-world))