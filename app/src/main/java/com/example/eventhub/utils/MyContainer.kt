package com.example.eventhub.utils

import com.example.eventhub.feature_onboarding.onboarding_data.UserRepository
import com.example.eventhub.feature_onboarding.onboarding_data.UserRepositoryImplementation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MyContainer {
    var firebaseRepo: UserRepository = UserRepositoryImplementation()

    private lateinit var firebase: FirebaseFirestore

    private lateinit var fireauth: FirebaseAuth
}