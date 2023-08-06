plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.redvelvet.local"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(":repository"))
    implementation(Deps.coreKtx)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitExt)
    // Hilt
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltWork)
    // Room
    implementation(Deps.roomRuntime)
    annotationProcessor(Deps.roomCompiler)
    //noinspection KaptUsageInsteadOfKsp
    kapt(Deps.roomCompilerKapt)
    implementation(Deps.roomKtx)
    testImplementation(Deps.roomTesting)
    implementation(Deps.roomPaging)
    //data store
    implementation(Deps.dataStore)
    //paging
    implementation(Deps.pagingRuntime)
    implementation(Deps.pagingCompose)
    //gson
    implementation(Deps.gson)
    //workManager
    implementation(Deps.workRuntimeKtx)
    implementation(Deps.workMultiprocess)
}
