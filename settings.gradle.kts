pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins{
        id("org.gradle.toolchains.foojay-resolver-convention") version("0.5.0")
        id("org.jetbrains.kotlin.jvm") version "1.9.0"
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "IMovie"
include(":app")
include(":entities")
include(":firebase")
include(":local")
include(":remote")
include(":repository")
include(":ui")
include(":usecase")
include(":viewmodels")
