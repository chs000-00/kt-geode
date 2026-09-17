import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
}

group = "chs000.kt-geode"
version = "v1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    macosArm64("ktgeodebuild")
    mingwX64("ktgeodebuild")

    targets.withType<KotlinNativeTarget>().configureEach {
        binaries {
            staticLib()
        }
    }

    sourceSets {
        nativeMain.dependencies {
            implementation(libs.kotlinxSerializationJson)
        }
    }
}
