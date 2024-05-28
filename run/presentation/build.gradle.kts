plugins {
    alias(libs.plugins.beattrack.android.feature.ui)
    alias(libs.plugins.mapsplatform.secrets.plugin)

}

android {
    namespace = "com.hg.run.presentation"
}

dependencies {
    implementation(libs.coil.compose)
    implementation(libs.google.maps.android.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.run.domain)
}