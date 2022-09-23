# Changelog

## v14.0-1

* Bump MATsim version to 14.0.
* Configured dependabot.

## v13.0-2

* GitHub Actions: Publish image on release, also build image on other branches than main.

## v13.0-1

Initial release of a containerized MATSim 13.0. The dash in the image tag version specifies the version of the image. To pull the latest image, refer to the `main` branch.

* Container calls the main method of the `DockerEntrypoint` class when started.
* Provide input files with config and save output files from the container using volumes.
* Pass additional arguments to MATSim using commands following the run statement.
