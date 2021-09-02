package ch.maptic.matsim.docker;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy.OverwriteFileSetting;
import org.matsim.core.scenario.ScenarioUtils;

public class DockerEntrypoint {

    public static void main(String[] args) {

        Config config;

        // Read config
        if (args == null || args.length == 0 || args[0] == null) {
            config = ConfigUtils.loadConfig("test/input/config.xml");
        } else {
            config = ConfigUtils.loadConfig(args);
        }

        // Overwrite output directory
        config.controler().setOverwriteFileSetting(OverwriteFileSetting.deleteDirectoryIfExists);

        Scenario scenario = ScenarioUtils.loadScenario(config);

        Controler controler = new Controler(scenario);

        controler.run();
    }

}