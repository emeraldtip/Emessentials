plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}
repositories {
	mavenCentral()
    mavenLocal()
    maven { url = uri("https://repo.aikar.co/content/groups/aikar/") }
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}
dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
    compileOnly("org.spigotmc:plugin-annotations:1.2.3-SNAPSHOT")
	annotationProcessor("org.spigotmc:plugin-annotations:1.2.3-SNAPSHOT")
	 implementation("co.aikar:acf-paper:0.5.1-SNAPSHOT")
}
java {
    // Configure the java toolchain. This allows gradle to auto-provision JDK 17 on systems that only have JDK 8 installed for example.
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
base {
	 archivesBaseName = "Emessentials"
}
tasks {
    shadowJar {
        archiveClassifier.set("")
    }
    withType<ProcessResources> {
        filesMatching("plugin.yml") {
            expand(project.properties)
        }
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
    }
    compileJava {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
		
        // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
        // See https://openjdk.java.net/jeps/247 for more information.
        options.release.set(17)
    }
}
tasks.getByName("build").dependsOn("shadowJar")

tasks.register("copyPlugin", Copy::class) {
    from("build/libs/Emessentials.jar")
    into("V:/plugins/")
}

tasks.getByName("copyPlugin").dependsOn("shadowJar")
