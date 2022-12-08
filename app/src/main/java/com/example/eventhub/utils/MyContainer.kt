package com.example.eventhub.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MyContainer {

    val firebase = Firebase.firestore

    val fireauth = FirebaseAuth.getInstance()

    //val firebaseRepo = UserRepositoryImpl(firebase, fireauth)

}