FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim
LABEL maintainer="Merlin Unterfinger <info@munterfinger.ch>"
RUN apt-get update && apt-get install -y \
    libfreetype6 \
    libfontconfig1 \
    && rm -rf /var/lib/apt/lists/*
COPY --from=build /home/app/target/*-jar-with-dependencies.jar /usr/local/lib/matsim.jar
COPY test/input/ test/input
ENTRYPOINT ["java","-jar","/usr/local/lib/matsim.jar"]
