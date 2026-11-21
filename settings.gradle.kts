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
        // Repositorio JitPack: necesario para poder descargar MPAndroidChart.
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "WalletView"
include(":app")
