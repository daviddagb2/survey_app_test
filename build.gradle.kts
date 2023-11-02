// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("com.android.library") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.0" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.6.0" apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    alias(libs.plugins.dagger.hilt) apply false
}
