plugins {
    alias(libs.plugins.beattrack.android.library)
    alias(libs.plugins.beattrack.android.room)

}

android {
    namespace = "com.hg.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)
    implementation(libs.bundles.koin)
    implementation(projects.core.domain)
}