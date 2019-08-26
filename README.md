# Countries Example (with MongoDB)

This is a microservice which uses Spring Data to fetch data from a MongoDB database.

### Getting Started

There is a `.json` file which contains the data that will be in the database. So, first it is needed to load the data into the database.
```sh
$ mongoimport --db countries --file countries.json
```
### Creating the JAR file of the application
The JAR is generated with the next command:

```sh
$ mvn clean package -Dmaven.test.skip=true
```

This will create a JAR file. The name is according to the `pom.xml`

### Executing the generated JAR file
Execute the JAR file with the next command

```sh
$ java  -jar  -Dserver.port=8027 target/countries-demo-0.0.1-SNAPSHOT.jar
```
*The argument `-Dserver.port` specifies in which port the application will run.
It is important to add the value given due to the postman file is written using this port.*

## Microservice testing
A `.json` file is included within the project. This file is a Postman collection, so it needs to be imported in the program. The hostname is *localhost* and the port is the same as the one in the section [Executing the generated JAR file](#Executing-the-generated-JAR-file)
