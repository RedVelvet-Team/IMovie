import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.redvelvet.remote"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String", "API_KEY", properties.getProperty("apikey"))
        buildConfigField("String", "BASE_URL", properties.getProperty("baseUrl"))

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(":repository"))
    implementation(Deps.coreKtx)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitExt)
    androidTestImplementation(Deps.testMonitor)
    // Hilt
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltWork)
    // Retrofit
    implementation(Deps.gson)
    implementation(Deps.retrofit)
    implementation(Deps.retrofitConvertoer)
    implementation(Deps.okhttp3Logging)
    implementation(Deps.okhttp3)
    // WorkManager
    implementation(Deps.workRuntimeKtx)
    implementation(Deps.workMultiprocess)
    //paging
    implementation(Deps.pagingRuntime)
    implementation(Deps.pagingCompose)
}

