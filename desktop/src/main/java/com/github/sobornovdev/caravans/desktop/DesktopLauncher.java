package com.github.sobornovdev.caravans.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

/**
 * Entry point for the desktop build.
 *
 * <p>Run via {@code ./gradlew :desktop:run}.
 */
public final class DesktopLauncher {

    private DesktopLauncher() {
        // utility class
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Trading Caravans");
        config.setWindowedMode(800, 600);
        config.setForegroundFPS(60);
        config.useVsync(true);

        new Lwjgl3Application(new CaravansGame(), config);
    }
}
