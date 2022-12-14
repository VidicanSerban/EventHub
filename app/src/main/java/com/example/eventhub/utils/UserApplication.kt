package com.example.eventhub.utils

import android.app.Application
import android.content.Context

class UserApplication: Application() {

    lateinit var myContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        myContainer = AppContainer(applicationContext)
    }
}