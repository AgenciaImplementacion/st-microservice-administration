# Microservice Administration

Users and Roles Administration Microservice.

## Running Development

```sh
$ mvn spring-boot:run
```

## Configuration

Modify the database connection in the st-microservice-administration/src/main/resources/**application.yml** file

```yml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/sistema-transicion
    username: postgres
    password: 123456
    driver-class-name: org.postgresql.Driver
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQL10Dialect
    hibernate.ddl-auto: create
```

### How to disable eureka client?

Modify the **enabled** property in st-microservice-administration/src/main/resources/**application.yml** file:

```yml
eureka:
  client:
    enabled: false
```

### How to disable config client?

Modify the **enabled** property in st-microservice-administration/src/main/resources/**bootstrap.yml** file:

```yml
spring:
  application:
    name: st-microservice-administration
  cloud:
    config:
      enabled: false
```

## Running Production

### Master Branch

Go to the master branch

```sh
$ git checkout master
```

### Generate jar

```sh
$ mvn clean package -DskipTests
```

### Create Network Docker

```sh
$ docker network create st
```

### Create image from Dockerfile

```sh
$ docker build -t st-microservice-administration:ursus .
```

### Run Container

```sh
$ docker run -P -t --network st -d st-microservice-administration:ursus
```

## License

[Agencia de Implementación - BSF Swissphoto - INCIGE](https://github.com/AgenciaImplementacion/st-microservice-administration/blob/master/LICENSE)