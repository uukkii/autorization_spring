## Домашнее задание к занятию 7.5: Docker: основы работы

### Задача Dockerfile

**v. 1.0**

Задание реализовано:

- Проведена сборка проекта. В результате в `/target/` появился файл `autorization_spring-0.0.1-SNAPSHOT.jar`.
- Написан файл `Dockerfile`: 
```
FROM openjdk:17-oracle
VOLUME /tmp
EXPOSE 8080
ADD /target/autorization_spring-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```
- Написан файл `docker-compose.yml`:
```
version: "3.7"

services:
  app:
    build: ./
    ports:
      - "8080:8080"
```

