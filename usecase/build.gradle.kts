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
    //dagger
    implementation(Deps.dagger)
    //paging
    implementation(Deps.pagingCommon)
    //test
    testImplementation(Deps.testng)
}
