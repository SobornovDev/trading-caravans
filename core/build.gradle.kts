plugins {
    java
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
}

// Note: this module is intentionally LibGDX-free.
// All domain logic (World, Village, Market, Caravan, tick) lives here
// and must be testable without spinning up a LibGDX runtime.
//
// JMH plugin will be added here in iteration 2 when we start measuring
// concurrency primitives. Don't add it yet — premature.
