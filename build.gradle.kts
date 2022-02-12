import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.arenagod.gradle.MybatisGenerator") version "1.4"
    id("com.github.ben-manes.versions") version "0.39.0"
    kotlin("jvm") version "1.5.20"
    kotlin("plugin.spring") version "1.5.20"
}

allprojects {
    group = "com.github.iskitahara"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
        testImplementation("org.assertj:assertj-core:3.20.2")
        testImplementation("org.mockito:mockito-core:3.11.2")
        testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }
        testImplementation("org.springframework.security:spring-security-test")
    }

    tasks.jar {enabled = true}

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}


configure(listOf(project("api"))) {

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-data-redis")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.12.3")
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        developmentOnly("io.springfox:springfox-boot-starter:3.0.0")

        runtimeOnly(project(":infra-order-db"))
        runtimeOnly(project(":infra-item-api"))
        implementation(project(":application"))
        implementation(project(":domain"))
    }
}

configure(listOf(project("infra-order-db"))) {
    apply(plugin = "com.arenagod.gradle.MybatisGenerator")

    dependencies {
        implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
        implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.1")
        implementation("mysql:mysql-connector-java:8.0.25")
        mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.0")
        implementation(project(":domain"))
    }

    mybatisGenerator {
        verbose = true
        configFile = "${projectDir}/src/main/resources/generatorConfig.xml"
    }
}


configure(listOf(project("infra-item-api"))) {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework:spring-context:4.0.1.RELEASE")
        implementation(project(":domain"))
    }
}

configure(listOf(project("application"))) {
    dependencies {
        implementation("org.springframework.security:spring-security-core:5.5.1")
        implementation("org.springframework:spring-tx:5.3.8")
        implementation(project(":domain"))
    }
}

project(":api"){
    tasks.bootJar{ enabled = true }
}
