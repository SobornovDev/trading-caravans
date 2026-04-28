package com.github.sobornovdev.caravans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Smoke test — exists only to confirm the JUnit 5 wiring works.
 * Delete or replace once real World tests appear.
 */
class WorldSmokeTest {

    @Test
    void worldCanBeInstantiated() {
        assertNotNull(new World());
    }
}
