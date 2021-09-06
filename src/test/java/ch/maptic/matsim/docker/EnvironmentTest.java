package ch.maptic.matsim.docker;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for Environment.
 */
public class EnvironmentTest {
    /**
     * Check envars.
     */

    @Test
    public void testEnvironment() {
        Assert.assertEquals("test/input", Environment.getMatsimInputPath());
        Assert.assertEquals("test/output", Environment.getMatsimOutputPath());
    }
}
