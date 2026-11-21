plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.walletview"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.walletview"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")

    // Libreria externa para las graficas (pastel y barras)
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
}
