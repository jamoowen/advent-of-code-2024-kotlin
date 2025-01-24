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

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}