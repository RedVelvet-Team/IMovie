object Deps {
    val dataStore = "androidx.datastore:datastore-preferences:1.0.0"
    val retrofitConvertoer = "com.squareup.retrofit2:converter-gson:2.9.0"
    val okhttp3Logging = "com.squareup.okhttp3:logging-interceptor:4.11.0"
    val okhttp3 = "com.squareup.okhttp3:okhttp:4.11.0"
    val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    val activityCompose = "androidx.activity:activity-compose:1.7.2"
    val coreKtx = "androidx.core:core-ktx:1.10.1"
    val junit = "junit:junit:4.13.2"
    val junitExt = "androidx.test.ext:junit-ktx:1.1.5"
    val testMonitor = "androidx.test:monitor:1.6.1"
    val testng = "org.testng:testng:6.9.6"
    // Coil
    val coilCompose = "io.coil-kt:coil-compose:2.4.0"
    // Accompanist
    val accompanistSystemUiController = "com.google.accompanist:accompanist-systemuicontroller:0.28.0"
    val accompanistPermissions = "com.google.accompanist:accompanist-permissions:0.31.3-beta"
    val accompanistWebView = "com.google.accompanist:accompanist-webview:0.28.0"
    // Lottie
    val lottieCompose = "com.airbnb.android:lottie-compose:6.1.0"
    // Dagger Hilt
    private val hiltVersion = "2.46.1"
    val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
    val hiltCompiler = "com.google.dagger:hilt-compiler:$hiltVersion"
    val hiltWork = "androidx.hilt:hilt-work:1.0.0"
    val dagger = "com.google.dagger:dagger:2.46.1"
    // Navigation
    private val navVersion = "2.6.0"
    val navCompose = "androidx.navigation:navigation-compose:$navVersion"
    val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.1.0-alpha01"
    // Firebase
    val firebaseBom = "com.google.firebase:firebase-bom:32.2.0"
    val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    val firebaseAuth = "com.google.firebase:firebase-auth-ktx:22.1.0"
    val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx"
    val playServicesAuth = "com.google.android.gms:play-services-auth:20.6.0"
    // WorkManager
    private val workVersion = "2.8.1"
    val workRuntimeKtx = "androidx.work:work-runtime-ktx:$workVersion"
    val workMultiprocess = "androidx.work:work-multiprocess:$workVersion"
    // Gson
    val gson = "com.google.code.gson:gson:2.10.1"
    // UI Dependencies
    val appCompat = "androidx.appcompat:appcompat:1.6.1"
    val material = "com.google.android.material:material:1.9.0"
    val constraintLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
    // Compose
    private val composeVersion = "1.0.1"
    val composeBom = "androidx.compose:compose-bom:$composeVersion"
    val composeUI = "androidx.compose.ui:ui"
    val composeUIGraphics = "androidx.compose.ui:ui-graphics"
    val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    val composeMaterial3 = "androidx.compose.material3:material3"
    val composeUITestJunit4 = "androidx.compose.ui:ui-test-junit4"
    val composeUITooling = "androidx.compose.ui:ui-tooling"
    val composeUITestManifest = "androidx.compose.ui:ui-test-manifest"
    val composeUITestManifestV = "androidx.compose.ui:ui-test-manifest:1.4.3"
    val composeFoundation = "androidx.compose.foundation:foundation"
    val composeMaterialIconsCore = "androidx.compose.material:material-icons-core"
    val composeMaterialIconsExtended = "androidx.compose.material:material-icons-extended"
    // Lifecycle
    private val lifecycleVersion = "2.6.1"
    val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
    val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
    val lifecycleViewModelKts = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    val lifecycleRunTimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:$lifecycleVersion"
    val lifecycleSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion"
    val lifecycleRuntimeTesting = "androidx.lifecycle:lifecycle-runtime-testing:$lifecycleVersion"
    //noinspection GradleDependency
    val pagingRuntime = "androidx.paging:paging-runtime-ktx:3.1.1"
    val pagingCompose = "androidx.paging:paging-compose:3.2.0"
    // Room
    private val roomVersion = "2.5.2"
    val roomRuntime = "androidx.room:room-runtime:$roomVersion"
    val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    //noinspection KaptUsageInsteadOfKsp
    val roomCompilerKapt = "androidx.room:room-compiler:$roomVersion"
    val roomKtx = "androidx.room:room-ktx:$roomVersion"
    val roomTesting = "androidx.room:room-testing:$roomVersion"
    val roomPaging = "androidx.room:room-paging:$roomVersion"
}

