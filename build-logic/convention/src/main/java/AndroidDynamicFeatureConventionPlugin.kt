import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.DynamicFeatureExtension
import com.hg.convention.ExtensionType
import com.hg.convention.addUiLayerDependencies
import com.hg.convention.configureAndroidCompose
import com.hg.convention.configureBuildType
import com.hg.convention.configureKotlinAndroid
import com.hg.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidDynamicFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.apply {
                apply("com.android.dynamic-feature")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<DynamicFeatureExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
                configureBuildType(this, ExtensionType.DYNAMIC_FEATURE)
            }
            dependencies {
                addUiLayerDependencies(target)
                "testImplementation"(kotlin("test"))
            }
        }
    }
}