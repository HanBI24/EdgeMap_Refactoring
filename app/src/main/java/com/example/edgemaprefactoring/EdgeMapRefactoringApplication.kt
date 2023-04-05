package com.example.edgemaprefactoring

import android.app.Application
import com.naver.maps.map.NaverMapSdk

class EdgeMapRefactoringApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        NaverMapSdk.getInstance(this).client =
//            NaverMapSdk.NaverCloudPlatformClient(BuildConfig.ClientID)
    }
}