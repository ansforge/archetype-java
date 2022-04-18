Spring Framework 5.1 miniservice Maven Archetype
======================================

# Summary

The project is a Maven archetype for Spring SOAP/XML REST/JSON application.

It aims to serve to propose both an API based on REST/JSON and Web Services endpoints SOAP/XML

Web Services endpoints SOAP/XML are served by Apache CXF framework
REST/JSON endpoints are served by Spring Framework MVC with Jackson JSON de/serialization

Notes:
This archetype may not work with prior versions of Spring Framework 5.0.x, or 4.3.x, and Java < 1.8
It uses methods which are not reverse compatible.

When Spring Framework 5.2 will be released, this archetype must be upgraded accordingly.

PR contributions are welcome as long as there is no Spring Boot dependency included.

## Generated project characteristics
* Bill of Material
* Spring MVC web application, with Java config and no Spring Boot
* [Apache CXF](http://cxf.apache.org/docs/overview.html) for the SOAP/XML web services endpoints
* Java Persistence (JPA)
** [Spring Data JPA](https://spring.io/projects/spring-data)
** [Hibernate](http://hibernate.org/orm)
** [HSQLDB](http://hsqldb.org/)
** [H2](http://www.h2database.com/)
** [Postgresql](https://www.postgresql.org/)
* Testing with [JUnit](http://junit.org )/[Mockito](https://github.com/mockito/mockito)
* Docker containerization with [Google Jib maven plugin](https://github.com/GoogleContainerTools/jib)
* Cache memory with [Caffeine](https://github.com/ben-manes/caffeine)
* [Jackson JSON/XML/CSV data-binding functionality](http://github.com/FasterXML/jackson)
* [Problem, implementation of the application/problem+json draft](https://github.com/zalando/problem)
* [Lombok](https://projectlombok.org/) to reduce boilerplate code (cf readme of generated project)
* Unit tests with [JUnit 5 Jupiter](https://junit.org/junit5/) and [Mockito](https://github.com/mockito/mockito)

## TODO
* 

## Prerequisites

- JDK 8 (tested with Java 11)
- [Apache Maven](https://maven.apache.org/download.cgi) 3.6 (tested with 3.6.0)
- Not mandatory [Docker](https://docs.docker.com/install/#supported-platforms) 


# Create a new project with this Maven archetype

Beware: no pom.xml should be in directory where you run following command. For good measure create an empty directory.

## command line

Prerequisites: Java and Maven must be installed.


add to your ~/.m2/settings.xml a new repo in an activated profile

```
<repositories>
  ...
  <repository>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
  ...
<repositories>  
```

and run interactively in a directory without a pom.xml in it

```bash
  mvn archetype:generate \
      -DarchetypeGroupId=fr.ans \
      -DarchetypeArtifactId=archetype-java \
      -DarchetypeVersion=0.0.5
```

or with prior building of this archetype

```bash
mvn install
cd ..
mvn archetype:generate -DarchetypeCatalog=local
```

Indicate the properties of your generated project :

```bash
groupId: fr.ans
artifactId: archetype-java
version: 0.0.1-SNAPSHOT
package: fr.ans
parentArtifactId: bom-ms
parentGroupId: fr.gipcps.bom
parentVersion: 2.0.4
pipelineTemplate: AnsPipelineJdk8Mvn33
 Y: :
 ```
 
Type "N" to enter your own values, and then type "Y" to confirm properties configuration.

Note : Concerning the property piplelineTemplate, only 2 values are allowed depending on your java version and maven version

For JDK 8 & Maven 3.3, Enter "AnsPipelineJdk8Mvn33"

For JDK 11 & Maven 3.6, Enter "AnsPipelineJdk11Mvn36"

## IntelliJ

* Create new project `File > New > Project`
* Click Maven on the left hand side of the new project dialog
* Check `Create from archetype`
* Click the `Add Archetype` button
* Set `Group Id` to `fr.ans`
* Set `Artifact Id` to `archetype-java`
* Set `Version` to `0.0.5`
* Click next and create the project

Note: If you would like to create a project using archetype published in your local repository, skip repository field and make sure it is installed locally (see below).

## Eclipse / Spring Tool Suite

* Create new project `File > New > Maven Project`
* Make sure `Create a simple project` option is not selected
* Click `Next` to navigate to `Select an Archetype` screen
* Make sure `Include snapshot archetypes` is selected
* Click `Add Archetype` button
* Set `Archetype Group Id` to `fr.ans`
* Set `Archetype Artifact Id` to `archetype-java`
* Set `Archetype Version` to `0.0.5`
* Click `OK` so the Archetype is added to the list
* Click `Next` and fill in `Group Id`, `Artifact Id` and `Version` of your new project

Note: Remember to select `Include snapshot archetypes`. 


## Local repository

### Install archetype locally self build

To install the archetype in your local repository execute the following commands:

```bash
  git clone .../archetype-java
  cd archetype-java
  mvn clean install
```
### Create a project from a local repository

Use a directory without a pom.xml in it and then run:

```bash
  mvn archetype:generate \
      -DarchetypeGroupId=fr.ans \
      -DarchetypeArtifactId=archetype-java \
      -DarchetypeVersion=0.0.5
```

Note: The above command will bootstrap a project using the archetype published in your local repository.

# Run the project

## Docker

[Docker](https://docs.docker.com/install/#supported-platforms) must be installed

```bash
  mvn compile jib:buildTar
  docker load --input target/*.tar
  docker run acme:0.0.5-dev
```
## Eclipse IDE

create a new server goto Preferences -> Server -> Runtime Environments

and add the project just created, publish, start the server

## Tomcat plugin (deprecated)
Navigate to newly created project directory (`my-artifactId`) and then run:

```bash
  mvn test tomcat7:run
```

> Note: It is not recommended to run the artifact, Tomcat Maven Plugin Version 2.2 was released on 2013-11-11

### Test in the browser
-------------------

  http://localhost:8080/

Note: No additional services are required in order to start the application.



# Project Configuration 

## Switching to PostgreSQL

Prerequisites:
 PostgreSQL up and running, tablespace, and credentials valid

* Build and run with the correct profile:

```bash
mvn clean package -P-h2,dev,pgsql help:active-profiles
```

## Switching to H2 database

It is default DB activated, to change default reset to `<activeByDefault>false</activeByDefault>` in POM

* Build and run with the correct profile:

```bash
mvn clean package -P dev,h2 help:active-profiles
```

## Switching to HSQL DB

* Build and run with the correct profile:

```bash
mvn clean package -P-h2,dev,hsql help:active-profiles
```

## Switching to MySQL/Maria DB

Prerequisites:
 MySQL up and running, tablespace, and credentials valid
 
* Build and run with the correct profile:

```bash
mvn clean package -P-h2,dev,mysql help:active-profiles
```
