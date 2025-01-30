plugins {
    kotlin("jvm") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.arrow-kt:arrow-core:2.0.0")
    implementation("io.arrow-kt:arrow-fx-coroutines:2.0.0")
    testImplementation(kotlin("test")) // Kotlin test library
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0") // JUnit 5

}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "failed", "skipped") // Log passed, failed, and skipped tests
        showStandardStreams = true           // Show standard output (like println) in the console
    }
}

kotlin {
    jvmToolchain(23)
}