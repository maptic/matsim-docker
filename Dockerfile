ARG APP_DIR=/opt/matsim

FROM maven:3.9-eclipse-temurin-21 AS build
ARG APP_DIR
WORKDIR ${APP_DIR}
COPY . ./
RUN apt-get update && apt-get install -y \
    figlet \
    && rm -rf /var/lib/apt/lists/*
RUN mvn -f pom.xml -DskipTests clean package \
    && echo "$(mvn -q help:evaluate -Dexpression=project.version -DforceStdout=true)" > VERSION.txt \
    && figlet -f slant "MATSim $(cat VERSION.txt)" > BANNER.txt \
    && echo "Image build date: $(date --iso-8601=seconds)" >> BANNER.txt

FROM eclipse-temurin
ARG APP_DIR
LABEL maintainer="Merlin Unterfinger <merlin.unterfinger@maptic.ch>"
WORKDIR ${APP_DIR}
COPY docker-entrypoint.sh ./
RUN chmod +x docker-entrypoint.sh
COPY --from=build ${APP_DIR}/*.txt ./resources/
COPY --from=build ${APP_DIR}/matsim-example-project-0.0.1-SNAPSHOT.jar ./matsim.jar
ENV MATSIM_HOME=${APP_DIR} \
    MATSIM_INPUT=${APP_DIR}/data/input \
    MATSIM_OUTPUT=${APP_DIR}/data/output
RUN apt-get update && apt-get install -y \
    libfreetype6 \
    libfontconfig1 \
    && rm -rf /var/lib/apt/lists/* \
    && mkdir -p ${MATSIM_INPUT} \
    && mkdir -p ${MATSIM_OUTPUT}
VOLUME ${APP_DIR}/data
ENTRYPOINT ["./docker-entrypoint.sh", "java", "-cp", "matsim.jar", "org.matsim.run.RunMatsim", "/opt/matsim/data/input/config.xml"]
