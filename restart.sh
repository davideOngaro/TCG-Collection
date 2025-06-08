#!/bin/bash

# Stoppa ed elimina container, network e volumi anonimi
docker-compose down -v

docker rmi -f $(docker images -q) || true

docker builder prune -f


# Build nuova immagine Docker
docker build -t tcgcollector:latest .
