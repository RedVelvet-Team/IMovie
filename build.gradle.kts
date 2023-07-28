buildscript {
//    val agp_version by extra("8.1.0")
//    val agp_version1 by extra("8.1.0")
//    repositories {
//        google()
//        mavenCentral()
//    }
    dependencies {
        classpath ("com.google.gms:google-services:4.3.15")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.46.1" apply false
    id("com.google.gms.google-services") version "4.3.15" apply false
    kotlin("kapt") version "1.9.0"
}