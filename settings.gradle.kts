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

rootProject.name = "tikets_test"
include(":app")
include(":core:core_utils")
include(":hotel")
include(":profile")
include(":ticket")
include(":subscriptions")
include(":breafly")
