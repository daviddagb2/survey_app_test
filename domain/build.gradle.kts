@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id(libs.plugins.kapt.get().pluginId)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.dagger.hilt.core)
    implementation(libs.androidx.paging.common)
    testImplementation(libs.junit)
    kapt(libs.dagger.compiler)
}
