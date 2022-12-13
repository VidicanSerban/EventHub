package com.example.eventhub.utils

import com.example.eventhub.feature_onboarding.data.UserRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AppContainer {

    val firebase = Firebase.firestore

    val fireauth = FirebaseAuth.getInstance()

    val userRepo = UserRepositoryImpl()
}