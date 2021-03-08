# South Africa project

This project uses Quarkus.
It exposes API to validate South Africa phone numbers ( just a really basic implementation )

## Running the application in dev mode

Clone the repo , run to start the application

```shell script
./mvnw compile quarkus:dev
```

Then navigate to [http://localhost:8080/](http://localhost:8080/)

You can find Swagger UI at [http://localhost:8080/q/swagger-ui/](http://localhost:8080/q/swagger-ui/)

## Running test

```shell script
./mvnw test
```


## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.
