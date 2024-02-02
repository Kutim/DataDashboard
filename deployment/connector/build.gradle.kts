plugins {
    `java-library`
    id("application")
    alias(libs.plugins.shadow)
}

repositories {
  maven { url = uri("https://maven.aliyun.com/repository/public/") }
  maven { url = uri("https://maven.aliyun.com/repositories/jcenter") }
  maven { url = uri("https://maven.aliyun.com/repositories/google") }
  maven { url = uri("https://maven.aliyun.com/repositories/central") }
  google()
  mavenCentral()
}

dependencies {
    implementation(libs.edc.runtime.metamodel)
    implementation(libs.edc.control.plane.api.client)
    implementation(libs.edc.control.plane.api)
    implementation(libs.edc.control.plane.core)
    implementation(libs.edc.dsp)
    implementation(libs.edc.configuration.filesystem)
    implementation(libs.edc.vault.filesystem)
    implementation(libs.edc.iam.mock)
    implementation(libs.edc.management.api)
    implementation(libs.edc.api.observability)
    implementation(libs.edc.transfer.data.plane)
    implementation(libs.edc.transfer.pull.http.receiver)

    implementation(libs.edc.data.plane.selector.api)
    implementation(libs.edc.data.plane.selector.core)
    implementation(libs.edc.data.plane.selector.client)

    implementation(libs.edc.data.plane.api)
    implementation(libs.edc.data.plane.core)
    implementation(libs.edc.data.plane.http)

    implementation(libs.edc.federated.catalog.core)
    implementation(libs.edc.federated.catalog.api)
}

application {
    mainClass.set("org.eclipse.edc.boot.system.runtime.BaseRuntime")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    dependsOn("distTar", "distZip")
    mergeServiceFiles()
    archiveFileName.set("connector.jar")
}
