buildscript {
    val agp_version by extra("8.6.0")
    val agp_version1 by extra("8.7.1")
    val agp_version2 by extra("8.6.1")
    val agp_version3 by extra("8.6.0")
    val agp_version4 by extra("8.2.1")
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
}