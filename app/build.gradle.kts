plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.redvelvet.imovie"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.redvelvet.imovie"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(Deps.coreKtx)
    implementation(Deps.junitExt)
    implementation(Deps.testMonitor)
    testImplementation(Deps.testng)
    androidTestImplementation(Deps.testng)
    // Hilt
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltWork)
    //firebase
    implementation(platform(Deps.firebaseBom))
    implementation(Deps.firebaseAuth)
    implementation(Deps.firebaseFirestore)
    //retrofit
    implementation(Deps.retrofit)
    implementation(Deps.retrofitConvertoer)
    implementation(Deps.okhttp3Logging)
    implementation(Deps.okhttp3)
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

    api(project(":firebase"))
    api(project(":local"))
    api(project(":remote"))
    api(project(":repository"))
    api(project(":ui"))
    api(project(":viewmodels"))
    implementation(project(":usecase"))
}
