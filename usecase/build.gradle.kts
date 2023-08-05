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
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.google.dagger:dagger:2.46.1")
    testImplementation("org.testng:testng:6.9.6")
    //paging
    implementation("androidx.paging:paging-common-ktx:3.2.0")
}
