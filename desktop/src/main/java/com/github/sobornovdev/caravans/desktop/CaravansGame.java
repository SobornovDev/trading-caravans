package com.github.sobornovdev.caravans.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Minimal LibGDX application. Just clears the screen each frame.
 *
 * <p>This class lives in the {@code desktop} module on purpose:
 * it's the only place where {@code com.badlogic.gdx.*} imports are allowed.
 * Domain logic lives in {@code core} and must remain LibGDX-free so it
 * stays testable without a graphical runtime.
 */
public class CaravansGame extends ApplicationAdapter {

    @Override
    public void create() {
        // Iteration 1: instantiate World here, set up rendering resources.
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Iteration 1: draw villages, roads, caravans here.
        // Remember: this runs on the LibGDX render thread (~60 fps).
        // The tick thread will be a separate ScheduledExecutorService.
    }

    @Override
    public void dispose() {
        // Iteration 1: shut down the tick scheduler cleanly here.
    }
}
