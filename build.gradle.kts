plugins {
    id ("java")
    id ("org.graalvm.buildtools.native") version "0.9.28"
}

group = "team.boomer"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("info.picocli:picocli:4.7.5")
    annotationProcessor("info.picocli:picocli-codegen:4.7.5")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}


tasks.test {
    useJUnitPlatform()
}

graalvmNative {
    binaries {
        named("main") {
            imageName.set("aws-boomer")
            mainClass.set("team.boomer.Application")
        }
    }
}