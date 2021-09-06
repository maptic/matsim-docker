package ch.maptic.matsim.docker;

import org.apache.log4j.Logger;

public class Environment {

    static Logger logger = Logger.getLogger(Environment.class);

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
        logger.info(String.format("Getting environment variable %s: %s.", name, value));
        return value;
    }
}
