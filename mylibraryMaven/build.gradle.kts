plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.example.mylibrarymaven"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.example.mylibrarymaven"
            artifactId = "mylibrarymaven"
            version = "0.0.2"
           // from(components["kotlin"])
            afterEvaluate {
                from(components["release"])
            }
        }
        repositories {
            maven {
                name = "mylibrarymaven"
                url = uri("${project.buildDir}/repo")
            }
        }
        withType<MavenPublication> {
            pom {
                packaging = "com.example.mylibrarymaven"
                name.set("mylibrarymaven")
                description.set("Project Library Maven")
               // url.set("fooyee.com")
                licenses {
                    license {
                        name.set("MIT license")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                issueManagement {
                    system.set("Github")
                    url.set("https://github.com/rahulvis/mavenupload/issues")
                }
                scm {
                    connection.set("scm:git://github.com/rahulvis/mavenupload.git")
                    developerConnection.set("scm:git:git@github.com:rahulvis/mavenupload.git")//git@github.com:rahulvis/mavenupload.git
                    url.set("https://github.com/rahulvis/mavenupload")
                }
                developers {
                    developer {
                        name.set("rahul")
                        email.set("rahul.via@gmail.com")

                    }
                }
            }
        }
    }
}
/*publishing{
    publications {
        create<MavenPublication>("mavenupload") {
            groupId = "org.gradle.sample"
            artifactId = "library"
            version = "1.1"
            artifact("$buildDir/output/aar/mylibraryMaven-release.aar")
            // from(components["java"])//mylibraryMaven-release.aar
        }
    }
    repositories{
        maven {
            url =uri("https://gitlab.com/rahul.vis/mavenproject")
            credentials {
                username = "rahul.via@gmail.com"
                password = "Secure1@zero"
            }
        }
    }
}*/
/*
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "master.mylibraryMaven"
            artifactId = "library"
            version = "0.001"
            artifact("$buildDir/outputs/aar/mylibraryMaven-release.aar")
        }
    }
    repositories {
        maven {
            url = uri("https://github.com/rahulvis/mavenupload")
            credentials {
                username = "rahul.via@gmail.com"
                password = "Secure1@zero"
            }
        }
    }
}
*/



dependencies {
   // implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //compileOnly(files("libs/protean-esign-v-2.3.aar"))
    compileOnly(files("libs/protean-esign-v-2.3.aar"))
    implementation("com.android.volley:volley:1.2.1")

}