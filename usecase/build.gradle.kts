plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    kotlin("kapt")
}
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
dependencies {
    api(project(":entities"))
    implementation(Deps.gson)
    implementation(Deps.dagger)
    testImplementation(Deps.testng)
}
