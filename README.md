 This is a [Maven](https://maven.apache.org/ "maven") project. I used [Jersey](https://jersey.github.io/ "jersey") to expose REST endpoints, Google [Guice](https://github.com/google/guice/wiki/Injections, "Guice") module for dependency injection.
 
 ------------------
 
 ### Setup
 Maven and Java is required to package and run this service.
 
 Use the following maven command to compile and package the service:
 
 `mvn clean package`
 
 ------------------
 
 ### Running the Project
 I have created a local profile to run the application locally. It will use tomcat server to run the application.
 Run following command to run the application locally:
 
 `mvn -P local tomcat7:run`
 
 ------------------
 
 ### Check Status
 In order to check the status of backend services, please try to access the following link either from browser, Postman or Paw:
 
 `http://localhost:8999/resources/v1/hello`  
 
 ------------
 
 ### Check weather api
 In order to check the Weather API, hit following url from browser. 
 
 `http://localhost:8999/resources/v1/weatherinfo?value=Dallas&unit=metric`
 
 The value field can take either city name or zipcode as query parameter.
 The second parameter is an optional parameter. 
 Kelvin is the default unit if we do not pass unit parameter.
 If we need temperature in Celsius, use `units=metric`.
 If we need temperature in Fahrenheit, use `units=imperial`
 If there is a typo in value for unit parameter, we will get temperatures in Kelvin. 
