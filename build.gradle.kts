plugins {
	alias(libs.plugins.android.application) apply false
	alias(libs.plugins.android.library) apply false
	alias(libs.plugins.detekt)
	alias(libs.plugins.google.firebase.crashlytics) apply false
	alias(libs.plugins.google.services) apply false
	alias(libs.plugins.hilt) apply false
	alias(libs.plugins.kotlin.android) apply false
	alias(libs.plugins.kotlin.kapt) apply false
	alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
}
