plugins {
   alias(libs.plugins.beattrack.android.library)
    alias(libs.plugins.beattrack.jvm.ktor)

}

android {
    namespace = "com.hg.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.database)

    implementation(libs.timber)
}