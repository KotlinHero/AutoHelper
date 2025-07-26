plugins {
    kotlin("jvm")
}

group = "tech.kotlinhero.autohelper.business"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(libs.selenium.api)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}