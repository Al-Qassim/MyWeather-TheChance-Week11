package com.example.myweather.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MyWeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR) // Or Level.DEBUG, Level.INFO based on your needs
            androidContext(this@MyWeatherApplication)
            modules(dependencies)
        }
    }
}