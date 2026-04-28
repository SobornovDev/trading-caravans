plugins {
    java
    application
}

dependencies {
    implementation(project(":core"))

    implementation(libs.gdx)
    implementation(libs.gdx.backend.lwjgl3)

    // Native bindings for the desktop platform (LWJGL3 across OSes).
    runtimeOnly(variantOf(libs.gdx.platform) { classifier("natives-desktop") })
}

application {
    mainClass.set("com.github.sobornovdev.caravans.desktop.DesktopLauncher")
}

tasks.named<JavaExec>("run") {
    if (org.gradle.internal.os.OperatingSystem.current().isMacOsX) {
        jvmArgs("-XstartOnFirstThread")
    }
}

// Why lwjgl3 backend (and not the legacy lwjgl one):
//   - Modern, actively maintained.
//   - Plays nicer with newer JVMs and HiDPI displays.
//   - Default for new LibGDX projects since ~1.10.
//
// Why the `application` plugin:
//   - Gives us `./gradlew :desktop:run` out of the box.
//   - Handles classpath + main class wiring without manual JavaExec tasks.
