plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    kotlin("plugin.serialization") version "1.6.10"
}

android {
    namespace = "com.bestswlkh0310.b1nddormitorywork"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.bestswlkh0310.b1nddormitorywork"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {
    implementation("io.coil-kt:coil:2.1.0")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

    implementation ("androidx.activity:activity-compose:1.4.0")
    implementation ("androidx.compose.material:material:1.1.1")
    implementation ("androidx.compose.animation:animation:1.1.1")
    implementation ("androidx.compose.ui:ui-tooling:1.1.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")

    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.1.1")
    implementation ("com.google.android.material:compose-theme-adapter:1.1.1")
    implementation ("com.google.accompanist:accompanist-appcompat-theme:0.16.0")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}