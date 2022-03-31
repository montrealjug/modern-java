# modern-java Project

Some UTF-8 String: ❤️🍟

## Java 18 update

### Start the new included JWebserver!

To serve the static files in the current folder:
```
> jwebserver
Binding to loopback by default. For all interfaces use "-b 0.0.0.0" or "-b ::".
Serving /Users/anthony/workspaces/modern-java and subdirectories on 127.0.0.1 port 8000
URL http://127.0.0.1:8000/
127.0.0.1 - - [30/Mar./2022:22:54:27 -0400] "GET / HTTP/1.1" 200 -
127.0.0.1 - - [30/Mar./2022:22:54:27 -0400] "GET /favicon.ico HTTP/1.1" 404 -
127.0.0.1 - - [30/Mar./2022:22:54:30 -0400] "GET /LICENSE HTTP/1.1" 200 -
```

You can choose another port (9999), providing the `-b 9999` option for example.


## Java 17 new features

This project demonstrates what Java 17 brings over Java 11 in terms of language new features.

Including:

* String Class New Methods ✔️
* Records: immutability makes it easier to reason about; nice toString included ! ✔️
* Text blocks; including variable interpolation ✔️
* NullPointerException with insightful explanations ✔️
* sealed interfaces: list using the permits keyword what are all the implementations available for a given interface: the compiler will be able in switch expressions for example to infer all the different options on a type.
* instanceof with pattern match:


    if (robot instanceof Vacuum v){v.suck()}


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/modern-java-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
