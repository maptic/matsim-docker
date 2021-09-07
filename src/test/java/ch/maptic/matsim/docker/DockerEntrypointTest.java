package ch.maptic.matsim.docker;

import org.junit.Assert;
import org.junit.Test;
import org.apache.log4j.Logger;

/**
 * Unit test for DockerEntrypoint.
 */
public class DockerEntrypointTest {
    /**
     * Check entry points and envars.
     */

    @Test
    public void testDockerEntrypoint() {
        try {
            DockerEntrypoint.main(null);

        } catch (Exception ee) {
            Logger.getLogger(this.getClass()).fatal("there was an exception: \n" + ee);
            Assert.fail();
        }
    }

    @Test
    public void testDockerEntrypointArgs() {
        String[] args = { "config.xml", "--config:controler.lastIteration", "1" };
        try {
            DockerEntrypoint.main(args);

        } catch (Exception ee) {
            Logger.getLogger(this.getClass()).fatal("there was an exception: \n" + ee);
            Assert.fail();
        }
    }
}
