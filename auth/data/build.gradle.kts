plugins {
    alias(libs.plugins.beattrack.android.library)
    alias(libs.plugins.beattrack.jvm.ktor)

}

android {
    namespace = "com.hg.auth.datA"
}

dependencies {

    implementation(libs.bundles.koin)

    implementation(projects.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.data)

}