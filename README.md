# echo-chamber-template

[![Clojars Project](http://clojars.org/echo-chamber/lein-template/latest-version.svg)](http://clojars.org/echo-chamber/lein-template)

A leiningen template for generating ring echo app servers.


## Usage

    lein new echo-chamber <app name>
    lein run

The server can be tested by POSTing JSON Echo requests to `localhost:8080`

In general, you'll need to edit the `app` namespace to provide actual functionality for your app. For more information on building the app, see [echo-chamber](https://github.com/blandflakes/echo-chamber).

## Testing

Today, you can test your app's behavior in two ways:

1. With an echo device
2. With the service simulator

Read more [here](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/testing-an-alexa-skill).

In the future, I plan to release a simulator that can run in the REPL, exercising an app in isolation from its service pieces, but simulating how Alexa would behave for a given input.

## Publishing
When you're ready to publish, follow the instructions [here](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/publishing-an-alexa-skill).

## Certificates
Amazon requires that your service is secured with a valid certificate. See [this resource](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/registering-and-managing-alexa-skills-in-the-developer-portal#About%20the%20SSL%20Options) for more information.

Many platform-as-service offerings will provide SSL for you. Other setups would involve using a web server like nginx as a reverse SSL proxy. You can use the built-in Jetty to expose this service over SSL like this:

    (defn main-
      []
      (jetty/run-jetty handler {:ssl-port 443
                                :keystore "path to jks"
                                :key-password "keystore password"}))


## Request Validation
Amazon also requires that you (validate incoming requests)[https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/developing-an-alexa-skill-as-a-web-service#Verifying that the Request was Sent by Alexa]. The (echo-chamber-middleware)[https://github.com/blandflakes/echo-chamber-middleware] library provides a bare-bones version of this functionality. There are lines in your `ring.clj` file that are commented out that enable this validation. When turning these on, testing locally or with curl will not be possible (see "Testing" above).

## License

Copyright © 2015 blandflakes

Distributed under the MIT License.
