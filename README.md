# RestAPIApp  [![CircleCI](https://circleci.com/gh/meetpatel58/RestAPIApp.svg?style=svg)](https://app.circleci.com/pipelines/github/meetpatel58/RestAPIApp)

-------------------------------------------------------

This is a Spring MVC RestAPI application that supports GET, POST, PUT, PATCH, DELETE methods. It uses Spring Data JPA 
and H2 in-memory database. MapStruct is used to map entitiy and DTO objects models. 

#### Docker Support :

Application can also be run on a docker container, have the working directory as RestAPIApp\Dockerfile and type
the following commands:

```
docker build -t spring-restapiapp .
```
```
docker run -d -p 8080:8080 spring-restapiapp
```

then use the following URI to perform tasks:

```
http://localhost:8080/api/v1/catagories
```


 