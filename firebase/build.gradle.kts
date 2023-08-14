plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.redvelvet.firebase"
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
        sourceCompatibility = Versions.javaVersion
        targetCompatibility = Versions.javaVersion
    }
    kotlinOptions {
        jvmTarget = Versions.jvmtarget
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(":repository"))
    // core + testing
    implementation(Deps.coreKtx)
    implementation(Deps.junitExt)
    implementation(Deps.testMonitor)
    testImplementation(Deps.testng)
    androidTestImplementation(Deps.testng)
    testImplementation(Deps.junit)
    // Hilt
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    //firebase
    implementation(platform(Deps.firebaseBom))
    implementation(Deps.firebaseAnalytics)
    implementation(Deps.firebaseAuth)
    implementation(Deps.firebaseFirestore)
    implementation(Deps.playServicesAuth)
}
