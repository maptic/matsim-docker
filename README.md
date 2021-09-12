# MATSim Docker image

[![Docker Publish](https://github.com/maptic/matsim-docker/actions/workflows/docker-publish.yml/badge.svg)](https://github.com/maptic/matsim-docker/actions/workflows/docker-publish.yml)
[![Java CI with Maven](https://github.com/maptic/matsim-docker/actions/workflows/maven-ci.yml/badge.svg)](https://github.com/maptic/matsim-docker/actions/workflows/maven-ci.yml)
[![Docker Image CI](https://github.com/maptic/matsim-docker/actions/workflows/docker-ci.yml/badge.svg)](https://github.com/maptic/matsim-docker/actions/workflows/docker-ci.yml)

A docker image of the MATSim open-source framework:

* Container calls the main method of the `DockerEntrypoint` class when started.
* Provide input files with `config.xml` and save output files from the container using volumes.
* Pass additional arguments to MATSim using commands that are following the run statement.

## Getting started

Run MATSim inside a container:

```sh
docker run \
    -v <host/path/to/input>:/opt/matsim/data/input:ro \
    -v <host/path/to/output>:/opt/matsim/data/output \
    maptic/matsim:main <optional MATSIM-ARGS>
```

To pull the latest image, refer to the `main` branch.

## Local build and development

Set the input and output path in the `docker-compose.yml` file, then run:

```sh
docker-compose build
docker-compose up
```

## References

* [DockerHub](https://hub.docker.com/r/maptic/matsim)
* [MATSim Libs](https://github.com/matsim-org/matsim-libs)
* [MATSim Example](https://github.com/matsim-org/matsim-example-project)
