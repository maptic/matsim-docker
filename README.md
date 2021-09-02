# MATSim Docker image example

[![Docker Image CI](https://github.com/maptic/matsim-docker/actions/workflows/docker-image.yml/badge.svg)](https://github.com/maptic/matsim-docker/actions/workflows/docker-image.yml)

Example docker image of the MATSim open-source framework.

## How to

Set the input and output path in the `docker-compose.yml` :

```sh
docker-compose build
docker-compose up
```

## To do

* Write test.
* Read and set folder paths from env vars or docker run command.
* Enable versioning and version information.

## References

* [MATSim Libs](https://github.com/matsim-org/matsim-libs)
* [MATSim Example](https://github.com/matsim-org/matsim-example-project)
