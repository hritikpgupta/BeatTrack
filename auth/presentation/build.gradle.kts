plugins {
    alias(libs.plugins.beattrack.android.feature.ui)
}

android {
    namespace = "com.hg.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}