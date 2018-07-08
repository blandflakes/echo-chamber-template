# echo-chamber-template

[![Clojars Project](http://clojars.org/echo-chamber/lein-template/latest-version.svg)](http://clojars.org/echo-chamber/lein-template)

A leiningen template for generating ring echo app servers.


## Usage

    lein new echo-chamber <app name>
    lein run

The server can be tested by POSTing JSON Echo requests to `localhost:8080/hello`

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

Many platform-as-service offerings will provide SSL for you. Other setups would involve using a web server like nginx as a reverse SSL proxy.

Currently, there is no support for configuring SSL on the app server.

## Request Validation
Amazon also requires that you [validate incoming requests](https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-a-web-service.html#verifying-that-the-request-was-sent-by-alexa). The server component
vends functionality for those. To turn them on, just include them in the list of "verifiers" when you construct the server, for example:

    :verifiers [(signature/verifier) (timestamp/verifier)

## License

Copyright © 2015-2018 blandflakes

Distributed under the MIT License.
