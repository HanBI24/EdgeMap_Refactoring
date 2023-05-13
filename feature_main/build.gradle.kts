import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.feature_main"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

//        buildConfigField("String", "ClientID", getApiKey("ClientID"))
//        buildConfigField("String", "ClientSecret", getApiKey("ClientSecret"))
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
    implementation(project(":feature_search"))
    implementation(project(":feature_favorite"))

    implementation("androidx.core:core-ktx:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.compose.material:material:1.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.ui:ui:1.4.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")

//    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.1")
//    debugImplementation("androidx.compose.ui:ui-tooling:1.1.1")
//    debugImplementation("androidx.compose.ui:ui-test-manifest:1.1.1")

    implementation("io.github.fornewid:naver-map-compose:1.2.3")
    implementation("com.naver.maps:map-sdk:3.16.1")
    implementation("com.google.android.gms:play-services-location:21.0.1")

    implementation("com.google.accompanist:accompanist-permissions:0.31.0-alpha")

    implementation("androidx.navigation:navigation-compose:2.6.0-alpha08")
}

fun getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}