#!/bin/bash
imageName=springboot-docker-compose-mysql-app:latest
containerName=springboot-docker-compose-mysql-app

docker build -t $imageName -f Dockerfile  .

echo Delete old container...
docker rm -f $containerName

echo Run new container...
docker run -d -p 8084:8084 --name $containerName $imageName