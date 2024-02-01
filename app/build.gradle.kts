import com.android.build.api.dsl.Packaging
import java.util.Properties

plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.google.firebase.crashlytics)
	alias(libs.plugins.google.services)
	alias(libs.plugins.hilt)
	alias(libs.plugins.detekt)
	alias(libs.plugins.kotlin.kapt)
}

android {
	namespace = "com.maasbodev.marvelcomicsmd"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.maasbodev.marvelcomicsmd"
		minSdk = 26
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}

		val p = Properties()
		p.load(project.rootProject.file("local.properties").reader())
		val priv: String = p.getProperty("MARVEL_PRIVATE_KEY")
		val pub: String = p.getProperty("MARVEL_PUBLIC_KEY")
		buildConfigField("String", "MARVEL_PRIVATE_KEY", "\"$priv\"")
		buildConfigField("String", "MARVEL_PUBLIC_KEY", "\"$pub\"")
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = "17"
	}
	buildFeatures {
		compose = true
		buildConfig = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.8"
	}
	fun Packaging.() {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	val composeBom = platform(libs.androidx.compose.bom)
	implementation(composeBom)
	androidTestImplementation(composeBom)

	val googleFirebaseBom = platform(libs.google.firebase.bom)
	implementation(googleFirebaseBom)

	implementation(libs.androidx.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.bundles.accompanist)
	implementation(libs.androidx.annotation)
	implementation(libs.bundles.compose)
	implementation(libs.bundles.compose.bom)
	implementation(libs.bundles.compose.integration)
	implementation(libs.bundles.google.firebase.bom)

	implementation(libs.hilt)
	kapt(libs.hilt.compiler)
	implementation(libs.hilt.navigation)

	implementation(libs.coil)

	implementation(libs.bundles.retrofit)

	implementation(libs.arrow.core)

	testImplementation(libs.junit)

	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(libs.androidx.compose.ui.test.junit4)

	debugImplementation(libs.androidx.compose.ui.tooling)
	debugImplementation(libs.androidx.compose.ui.test.manifest)
}

// Allow references to generated code
kapt {
	correctErrorTypes = true
}
