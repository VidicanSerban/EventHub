package com.example.eventhub.utils

import com.example.eventhub.feature_onboarding.onboarding_data.UserRepository
import com.example.eventhub.feature_onboarding.onboarding_data.UserRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage

class MyContainer {
    val firebase = Firebase.firestore

    val fireauth = FirebaseAuth.getInstance()

    //val firebaseRepo = UserRepositoryImpl(firebase, fireauth)

}