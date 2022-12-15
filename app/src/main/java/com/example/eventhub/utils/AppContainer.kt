package com.example.eventhub.utils

import android.content.Context
import com.example.eventhub.feature_homescreen.data.EventDatabase
import com.example.eventhub.feature_homescreen.data.EventRepositoryImpl
import com.example.eventhub.feature_onboarding.data.UserDatabase
import com.example.eventhub.feature_onboarding.data.UserRepositoryImpl

class AppContainer(context: Context) {
    private var userDB: UserDatabase = UserDatabase.getUserDB(context)

    private var eventDB: EventDatabase = EventDatabase.getEventDB(context)

    val userRepo = UserRepositoryImpl(userDB)

    val eventRepo = EventRepositoryImpl(eventDB)
}