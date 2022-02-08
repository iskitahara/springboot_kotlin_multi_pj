pluginManagement {
    repositories {
        mavenCentral()

        maven("https://plugins.gradle.org/m2/")
    }
}
rootProject.name = "api-base"

include(":api")
include(":infra-order-db")
include(":infra-item-api")
include(":application")
include(":domain")
