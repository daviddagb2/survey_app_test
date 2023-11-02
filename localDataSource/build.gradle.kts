@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.dagger.hilt.get().pluginId)
    id(libs.plugins.kapt.get().pluginId)
}

android {
    namespace = "com.gonzalez.blanchard.localdatasource"
    compileSdk = 33

    defaultConfig {
        minSdk = 21

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
}

dependencies {
    implementation(libs.androidx.ktx)
    implementation(libs.dagger.hilt)
    implementation(libs.androidx.room)
    implementation(libs.androidx.room.coroutines)
    implementation(libs.androidx.room.rxjava)
    implementation(libs.sqlcipher)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)
    testImplementation(libs.junit)
    kapt(libs.dagger.compiler)
    kapt(libs.androidx.room.compiler)
}