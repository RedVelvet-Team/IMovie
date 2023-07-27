buildscript {
    val agp_version by extra("8.1.0")
    val agp_version1 by extra("8.1.0")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val nav_version = "2.6.0"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.44")
        classpath ("com.google.gms:google-services:4.3.15")
        classpath ("com.google.firebase:perf-plugin:1.4.2")
        classpath ("com.google.firebase:firebase-crashlytics-gradle:2.9.7")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.google.gms.google-services") version "4.3.15" apply false
    kotlin("kapt") version "1.9.0"
}