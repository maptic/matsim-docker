package ch.maptic.matsim.docker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy.OverwriteFileSetting;
import org.matsim.core.scenario.ScenarioUtils;

public class DockerEntrypoint {

    private static final Logger logger = LogManager.getLogger(DockerEntrypoint.class);

    public static void main(String[] args) {

        String inputPath = Environment.getMatsimInputPath();
        String outputPath = Environment.getMatsimOutputPath();
        String matsimVersion = Environment.getMatsimVersion();

        logger.info("Starting MATSim {} in Docker container.", matsimVersion);
        if (args == null || args.length == 0 || args[0] == null) {
            args = new String[] { String.format("%s/%s", inputPath, "config.xml") };
        } else {
            args[0] = String.format("%s/%s", inputPath, args[0]);
        }

        logger.info("Loading config with args: {}", String.join(", ", args));
        Config config = ConfigUtils.loadConfig(args);
        config.controler().setOutputDirectory(outputPath);
        config.controler().setOverwriteFileSetting(OverwriteFileSetting.deleteDirectoryIfExists);

        Scenario scenario = ScenarioUtils.loadScenario(config);

        Controler controler = new Controler(scenario);
        controler.run();

        logger.info("Exiting container.");
    }

}