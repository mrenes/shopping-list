object Versions {
    const val androidTest = "1.1.0"
    const val stetho = "1.5.1"
    const val constraintLayout = "1.1.3"
    const val archCore = "2.0.1"
    const val moshi = "1.8.0"
    const val retrofit = "2.6.2"
    const val mockito = "3.1.0"
    const val mockitoKotlin = "2.2.0"
    const val gradle = "3.5.1"
    const val room = "2.2.5"
    const val kotlin = "1.3.50"
    const val appCompat = "1.1.0"
    const val ktx = "1.0.2"
    const val junit_ext = "1.1.0"
    const val espresso = "3.1.1"
    const val junit = "4.12"
    const val okHttp = "4.2.1"
    const val koin = "2.0.1"
    const val timber = "4.7.1"
    const val lifecycle = "2.2.0-alpha02"
    const val lifecycleSavedState = "1.0.0-alpha01"
    const val materialComponents = "1.1.0-beta01"
    const val coroutinesCode = "1.3.2"
    const val navigationComponentFragment = "2.1.0"
    const val navigationComponentUI = "2.1.0"
    const val cardView = "1.0.0"
    const val support_v4 = "1.0.0"
    const val balloon = "1.0.6"
    const val pagerBullet = "1.0.9"
    const val signaturePad = "1.2.1"
    const val googlePlayService = "4.3.2"
    const val fabricTools = "1.31.2"
    const val firebaseAnalytics = "17.2.1"
    const val crashlytics = "2.10.1"
    const val leakCanary = "2.1"
    const val fragmentKtx = "1.2.0-alpha01"
    const val rxJava = "2.2.14"
    const val rxKotlin = "2.4.0"
    const val lottie = "3.3.1"
}

object Libs {

    // Gradle
    const val gradle_classpath = "com.android.tools.build:gradle:${Versions.gradle}"

    // Kotlin
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlin_classpath = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCode}"
    const val coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesCode}"
    const val coroutines_reactive = "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${Versions.coroutinesCode}"

    // Android JetPack
    const val jetpack_appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val jetpack_ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val jetpack_support_v4 = "androidx.legacy:legacy-support-v4:${Versions.support_v4}"

    // Persistence
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"

    // Remote
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val ok_http = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val ok_http_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    // Android tests
    const val jetpack_junit = "androidx.test.ext:junit:${Versions.junit_ext}"
    const val jetpack_espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val jetpack_arch = "androidx.arch.core:core-testing:${Versions.archCore}"
    const val room_test = "androidx.room:room-testing:${Versions.room}"
    const val android_runner = "androidx.test:runner:${Versions.androidTest}"
    const val android_rules = "androidx.test:rules:${Versions.androidTest}"

    // Tests
    const val junit = "junit:junit:${Versions.junit}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockito_inline = "org.mockito:mockito-inline:${Versions.mockito}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"

    // DI
    const val koin_android = "org.koin:koin-android:${Versions.koin}"
    const val koin_view_model = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val koin_scope = "org.koin:koin-androidx-scope:${Versions.koin}"

    // Utils
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val stetho_okhttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    const val lifecycle_view_model_extensions = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycle_live_data_extensions = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycle_saved_state = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycleSavedState}"

    // Views
    const val material_components = "com.google.android.material:material:${Versions.materialComponents}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    const val balloon = "com.github.skydoves:balloon:${Versions.balloon}"
    const val pagerBullet = "com.robohorse.pagerbullet:pagerbullet:${Versions.pagerBullet}"
    const val signaturePad = "com.github.gcacace:signature-pad:${Versions.signaturePad}"

    // Lottie
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"

    // Navigation
    const val navigation_component_fragment = "androidx.navigation:navigation-fragment:${Versions.navigationComponentFragment}"
    const val navigation_component_ui = "androidx.navigation:navigation-ui:${Versions.navigationComponentUI}"
    const val navigation_component_fragment_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponentFragment}"
    const val navigation_component_ui_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponentUI}"

    // Fabric
    const val googlePlayServices = "com.google.gms:google-services:${Versions.googlePlayService}"
    const val fabricTools = "io.fabric.tools:gradle:${Versions.fabricTools}"
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics:${Versions.firebaseAnalytics}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    //RxJava
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"

}


object KaptLibraries {
    val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
}