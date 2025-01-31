import net.fabricmc.loom.task.AbstractRunTask

plugins {
    alias(libs.plugins.architectury)
    alias(libs.plugins.architectury.loom)
}

architectury {
    forge()
}

dependencies {
    minecraft(libs.minecraft20)
    mappings(variantOf(libs.yarn.mapping20) {
        classifier("v2")
    })
    forge(libs.forge47)

    implementation(project(":preloading-callbacks")) {
        isTransitive = false
    }
}

tasks {
    jar {
        manifest.attributes(
            "FMLModType" to "LANGPROVIDER"
        )
    }
}
