(ns {{namespace}}.ring
  (:require 
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.util.response :as ring-response]
            [taoensso.timbre :refer [debug]]))

(defn- logging-handler [handler]
  "Logs the request and response objects."
  (fn [request]
    (debug "Received request:" request)
    (let [response (handler request)]
      (debug "Sending response:" response)
      response)))

(defn wrap-handler [app-handler]
  "Generates a ring handler that parses HTTP requests and sends the parsed JSON body
   to the provided app-handler.
   app-handler should be a handler that takes an echo request map."
  (-> app-handler
      wrap-json-response
      logging-handler
      (wrap-defaults api-defaults)
      wrap-json-body))
