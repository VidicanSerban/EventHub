package com.example.eventhub.feature_onboarding.data

import android.content.Context

class UserRepository(context: Context) {
    var db: UserDao = UserDatabase.createUserDB(context)?.userDao()!!
    
}