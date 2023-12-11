package ch.maptic.matsim.docker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
