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
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    implementation("androidx.test:monitor:1.6.1")
    testImplementation("org.testng:testng:6.9.6")
    androidTestImplementation("org.testng:testng:6.9.6")
    //hilt
    implementation("com.google.dagger:hilt-android:2.46.1")
    kapt("com.google.dagger:hilt-compiler:2.46.1")
    implementation("androidx.hilt:hilt-work:1.0.0")
    //firebase
    implementation(platform("com.google.firebase:firebase-bom:32.2.0"))
    //fire store
    implementation("com.google.firebase:firebase-firestore-ktx")
    //firebase auth
    implementation("com.google.firebase:firebase-auth-ktx:22.1.0")
    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    //room
    val room_version = "2.5.2"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    //noinspection KaptUsageInsteadOfKsp
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    testImplementation("androidx.room:room-testing:$room_version")
    implementation("androidx.room:room-paging:$room_version")
    //data store
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    //paging 3
    val paging_version = "3.1.1"
    //noinspection GradleDependency
    implementation("androidx.paging:paging-runtime-ktx:$paging_version")
    implementation("androidx.paging:paging-compose:3.2.0")
    //gson
    implementation("com.google.code.gson:gson:2.10.1")
    //workManager
    val work_version = "2.8.1"
    // Kotlin + coroutines
    implementation("androidx.work:work-runtime-ktx:$work_version")
    // optional - Multiprocess support
    implementation("androidx.work:work-multiprocess:$work_version")

    api(project(":entities"))
    api(project(":firebase"))
    api(project(":local"))
    api(project(":remote"))
    api(project(":repository"))
    api(project(":ui"))
    api(project(":usecase"))
    api(project(":viewmodels"))
}
