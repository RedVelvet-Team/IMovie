plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.redvelvet.ui"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(":viewmodels"))
    implementation(Deps.coreKtx)
    testImplementation(Deps.junit)
    implementation(Deps.activityCompose)
    androidTestImplementation(Deps.junitExt)
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltNavigationCompose)
    implementation(Deps.hiltWork)
    implementation(Deps.coilCompose)
    implementation(Deps.constraintLayoutCompose)
    implementation(Deps.accompanistSystemUiController)
    implementation(Deps.accompanistPermissions)
    implementation(Deps.accompanistWebView)
    implementation(Deps.lottieCompose)
    implementation(Deps.workRuntimeKtx)
    implementation(Deps.workMultiprocess)
    implementation(Deps.gson)
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.lifecycleRuntimeKtx)
    implementation(platform(Deps.composeBom))
    implementation(Deps.composeUI)
    implementation(Deps.composeUIGraphics)
    implementation(Deps.composeUIToolingPreview)
    implementation(Deps.composeMaterial3)
    androidTestImplementation(platform(Deps.composeBom))
    androidTestImplementation(Deps.composeUITestJunit4)
    debugImplementation(Deps.composeUITooling)
    debugImplementation(Deps.composeUITestManifest)
    debugImplementation(Deps.composeUITestManifestV)
    implementation(Deps.composeFoundation)
    implementation(Deps.composeMaterialIconsCore)
    implementation(Deps.composeMaterialIconsExtended)
    implementation(Deps.navCompose)
    implementation(Deps.lifecycleViewModelCompose)
}

