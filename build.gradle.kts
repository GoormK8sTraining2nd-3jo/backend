import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.21"
    kotlin("plugin.spring") version "1.5.21"
    kotlin("kapt") version "1.4.10"
}

group = "kr.kua.backend"
version = "0.0.2-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.querydsl:querydsl-jpa:4.2.1")
    implementation("org.mariadb.jdbc:mariadb-java-client:2.7.0")
    implementation("com.google.code.gson:gson:2.8.9")
    compileOnly("org.projectlombok:lombok")
    kapt("com.querydsl:querydsl-apt:4.2.2:jpa")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    implementation("org.apache.httpcomponents:httpclient:4.5.13")
    implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
    kotlin.srcDir("$buildDir/generated/source/kapt/main")
}
