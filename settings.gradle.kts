pluginManagement {
    repositories {
        flatDir {
            dirs("libs")
        }
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        flatDir {
            dirs("libs")
        }
        google()
        mavenCentral()
    }
}

rootProject.name = "MavenPublished"
include(":app")
include(":mylibraryMaven")
