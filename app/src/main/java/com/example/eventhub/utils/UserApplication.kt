package com.example.eventhub.utils

import android.app.Application

class UserApplication: Application() {

    lateinit var myContainer: MyContainer
    override fun onCreate() {
        super.onCreate()
        myContainer = MyContainer()
    }

}