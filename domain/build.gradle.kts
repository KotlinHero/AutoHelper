plugins {
    id("project-common")
    kotlin("jvm")
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(libs.jimmer.core)
    compileOnly(libs.jimmer.sql)
    ksp(libs.jimmer.ksp)

    testImplementation(kotlin("test"))
}

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}