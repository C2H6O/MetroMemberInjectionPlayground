import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
//    alias(libs.plugins.anvilKsp)
    alias(libs.plugins.metro)
}

//anvil {
//    useKsp(
//        contributesAndFactoryGeneration = true,
//        componentMerging = true
//    )
//}

android {
    namespace = "net.doubov.daggeranvilplayground"

    compileSdkVersion(36)

    sourceSets {
        getByName("main") {
            val diFramework = providers.gradleProperty("diFramework").get()
            if (diFramework == "metro") {
                kotlin.srcDir("src/metro/kotlin")
            } else {
                kotlin.srcDir("src/anvil/kotlin")
            }
        }
    }

    defaultConfig {
        applicationId = "net.doubov.daggeranvilplayground"
        minSdk = 29
        targetSdk = 36
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

        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
}

//kotlin {
//    compilerOptions {
//        languageVersion.set(KotlinVersion.KOTLIN_1_9)
//    }
//}

metro {
    interop {
        includeDagger(includeJavax = true)
        includeAnvilForDagger(includeJavax = true)
    }
}

dependencies {
//    ksp(libs.daggerCompiler)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.dagger)
    implementation(libs.anvilKspAnnotations)
    implementation(libs.androidx.fragment)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}