pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
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
