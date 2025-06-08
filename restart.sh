#!/bin/bash

# Stoppa ed elimina container, network e volumi anonimi
docker-compose down -v

docker rmi -f $(docker images -q) || true

docker builder prune -f

# Pulizia e build del jar Spring Boot
./mvnw clean install -DskipTests

# Build nuova immagine Docker
docker build -t tcgcollector:latest .
