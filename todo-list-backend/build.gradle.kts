plugins {
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

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

springBoot {
    mainClass.set("com.lvu.todo.TodoListBackendApplicationKt")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
