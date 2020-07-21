# My assignment 

It is a spring boot based application to calculate discount. Its using H2 in-memory Database with JPA.

## Installation

Use jdk1.8 and maven.

update applications.properties for H2 settings or server port settings
You must be able to write on c:\data (on windiws)

data.sql contains scripts to populate data for test.

## Build
```
1- "mvn install" to build project
2- "mvn spring-boot:run" to start server 
3- access http://localhost:8080/discount/0001
```

## Test cases to meet requirements and coverage
```
1- ApplicationTest.java
2- DiscountController.java
```
