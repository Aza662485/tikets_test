plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.ticket"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

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
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core:core_utils"))
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("javax.inject:javax.inject:1")
    
    //hilt
    implementation(DaggerHilt.android)
    kapt(DaggerHilt.compiler)

    //retrofit
    implementation(Retrofit.retrofit)
    implementation (Retrofit.json)
    //okkhtp
    implementation(Okhttp.interceptor)
    implementation(Okhttp.okhttp)


    //navigation
    implementation (Navigation.navigationFragment)
    implementation (Navigation.navigationKtx)

    //hilt
    implementation(DaggerHilt.android)
    kapt(DaggerHilt.compiler)


    //glide
    implementation (Glide.glide)
    implementation (AnnotationProcessor.annotationProcessor)

    //Coroutines
    implementation (Coroutines.coroutines)

    //Viewbindingpropertydelegate
    implementation (Viewbindingpropertydelegate.viewbindingpropertydelegate)
}