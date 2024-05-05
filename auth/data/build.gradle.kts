plugins {
    alias(libs.plugins.beattrack.android.library)
    alias(libs.plugins.beattrack.jvm.ktor)

}

android {
    namespace = "com.hg.auth.data"
}

dependencies {

    implementation(projects.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.data)

}