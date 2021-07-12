import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    kotlin("jvm") version "1.5.10"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group="ink.maxelbk"
version="DEV"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.github.vincenzopalazzo:material-ui-swing:1.1.2")
    implementation(files("./dependency/ResourceTools-0.2.1-build9.jar"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}

tasks {
    withType<ShadowJar> {
        manifest {
            attributes["Main-Class"] = "ink.maxelbk.mxcl.Main"
        }
    }
}