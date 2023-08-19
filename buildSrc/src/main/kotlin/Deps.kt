object Deps {
    private val composeVersion = "1.0.1"
    private val iconsVersion = "1.4.3"
    private val hiltVersion = "2.46.1"
    private val navVersion = "2.6.0"
    private val workVersion = "2.8.1"
    private val lifecycleVersion = "2.6.1"
    private val roomVersion = "2.5.2"
    private val dataStoreVersion = "1.0.0"
    private val retrofitConvertoerVersion = "2.9.0"
    private val okhttp3LoggingVersion = "4.11.0"
    private val okhttp3Version = "4.11.0"
    private val retrofitVersion = "2.9.0"
    private val activityComposeVersion = "1.7.2"
    private val coreKtxVersion = "1.10.1"
    private val junitVersion = "4.13.2"
    private val junitExtVersion = "1.1.5"
    private val testMonitorVersion = "1.6.1"
    private val testngVersion = "6.9.6"
    private val coilComposeVersion = "2.4.0"
    private val accompanistSystemUiControllerVersion = "0.28.0"
    private val accompanistPermissionsVersion = "0.31.3-beta"
    private val accompanistWebViewVersion = "0.28.0"
    private val lottieComposeVersion = "6.1.0"
    private val hiltNavigationComposeVersion = "1.1.0-alpha01"
    private val firebaseBomVersion = "32.2.0"
    private val firebaseAuthVersion = "22.1.0"
    private val workRuntimeKtxVersion = "2.8.1"
    private val workMultiprocessVersion = "2.8.1"
    private val gsonVersion = "2.10.1"
    private val appCompatVersion = "1.6.1"
    private val materialVersion = "1.9.0"
    private val constraintLayoutComposeVersion = "1.0.1"
    private val composeUITestManifestVVersion = "1.4.3"
    private val lifecycleRuntimeKtxVersion = "2.6.1"
    private val lifecycleViewModelComposeVersion = "2.6.1"
    private val lifecycleViewModelKtsVersion = "2.6.1"
    private val lifecycleRunTimeComposeVersion = "2.6.1"
    private val lifecycleSavedStateVersion = "2.6.1"
    private val lifecycleRuntimeTestingVersion = "2.6.1"
    private val pagingRuntimeVersion = "3.1.1"
    private val pagingComposeVersion = "3.2.0"
    private val hiltWorkerVersion = "1.0.0"
    private val dagger2Version = "2.46.1"
    private val googleServiceAuthVersion = "20.6.0"
    private val pagingCommonVersion = "3.2.0"
    private val cloudyVersion = "0.1.2"
    private val glassy = "0.0.4"
    private val exoPlayerVersion = "1.1.1"

    //glass
    val glass = "com.github.jakhongirmadaminov:glassmorphic-composables:$glassy"

    //cloudy
    val cloudy = "com.github.skydoves:cloudy:$cloudyVersion"

    // data store
    val dataStore = "androidx.datastore:datastore-preferences:$dataStoreVersion"

    // retrofit
    val retrofitConvertoer = "com.squareup.retrofit2:converter-gson:$retrofitConvertoerVersion"
    val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"

    // okhttp3
    val okhttp3Logging = "com.squareup.okhttp3:logging-interceptor:$okhttp3LoggingVersion"
    val okhttp3 = "com.squareup.okhttp3:okhttp:$okhttp3Version"

    // core
    val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    // testing
    val junit = "junit:junit:$junitVersion"
    val junitExt = "androidx.test.ext:junit-ktx:$junitExtVersion"
    val testMonitor = "androidx.test:monitor:$testMonitorVersion"
    val testng = "org.testng:testng:$testngVersion"

    // Coil
    val coilCompose = "io.coil-kt:coil-compose:$coilComposeVersion"

    // Accompanist
    val accompanistSystemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:$accompanistSystemUiControllerVersion"
    val accompanistPermissions =
        "com.google.accompanist:accompanist-permissions:$accompanistPermissionsVersion"
    val accompanistWebView = "com.google.accompanist:accompanist-webview:$accompanistWebViewVersion"

    // Lottie
    val lottieCompose = "com.airbnb.android:lottie-compose:$lottieComposeVersion"

    // icons
    val composeMaterialIconsExtended =
        "androidx.compose.material:material-icons-extended:$iconsVersion"
    val composeMaterialIconsCore = "androidx.compose.material:material-icons-core:$iconsVersion"

    // Dagger Hilt
    val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
    val hiltCompiler = "com.google.dagger:hilt-compiler:$hiltVersion"
    val hiltWork = "androidx.hilt:hilt-work:$hiltWorkerVersion"
    val dagger = "com.google.dagger:dagger:$dagger2Version"

    // Navigation
    val navCompose = "androidx.navigation:navigation-compose:$navVersion"
    val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    // Firebase
    val firebaseBom = "com.google.firebase:firebase-bom:$firebaseBomVersion"
    val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    val firebaseAuth = "com.google.firebase:firebase-auth-ktx:$firebaseAuthVersion"
    val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx"
    val playServicesAuth = "com.google.android.gms:play-services-auth:$googleServiceAuthVersion"

    // WorkManager
    val workRuntimeKtx = "androidx.work:work-runtime-ktx:$workVersion"
    val workMultiprocess = "androidx.work:work-multiprocess:$workVersion"

    // Gson
    val gson = "com.google.code.gson:gson:$gsonVersion"

    // UI Dependencies
    val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
    val material = "com.google.android.material:material:$materialVersion"
    val constraintLayoutCompose =
        "androidx.constraintlayout:constraintlayout-compose:$constraintLayoutComposeVersion"

    // Compose
    val composeBom = "androidx.compose:compose-bom:$composeVersion"
    val composeUI = "androidx.compose.ui:ui"
    val composeUIGraphics = "androidx.compose.ui:ui-graphics"
    val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    val composeMaterial3 = "androidx.compose.material3:material3"
    val composeUITestJunit4 = "androidx.compose.ui:ui-test-junit4"
    val composeUITooling = "androidx.compose.ui:ui-tooling"
    val composeUITestManifest = "androidx.compose.ui:ui-test-manifest"
    val composeUITestManifestV =
        "androidx.compose.ui:ui-test-manifest:$composeUITestManifestVVersion"
    val composeFoundation = "androidx.compose.foundation:foundation"

    // Lifecycle
    val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeKtxVersion"
    val lifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleViewModelComposeVersion"
    val lifecycleViewModelKts =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleViewModelKtsVersion"
    val lifecycleRunTimeCompose =
        "androidx.lifecycle:lifecycle-runtime-compose:$lifecycleRunTimeComposeVersion"
    val lifecycleSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleSavedStateVersion"
    val lifecycleRuntimeTesting =
        "androidx.lifecycle:lifecycle-runtime-testing:$lifecycleRuntimeTestingVersion"

    //noinspection GradleDependency
    val pagingRuntime = "androidx.paging:paging-runtime-ktx:$pagingRuntimeVersion"
    val pagingCompose = "androidx.paging:paging-compose:$pagingComposeVersion"
    val pagingCommon = "androidx.paging:paging-common-ktx:$pagingCommonVersion"

    // Room
    val roomRuntime = "androidx.room:room-runtime:$roomVersion"
    val roomCompiler = "androidx.room:room-compiler:$roomVersion"

    //noinspection KaptUsageInsteadOfKsp
    val roomCompilerKapt = "androidx.room:room-compiler:$roomVersion"
    val roomKtx = "androidx.room:room-ktx:$roomVersion"
    val roomTesting = "androidx.room:room-testing:$roomVersion"
    val roomPaging = "androidx.room:room-paging:$roomVersion"

    //exoplayer
    val exoPlayer = "androidx.media3:media3-exoplayer:$exoPlayerVersion"
}

