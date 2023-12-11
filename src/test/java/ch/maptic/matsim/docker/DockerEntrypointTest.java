package ch.maptic.matsim.docker;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class DockerEntrypointTest {
    /**
     * Check entry points and envars.
     */

    @Test
    public void testDockerEntrypoint() {
        try {
            DockerEntrypoint.main(null);

        } catch (Exception ee) {
            LogManager.getLogger(this.getClass()).fatal("there was an exception: \n" + ee);
            fail();
        }
    }

    @Test
    public void testDockerEntrypointArgs() {
        String[] args = {"config.xml", "--config:controler.lastIteration", "1"};
        try {
            DockerEntrypoint.main(args);

        } catch (Exception ee) {
            LogManager.getLogger(this.getClass()).fatal("there was an exception: \n" + ee);
            fail();
        }
    }
}
