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
        sourceCompatibility = Versions.javaVersion
        targetCompatibility = Versions.javaVersion
    }
    kotlinOptions {
        jvmTarget = Versions.jvmtarget
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

    implementation(Deps.glass)
    implementation(Deps.cloudy)
    // core + testing
    implementation(Deps.coreKtx)
    implementation("androidx.media3:media3-ui:1.1.1")
    testImplementation(Deps.junit)
    implementation(Deps.activityCompose)
    androidTestImplementation(Deps.junitExt)
    // hilt
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltNavigationCompose)
    //coil
    implementation(Deps.coilCompose)
    // constraint
    implementation(Deps.constraintLayoutCompose)
    // accompanist
    implementation(Deps.accompanistSystemUiController)
    implementation(Deps.accompanistPermissions)
    implementation(Deps.accompanistWebView)
    // lottie
    implementation(Deps.lottieCompose)
    // work
    implementation(Deps.workRuntimeKtx)
    // compose
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
    // lifecycle
    implementation(Deps.lifecycleRuntimeKtx)
    implementation(Deps.lifecycleViewModelCompose)
    //paging
    implementation(Deps.pagingCommon)
    implementation(Deps.pagingRuntime)
    implementation(Deps.pagingCompose)
    //exoPlayer
    implementation(Deps.exoPlayer)
    //youtubePlayer
    implementation(Deps.youtubePlayer)
}

