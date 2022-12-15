package com.example.eventhub.utils

import android.app.Application

class AppApplication: Application() {

    lateinit var myContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        myContainer = AppContainer(applicationContext)
    }
}