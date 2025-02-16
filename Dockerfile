FROM openjdk:17-jdk-slim as builder

# Définir le répertoire de travail
WORKDIR /app

# Copier l'artefact JAR dans le conteneur
COPY target/wagueJPA-0.0.1-SNAPSHOT.jar /app/products-application.jar

# Exposer le port 8080 pour l'application
EXPOSE 8080

# Définir la commande d'entrée
ENTRYPOINT ["java", "-jar", "/app/products-application.jar"]
