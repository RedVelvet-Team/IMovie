import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
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

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String", "API_KEY", properties.getProperty("apikey"))
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
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = Versions.javaVersion
        targetCompatibility = Versions.javaVersion
    }
    kotlinOptions {
        jvmTarget = Versions.jvmtarget
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
    // core + testing
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

    implementation(project(":firebase"))
    implementation(project(":local"))
    implementation(project(":remote"))
    implementation(project(":repository"))
    implementation(project(":ui"))
    implementation(project(":viewmodels"))
    implementation(project(":usecase"))
}
