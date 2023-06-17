package com.github.demo

import android.app.Application
import com.github.demo.core.data.ThemeRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ThemeRepository.init(this)
    }
}
