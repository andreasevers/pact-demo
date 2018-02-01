
# pact-demo

Demonstrates the latest ways to use pact with the JVM for both REST endpoints and events.

It is initially based on [this repository from shavo007](https://github.com/shavo007/pact-demo).

It includes a full end to end demonstration of consumer driven contract testing using pact framework.

* Ability to run Pact Broker locally using docker containers
* Ability to run RabbitMQ broker locally using docker containers
* Run and publish pacts for jvm and js consumers for REST
* Run and publish pacts for two jvm services interacting over a message bus

## Pact Broker & RabbitMQ startup

`docker-compose up --build`

Access at http://localhost:80 (Basic auth is username:shanelee007/password:password123)

## Running pact broker via Kubernetes

Kubernetes is an open-source system for automating deployment, scaling, and management of containerized applications. It groups containers that make up an application into logical units for easy management and discovery.

To run pact broker via k8s check out README and resources [here](https://github.com/andreasevers/pact-demo/blob/master/kubernetes/README.md)

## Running pact broker via Elastic beanstalk

Dockerrun.aws.json file describes how to deploy pact broker container as an Elastic Beanstalk application.

Create eb env and deploy.

* Install CLI
http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/eb-cli3-install.html

* `eb init` Initializes your directory with the EB CLI. Creates the application.

### Resources

* http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/create_deploy_docker-eblocal.html
* http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/applications-sourcebundle.html
* http://www.eq8.eu/blogs/25-common-aws-elastic-beanstalk-docker-issues-and-solutions


### Useful Commands

```
`eb local run`  Runs commands on your local machine.
`eb local open` Open pact broker locally in browser
`eb local status`  Gets environment information and status locally
`eb use Sample-env-1`
`eb deploy `
`eb use Sample-env-1`
```

## Pact broker postgres docker container

https://store.docker.com/community/images/shanelee007/docker-pact-postgres

## Resources
Blog from shavo007:  http://shavo007.github.io/2016/07/19/consumer-driven-contract-testing-using-pact/

Docker compose file: https://gist.github.com/shavo007/6660cd3230188a094b5d7d3e0647d769

![pact broker]( http://shavo007.github.io/content/images/2016/07/Screen-Shot-2016-07-30-at-8-18-09-PM.png)
