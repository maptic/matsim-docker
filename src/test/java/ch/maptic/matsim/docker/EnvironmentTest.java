package ch.maptic.matsim.docker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for Environment.
 */
public class EnvironmentTest {
    /**
     * Check envars.
     */

    @Test
    public void testEnvironment() {
        assertEquals("test/input", Environment.getMatsimInputPath());
        assertEquals("test/output", Environment.getMatsimOutputPath());
    }
}
