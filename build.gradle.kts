import org.openjfx.gradle.JavaFXOptions

plugins {
  // Apply the Kotlin JVM plugin to add support for Kotlin.
  id("org.jetbrains.kotlin.jvm") version "1.3.50"

  // JavaFx Plugin
  id("org.openjfx.javafxplugin") version "0.0.8"

  // Apply the application plugin to add support for building a CLI application.
  application
}


tasks.named("test", Test::class) {
  useJUnitPlatform {}
}

//val javafx by tasks.getting(ExecTask::class) {
//
//}

extensions.getByType(JavaFXOptions::class).apply {
  this.version = "11.0.1"
  this.modules = listOf(
    "javafx.controls",
    "javafx.fxml",
    "javafx.graphics"
  )
}

repositories {
  // Use jcenter for resolving dependencies.
  // You can declare any Maven/Ivy/file repository here.
  jcenter()
}

dependencies {
  // Align versions of all Kotlin components
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

  // Use the Kotlin JDK 8 standard library.
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  // KotlinTest                   : https://github.com/kotlintest/kotlintest
  testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")

  // Kotlin-Logging               : https://github.com/MicroUtils/kotlin-logging
  implementation("io.github.microutils:kotlin-logging:1.7.6")

  // Logback Classic              : http://logback.qos.ch/
  implementation("ch.qos.logback:logback-classic:1.2.3")

  // Logback Classic              : http://logback.qos.ch/
  implementation("org.reflections:reflections:0.9.11")

  // controlsfx                   : https://github.com/controlsfx/controlsfx
  implementation("org.controlsfx:controlsfx:11.0.0")

  // Reflections                  : https://github.com/ronmamo/reflections
  implementation("org.reflections:reflections:0.9.11")
}

application {
  // Define the main class for the application
  mainClassName = "project_euler.MainKt"
}
