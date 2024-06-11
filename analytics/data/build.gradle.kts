plugins {
    alias(libs.plugins.beattrack.android.library)
    alias(libs.plugins.beattrack.android.room)

}

android {
    namespace = "com.hg.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.koin)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
}