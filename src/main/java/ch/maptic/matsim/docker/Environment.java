package ch.maptic.matsim.docker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Environment {
    public static final String MATSIM_INPUT_VAR = "MATSIM_INPUT";
    public static final String MATSIM_OUTPUT_VAR = "MATSIM_OUTPUT";
    public static final String MATSIM_VERSION_VAR = "MATSIM_VERSION";
    private static final Logger logger = LogManager.getLogger(Environment.class);

    private Environment() {
    }

    public static String getMatsimInputPath() {
        return getEnvVar(MATSIM_INPUT_VAR);
    }

    public static String getMatsimOutputPath() {
        return getEnvVar(MATSIM_OUTPUT_VAR);
    }

    public static String getMatsimVersion() {
        return getEnvVar(MATSIM_VERSION_VAR);
    }

    private static String getEnvVar(String name) {
        String value = System.getenv(name);
        logger.debug("Getting environment variable {}: {}.", name, value);
        return value;
    }
}
