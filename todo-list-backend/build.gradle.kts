plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "1.9.25"
}

group = "com.lvu.todo"
version = "0.0.1-SNAPSHOT"
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web") // 웹 관련 의존성
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") // JPA 의존성
    implementation("org.hibernate:hibernate-core:6.4.4.Final") // Hibernate 6.x (Spring Boot 3.x 호환)
    implementation("com.mysql:mysql-connector-j:9.2.0") // MySQL 드라이버
    implementation("org.jetbrains.kotlin:kotlin-reflect") // Kotlin 반사 기능
    implementation("org.jetbrains.kotlin:kotlin-stdlib") // Kotlin 표준 라이브러리
    testImplementation("org.springframework.boot:spring-boot-starter-test") // 테스트
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

springBoot {
    mainClass.set("com.lvu.todo.TodoListBackendApplicationKt")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
