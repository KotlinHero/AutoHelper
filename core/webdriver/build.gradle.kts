plugins {
    kotlin("jvm")

    id("project-common")
}

dependencies {
    api(libs.selenium.api)
    implementation(libs.bundles.selenium)

    testImplementation(kotlin("test"))
}

