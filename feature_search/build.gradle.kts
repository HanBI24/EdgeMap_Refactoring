plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.feature_search"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0-alpha01"
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":navigation"))
    implementation(project(":webview"))
    implementation(project(":feature_search:presentation"))
    implementation(project(":feature_search:domain"))
    implementation(project(":feature_search:data"))
    implementation(project(":feature_search_result"))

    implementation("androidx.core:core-ktx:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.compose.material:material:1.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.ui:ui:1.4.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation("androidx.navigation:navigation-compose:2.6.0-alpha08")
    implementation("androidx.compose.foundation:foundation:1.3.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.43")
    kapt("com.google.dagger:hilt-android-compiler:2.43")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-rc01")
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")

    // Coil
    implementation("io.coil-kt:coil-compose:1.3.2")

    // Paging 3.0
    implementation("androidx.paging:paging-compose:1.0.0-alpha14")

    // Material 3
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.0")

}