import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val kotlinVersion by extra { "1.3-M2" }
    val springBootVersion by extra { "2.0.5.RELEASE" }

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
    }
}

plugins {
    kotlin("jvm") version "1.3-M2"
}

apply {
    plugin("kotlin-spring")
    plugin("eclipse")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

group = "com.improve_future"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.springframework.boot:spring-boot-starter")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("org.jetbrains.kotlin:kotlin-reflect")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}
