FROM openjdk:17-jdk-slim as builder

WORKDIR /app

COPY target/wagueJPA-0.0.1-SNAPSHOT.jar /app/products-application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/products-application.jar"]
