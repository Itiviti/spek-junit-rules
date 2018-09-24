plugins {
    kotlin("jvm") version "1.2.61"
    `maven-publish`
    id("com.jfrog.bintray").version("1.8.4")
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

val sourcesJar by tasks.creating(Jar::class) {
    classifier = "sources"
    from(sourceSets["main"].java)
}

publishing {
    publications {
        create("mavenJava", MavenPublication::class.java) {
            from(components["java"])
            artifact(sourcesJar)
        }
    }
}

bintray {
    user = project.findProperty("bintrayUser")?.toString()
    key = project.findProperty("bintrayApiKey")?.toString()
    setPublications("mavenJava")
    publish = true
    pkg.apply {
        version.gpg.sign = true
        userOrg = "ullink"
        repo = "maven"
        name = project.name
        desc = project.description
        setLabels("junit", "test", "spek")
        setLicenses("Apache-2.0")
        websiteUrl = "https://github.com/Ullink/${project.name}"
        vcsUrl = "https://github.com/Ullink/${project.name}"
        issueTrackerUrl = "https://github.com/Ullink/${project.name}/issues"
    }
}