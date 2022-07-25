import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.7.10"
    application
    id("com.github.ben-manes.versions") version "0.42.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("org.jmailen.kotlinter") version "3.11.1"
}

repositories {
    mavenCentral()
}

val shadowImplementation: Configuration by configurations.creating
configurations["implementation"].extendsFrom(shadowImplementation)

dependencies {
    shadowImplementation(kotlin("stdlib"))
    shadowImplementation("net.dv8tion:JDA:5.0.0-alpha.4")
    shadowImplementation("ch.qos.logback:logback-classic:1.2.11")
}

application {
    mainClass.set("dev.s7a.sushi.Main")
}

tasks.named("build") {
    dependsOn("shadowJar")
}

task("stage") { // For Heroku
    dependsOn("build")
}

tasks.withType<ShadowJar> {
    configurations = listOf(shadowImplementation)
    archiveClassifier.set("")
}
