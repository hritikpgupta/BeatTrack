plugins {
    alias(libs.plugins.beattrack.android.library)
}

android {
    namespace = "com.hg.core.notification"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.presentation.ui)
    implementation(projects.core.presentation.designsystem)
}