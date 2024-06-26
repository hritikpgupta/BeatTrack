plugins {
    alias(libs.plugins.beattrack.android.library)
    alias(libs.plugins.beattrack.jvm.ktor)

}

android {
    namespace = "com.hg.run.network"
}

dependencies {
    implementation(libs.bundles.koin)
    implementation(projects.core.domain)
    implementation(projects.core.data)

}