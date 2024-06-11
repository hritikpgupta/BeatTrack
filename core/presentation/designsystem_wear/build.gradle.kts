plugins {
    alias(libs.plugins.beattrack.android.library.compose)
}

android {
    namespace = "com.hg.core.presentation.designsystem_wear"

    defaultConfig {
        minSdk = 30
    }
}

dependencies {
    api(projects.core.presentation.designsystem)

    implementation(libs.androidx.wear.compose.material)
}