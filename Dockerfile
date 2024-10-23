# Using ubuntu base image
FROM ubuntu:20.04
# install jdk and maven
RUN apt-get update && apt-get install -y openjdk-21-jdk maven && apt-get clean
# set working directory in docker container
WORKDIR /app
# copy contents of this repo to docker container
COPY . .

