package com.example.alignhoroscope

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HoroscopeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // This is where you can initialize libraries, setup logging, etc.
    }
}
