plugins {
    `java-library`
}

val packageName = "tech.kotlinhero.autohelper"

group = "$packageName${project.path.replace(":", ".")}"
version = project.property("projectVersion").toString()

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}