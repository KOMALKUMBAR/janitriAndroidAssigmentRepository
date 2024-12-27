// Top-level build.gradle.kts
buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
        classpath("com.google.gms:google-services:4.4.0")
    }
}

plugins {

        id("com.android.application") version "8.7.1" apply false
        id("com.android.library") version "8.7.1" apply false
        id("org.jetbrains.kotlin.android") version "2.0.0" apply false

}