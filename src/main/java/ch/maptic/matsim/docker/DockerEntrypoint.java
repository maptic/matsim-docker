package ch.maptic.matsim.docker;

import org.apache.log4j.Logger;
import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy.OverwriteFileSetting;
import org.matsim.core.scenario.ScenarioUtils;

public class DockerEntrypoint {

    static Logger logger = Logger.getLogger(DockerEntrypoint.class);

    public static void main(String[] args) {

        logger.info("Starting MATSim in Docker container.");

        Config config;

        if (args == null || args.length == 0 || args[0] == null) {
            config = ConfigUtils.loadConfig(Environment.getMatsimInputPath() + "/config.xml");
            config.controler().setOutputDirectory(Environment.getMatsimOutputPath());
            config.controler().setOverwriteFileSetting(OverwriteFileSetting.deleteDirectoryIfExists);
        } else {
            config = ConfigUtils.loadConfig(args);
        }

        Scenario scenario = ScenarioUtils.loadScenario(config);
        Controler controler = new Controler(scenario);
        controler.run();

        logger.info("Exiting container.");
    }

}