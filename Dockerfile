FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY test/input /home/app/test/input
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim
LABEL maintainer="Merlin Unterfinger <info@munterfinger.ch>"

ARG MATSIM_HOME=/var/lib/matsim
ENV MATSIM_HOME=${MATSIM_HOME} \
    MATSIM_INPUT=${MATSIM_HOME}/data/input \
    MATSIM_OUTPUT=${MATSIM_HOME}/data/output

RUN groupadd -r matsim --gid=999 \
    # && useradd -r -g matsim --uid=999 --home-dir=${MATSIM_HOME} \
    # && chown -R matsim:matsim ${MATSIM_HOME}
    && mkdir -p ${MATSIM_HOME} \
    && mkdir -p ${MATSIM_INPUT} \
    && mkdir -p ${MATSIM_OUTPUT}

VOLUME ${MATSIM_HOME}/data

RUN apt-get update && apt-get install -y \
    libfreetype6 \
    libfontconfig1 \
    && rm -rf /var/lib/apt/lists/*

COPY --from=build /home/app/target/*-jar-with-dependencies.jar /usr/local/lib/matsim.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/matsim.jar"]
