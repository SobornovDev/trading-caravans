# Trading Caravans

A medieval trade-guild simulation in Java 21. Built primarily as a learning
project for Java concurrency primitives.

## Status

Iteration 1 — in progress. See `02_architecture_decisions.md` and
`03_roadmap.md` in the project knowledge for scope and design.

## Build & run

```bash
./gradlew :desktop:run     # opens an 800x600 window (currently just black)
./gradlew :core:test       # runs the core test suite
./gradlew build            # full build
```

Requires JDK 21+. The Gradle toolchain will download one if you don't have it.

## Module layout

- `core/` — pure Java domain. World, Village, Market, Caravan, tick loop.
  No LibGDX dependencies. JUnit 5 tests live here.
- `desktop/` — LibGDX rendering and the desktop entry point. Reads from
  `core`, never the other way around.

This split is deliberate: concurrency-heavy simulation logic stays in `core`
so it can be tested (and later benchmarked with JMH) without spinning up a
graphical runtime.
