// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false // Hilt plugin
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10") // Update Kotlin version here
        classpath("com.android.tools.build:gradle:8.2.1")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
    }
}