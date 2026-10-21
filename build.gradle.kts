plugins {
    id("java")
}

group = "com.beraldoeventos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.jar{
    manifest{
        attributes("Main-Class" to "com.beraldo.arraylist.Main")
    }
}

java{
    sourceCompatibility = JavaVersion.VERSION_21
}

tasks.test {
    useJUnitPlatform()
}