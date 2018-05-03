plugins {
    kotlin("jvm") version "1.2.0"
    `maven-publish`
}

dependencies {
    compileOnly("junit", "junit", "4.12")
    compile("org.jetbrains.spek", "spek-api", "1.1.5")
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))
}

repositories {
    jcenter()
}

publishing {
    (publications) {
        "mavenJava"(MavenPublication::class) {
            from(components["java"])
        }
    }
}