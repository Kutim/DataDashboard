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
    // SLF4J API
    implementation("org.slf4j:slf4j-api:1.7.36") // 使用你需要的版本
    // Logback Classic Implementation
    implementation("ch.qos.logback:logback-classic:1.4.12") // 使用你需要的版本



    implementation(libs.edc.api.core)
    implementation(libs.edc.api.observability)
    implementation(libs.edc.auth.spi)
    implementation(libs.edc.auth.tokenbased)
    implementation(libs.edc.boot)
//    implementation(libs.edc.build.plugin)
    implementation(libs.edc.configuration.filesystem)
    implementation(libs.edc.connector.core)
    implementation(libs.edc.control.plane.api.client)
    implementation(libs.edc.control.plane.api)
    implementation(libs.edc.control.plane.core)
    implementation(libs.edc.data.plane.api)
//    implementation(libs.edc.data.plane.aws.s3)
//    implementation(libs.edc.data.plane.azure.storage)
    implementation(libs.edc.data.plane.client)
    implementation(libs.edc.data.plane.core)
    implementation(libs.edc.data.plane.http)
    implementation(libs.edc.data.plane.kafka)
    implementation(libs.edc.data.plane.selector.api)
    implementation(libs.edc.data.plane.selector.client)
    implementation(libs.edc.data.plane.selector.core)
    implementation(libs.edc.data.plane.spi)
    implementation(libs.edc.data.plane.util)
    implementation(libs.edc.dsp)
    implementation(libs.edc.http)
    implementation(libs.edc.iam.mock)
    implementation(libs.edc.jersey.micrometer)
    implementation(libs.edc.jetty.micrometer)
    implementation(libs.edc.json.ld)
    implementation(libs.edc.management.api)
    implementation(libs.edc.micrometer.core)
    implementation(libs.edc.monitor.jdk.logger)
//    implementation(libs.edc.provision.aws.s3)
    implementation(libs.edc.runtime.metamodel)
    implementation(libs.edc.transfer.data.plane)
    implementation(libs.edc.transfer.process.api)
    implementation(libs.edc.transfer.pull.http.receiver)
    implementation(libs.edc.transfer.pull.http.dynamic.receiver)
    implementation(libs.edc.util)
    implementation(libs.edc.validator.core)
//    implementation(libs.edc.vault.azure)
    implementation(libs.edc.vault.filesystem)


    implementation(libs.edc.core.spi)
    implementation(libs.edc.federated.catalog.core)
    implementation(libs.edc.federated.catalog.api)

    implementation(libs.jakarta.rsApi)
    implementation(libs.jakartaJson)
    implementation(libs.okhttp.mockwebserver)
    implementation(libs.restAssured)
    implementation(libs.kafka.clients)
    implementation(libs.opentelemetry)
    implementation(libs.opentelemetry.annotations)











//  implementation(libs.edc.auth.spi)
//    implementation(libs.edc.auth.tokenbased)
//    implementation(libs.edc.control.plane.api.client)
//    implementation(libs.edc.control.plane.api)
//    implementation(libs.edc.control.plane.core)
//    implementation(libs.edc.core.spi)
//    implementation(libs.edc.dsp)
//    implementation(libs.edc.configuration.filesystem)
//    implementation(libs.edc.vault.filesystem)
//    implementation(libs.edc.iam.mock)
//    implementation(libs.edc.management.api)
//    implementation(libs.edc.api.observability)
//    implementation(libs.edc.transfer.data.plane)
//    implementation(libs.edc.transfer.pull.http.receiver)
//
//    implementation(libs.edc.data.plane.selector.api)
//    implementation(libs.edc.data.plane.selector.core)
//    implementation(libs.edc.data.plane.selector.client)
//
//    implementation(libs.edc.data.plane.api)
//    implementation(libs.edc.data.plane.core)
//    implementation(libs.edc.data.plane.http)
//
//    implementation(libs.edc.federated.catalog.core)
//    implementation(libs.edc.federated.catalog.api)
//
//    implementation(libs.edc.runtime.metamodel)



}

application {
    mainClass.set("org.eclipse.edc.boot.system.runtime.BaseRuntime")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    dependsOn("distTar", "distZip")
    mergeServiceFiles()
    archiveFileName.set("connector.jar")
}
