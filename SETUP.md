# First-time setup

This boilerplate ships without `gradle-wrapper.jar`, `gradlew`, and `gradlew.bat`
because they're binary artifacts you should generate yourself with a local
Gradle install. One-time steps:

1. Install Gradle 8.10+ locally (via SDKMAN, Homebrew, or direct download).
   Just for this bootstrap step — afterwards the wrapper takes over.

2. From the project root, run:

   ```bash
   gradle wrapper --gradle-version 8.10.2
   ```

   This creates `gradlew`, `gradlew.bat`, and `gradle/wrapper/gradle-wrapper.jar`.

3. Verify:

   ```bash
   ./gradlew --version          # should report Gradle 8.10.2, JVM 21
   ./gradlew :core:test         # smoke test should pass
   ./gradlew :desktop:run       # black 800x600 window opens
   ```

4. Delete this file. Commit the wrapper.

After step 3, you never need a system Gradle install again — the wrapper
pins the version for everyone who clones the repo.
