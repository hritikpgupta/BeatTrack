plugins {
    alias(libs.plugins.beattrack.android.feature.ui)
}

android {
    namespace = "com.hg.analytics.presentation"

}

dependencies {
    implementation(projects.analytics.domain)
}