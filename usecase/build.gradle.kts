plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    kotlin("kapt")
}
java {
    sourceCompatibility = Versions.javaVersion
    targetCompatibility = Versions.javaVersion
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = Versions.jvmtarget
}
dependencies {
    api(project(":entities"))
    implementation(Deps.dagger)
    implementation("androidx.paging:paging-common-ktx:3.2.0")
    testImplementation(Deps.testng)
}
