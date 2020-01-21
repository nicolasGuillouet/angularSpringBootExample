# angularSpringBootExample
Simple example with dialogs beetween angular 2 + SpringBoot.

## Install
You for running it, you have to run server side (StringBoot) and client side (Angular).
You well need : 
- Java 8
- Maven
- Node JS

### Server Side :

Open a terminal and run : 
```
cd server
mvn clean package spring-boot:repackage
java -jar target/technical-test-0.0.1-SNAPSHOT.jar
```

Test by opening http://localhost:8080/departements in a browser. 


### Client side :
Open a second  terminal
```
cd client
npm install
ng test
```

If tests are ok, run : 
```
ng serve
```

Open http://localhost:4200/ in a browser.


