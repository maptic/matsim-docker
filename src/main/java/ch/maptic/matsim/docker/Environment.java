package ch.maptic.matsim.docker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Environment {

    private static final Logger logger = LogManager.getLogger(Environment.class);

    private Environment() {
    }

    public static String getMatsimInputPath() {
        return getEnvVar("MATSIM_INPUT");
    }

    public static String getMatsimOutputPath() {
        return getEnvVar("MATSIM_OUTPUT");
    }

    public static String getMatsimVersion() {
        return getEnvVar("MATSIM_VERSION");
    }

    private static String getEnvVar(String name) {
        String value = System.getenv(name);
        logger.debug("Getting environment variable {}: {}.", name, value);
        return value;
    }
}
