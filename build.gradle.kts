plugins {
    kotlin("jvm") version "1.8.0"  // �������� ������ Kotlin ��� ������ � JVM
    java
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin ����������� ����������
    implementation(kotlin("stdlib"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    // Mockito
    testImplementation("org.mockito:mockito-core:4.0.0")

    // Log4j2 �����������
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.20.0")
}

tasks.test {
    useJUnitPlatform() // �������� JUnit 5
}

// ��������� ��� �������� JAR
tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "com.example.metro.MainKt"  // ������� ������� ����� ��� ����� ����� (��� Kotlin ��� ����� MainKt)
        )
    }
}

// �������� ������ ��� ������ JAR-�����
val createJar by tasks.registering(Jar::class) {
    archiveBaseName.set("metro-graph")  // ������� ��� ������ JAR-�����
    from(sourceSets.main.get().output)
    with(tasks.jar.get())
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE // ���������� ��������� ���������� ����������
}