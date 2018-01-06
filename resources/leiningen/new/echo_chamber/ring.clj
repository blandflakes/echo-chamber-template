(ns {{namespace}}.ring
  (:require [echo-chamber-middleware.authentication :refer [wrap-signature-verifier wrap-timestamp-verifier]]
    [environ.core :refer [env]]
    [ring.logger.timbre :as logger.timbre]
    [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
    [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
    [ring.util.response :as ring-response]))

(defn- contact-point
  "Manages the contact point between ring middleware and the echo app router.
   Extracts the echo request from the ring request's body, and wraps the echo
   response in a ring response."
  [handler]
  (fn [request]
    (-> request :body handler ring-response/response)))

(defn- conditional-wrap [handler condition wrapper]
  (if condition
    (wrapper handler)
    handler))

(defn- env-boolean
  "Environ variables are always strings. Function to pull a variable and try to match it to true. Any string that
  isn't 'true' will return false. Is strict - if you have a string that isn't a boolean, it will throw an
  exception. If nothing is set, it will return false."
  [env-variable]
  (if-let [found (env env-variable)]
    (boolean (Boolean/valueOf found))
    false))

(defn wrap-handler
  "Generates a ring handler that parses HTTP requests and sends the parsed JSON body
   to the provided app-handler.
   app-handler should be a handler that takes an echo request map."
  [app-handler]
  (-> app-handler
      contact-point
      (conditional-wrap (env-boolean :verify-timestamp) wrap-timestamp-verifier)
      wrap-json-response
      (wrap-defaults api-defaults)
      wrap-json-body
      (conditional-wrap (env-boolean :verify-certificate) wrap-signature-verifier)
      logger.timbre/wrap-with-logger))
