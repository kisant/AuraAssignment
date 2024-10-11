// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    val kotlinPluginVersion = "1.9.0"
    val kspPluginVersion = "$kotlinPluginVersion-1.0.13"

    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.devtools.ksp") version kspPluginVersion apply false
}