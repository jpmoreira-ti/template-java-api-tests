# Template Java API Test
Template for API tests in Java using [JUnit4](https://junit.org/junit4/) and [RestAssured](https://rest-assured.io/). The API used in this project is from [FakeStoreAPI](https://fakestoreapi.com/docs).

## Prerequisites
- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) must be installed.
- [Apache Maven](https://maven.apache.org/download.cgi) must be installed.

## Installation
To install the project dependencies, run the following command:

```sh
mvn install
```

## Test Execution and Report
To execute the tests, run the following command:

```sh
mvn test
```

## Test Report
The test report is generated at target/custom-reports/surefire.html

## Plugins
The following plugins are used in the project and are configured in the pom.xml file:

- [maven-surefire-plugin](https://maven.apache.org/surefire/maven-surefire-plugin/): Used to run unit tests.</br>
- [maven-surefire-report-plugin](https://maven.apache.org/surefire/maven-surefire-report-plugin/): Used to generate test reports in HTML.