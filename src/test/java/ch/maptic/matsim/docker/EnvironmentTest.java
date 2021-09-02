package ch.maptic.matsim.docker;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for DockerEntrypoint.
 */
public class EnvironmentTest {
    /**
     * Check entry points and envars.
     */

    @Test
    public void testEnvironment() {
        Assert.assertEquals("test/input", Environment.getMatsimInputPath());
        Assert.assertEquals("test/output", Environment.getMatsimOutputPath());
    }
}
