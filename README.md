# echo-chamber-template

A leiningen template for generating ring echo app servers.

[![Clojars Project](http://clojars.org/echo-chamber/lein-template/latest-version.svg)](http://clojars.org/echo-chamber/lein-template)

## Usage

    lein new echo-chamber <app name>
    lein run

The server can be tested by POSTing JSON Echo requests to "/echo".

In general, you'll need to edit the `app` namespace to provide actual functionality for your app. For more information on building the app, see [echo-chamber](https://github.com/blandflakes/echo-chamber).

To test with an actual echo, configure the Jetty adapter with a self-signed certificate, and follow the instructions [here](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/testing-an-alexa-skill).

When you're ready to publish, configure the Jetty adapter with a valid certificate, and follow the instructions [here](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/publishing-an-alexa-skill).

## TODO
* Cert discovery? Maybe something I shouldn't provide here. OpenShift will perform HTTPS and forward the traffic to port 8080. Many nginx setups do similarly. Possibly just document setting up certs in Jetty.
* Middleware for request verification
* Document testing strategies (service tester, tuning fork)
* README, test directories, etc in template

## License

Copyright © 2015 blandflakes

Distributed under the MIT License.
