import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
}

group = "org.easysql"
version = "1.0-SNAPSHOT"

repositories {
    maven {
        setUrl("https://maven.aliyun.com/repository/public/")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("reflect"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.useK2 = true
}