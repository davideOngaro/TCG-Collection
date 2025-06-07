# Usa immagine base Java
FROM eclipse-temurin:21-jdk-alpine

# Aggiunge il JAR compilato all'immagine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Espone la porta
EXPOSE 8080

# Comando di avvio
ENTRYPOINT ["java", "-jar", "/app.jar"]
