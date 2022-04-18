#set( $dollar = '$' )
#set( $pound = '#' )
#set( $escape = '\' )
${pound} Prerequisites

- JDK 8
- [Apache Maven](https://maven.apache.org/download.cgi) 3.5

${pound}${pound} Project Lombok
This project uses Project [Lombok](https://projectlombok.org/) https://projectlombok.org/ to reduce bloated class property accessors

To benefit in your IDE the Lombok project 

${pound}${pound}${pound} Eclipse install

https://projectlombok.org/setup/eclipse

${pound}${pound}${pound} IntelliJ install

IDEA https://projectlombok.org/setup/intellij

${pound} Build

${pound}${pound} Docker

Prerequisites: [Docker](https://docs.docker.com/install/${pound}supported-platforms) must be installed

```bash
docker run -it --rm -v "${dollar}(pwd)":/usr/src/mymaven -w /usr/src/mymaven diside/spring-mvc-start-archetype-docker:5.1.11 mvn clean package
```

${pound}${pound} locally

Prerequisites: Java and [Apache Maven](https://maven.apache.org/download.cgi) must be installed.

```bash
mvn clean package -Ph2
```
with default dev profile activated and H2 type DB

${pound} Unit Test

${pound}${pound} locally

Prerequisites: Java and [Apache Maven](https://maven.apache.org/download.cgi) must be installed.

```bash
mvn clean test
```

${pound} Run 

${pound}${pound} Web app server

Drop the war built in any Web application container

Example

${pound}${pound}${pound} Tomcat 9 https://tomcat.apache.org/download-90.cgi 

  copy war in `webapps` directory and start 

```bash
cd apache-tomcat-9.0.14
bin/startup.sh && tail -n80 -f logs/catalina.out
```
${pound}${pound} Docker container

${pound}${pound}${pound} Spotify docker builder

```bash
mvn clean install -Pdocker,dev,h2
docker run -it --rm -p 8080:8080 diside/webapp:latest
```
browse to http://localhost:8080/${artifactId}/

Change environment profile "dev", database type profile "h2" as required and eventually "diside/webapp:1.0.0-dev" if default values were changed

${pound}${pound}${pound} JIB

It uses Google [jib-maven-plugin](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin${pound}war-projects) which does not require to have docker installed on the build machine


```bash
mvn install -Pjib
```
or with a maven container 

```bash
docker run -it --rm -v "${dollar}(pwd)":/usr/src/mymaven -v /var/run/docker.sock:/var/run/docker.sock -w /usr/src/mymaven diside/spring-mvc-start-archetype-docker:latest sh -c "mvn install -Pjib"
```


${pound}${pound} Security and Code Quality

Following command search for vulnerabilities with OWASP plugin

```bash
 mvn verify -Pdoc
```

${pound}${pound}${pound} Code analysis

```bash
 mvn pmd:check spotbugs:check
```

${pound}${pound}${pound} License

Run following command to set or update license format in code source files.

```bash
 mvn license:format
```

${pound}${pound} Steps to migrate SOAP services

Following are the steps to migrate SOAP services from SMH monolithic application to a miniservice created with this archetype


1.  search for obtenirListeDemandesCarteResume in a corresponding WSDL (ie ChercherDemandeCarteTomEjbSImpl.wsdl)
2.  include in project smh-ws-bindings in the pom.xml plugin **cxf-codegen-plugin**  if it is not already included `<include>smtom/ObtenirDossierSmTomEjbSImpl.wsdl</include>`
3. regenerate bindings if necessary
4. create class ChercherDemandeCarteTomWSEndpoint with interface ChercherDemandeCarteTomWS  `ChercherDemandeCarteTomWS` is taken from WSDL
5. create new bean in `WebServicesConfig` 

  ```java
  @Bean
  public Endpoint chercherDemandeCarteTomWS(Bus bus, ChercherDemandeCarteTomWSEndpoint chercherDemandeCarteTomWSEndpoint) {
    EndpointImpl endpoint = new EndpointImpl(bus, chercherDemandeCarteTomWSEndpoint);
    endpoint.publish("chercherDemandeCarteTomWS");
    return endpoint;
  }
  ```
6. search for obtenirListeDemandesCarteResume implementation (found in TraiterDemandeCarteBOmImpl.java)  
7. 
  
  


