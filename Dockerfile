FROM openjdk:17-oracle
VOLUME /tmp
EXPOSE 8080
ADD /target/autorization_spring-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]