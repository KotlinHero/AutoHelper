plugins {
    kotlin("jvm")
}

group = "tech.kotlinhero.autohelper.core"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.poi)
    implementation(libs.bundles.selenium)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}