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

        logger.info(String.format("Starting MATSim %s in Docker container.", "13"));
        String inputPath = Environment.getMatsimInputPath();
        String outputPath = Environment.getMatsimOutputPath();

        if (args == null || args.length == 0 || args[0] == null) {
            args = new String[] { String.format("%s/%s", inputPath, "config.xml") };
        } else {
            args[0] = String.format("%s/%s", inputPath, args[0]);
        }

        logger.info(String.format("Loading config with args: %s", String.join(", ", args)));
        Config config = ConfigUtils.loadConfig(args);
        config.controler().setOutputDirectory(outputPath);
        config.controler().setOverwriteFileSetting(OverwriteFileSetting.deleteDirectoryIfExists);

        Scenario scenario = ScenarioUtils.loadScenario(config);

        Controler controler = new Controler(scenario);
        controler.run();

        logger.info("Exiting container.");
    }

}