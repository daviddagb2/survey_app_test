@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.dagger.hilt.get().pluginId)
    id(libs.plugins.kapt.get().pluginId)
    id(libs.plugins.androidx.navigation.get().pluginId)
    id(libs.plugins.ktlint.jlleitschuh.get().pluginId)
}

android {
    namespace = "com.gonzalez.blanchard.surveyapptest"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.gonzalez.blanchard.surveyapptest"
        minSdk = 21
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

    buildFeatures {
        viewBinding = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //implementation("androidx.core:core-ktx:1.9.0")
    //implementation("androidx.appcompat:appcompat:1.6.1")
    //implementation("com.google.android.material:material:1.10.0")
    //implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    api(project(":data"))
    implementation(project(":domain"))

    implementation(libs.androidx.ktx)

    // Import other libraries
    implementation(libs.androidx.constraint)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.fragment)

    testImplementation(libs.junit)
    androidTestImplementation(libs.test.ext)
    androidTestImplementation(libs.test.espresso.core)

    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.dagger.hilt)
    implementation(libs.dagger.hilt.core)
    implementation(libs.joda.time)
    implementation(libs.androidxcore)
    // testImplementation("junit:junit:4.13.2")
    // androidTestImplementation("androidx.test.ext:junit:1.1.5")
    // androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    kapt(libs.dagger.hilt.compiler)
    kapt(libs.dagger.compiler)
}