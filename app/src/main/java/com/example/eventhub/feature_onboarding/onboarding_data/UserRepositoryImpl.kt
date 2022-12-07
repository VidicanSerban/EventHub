package com.example.eventhub.feature_onboarding.onboarding_data

class UserRepositoryImpl : UserRepository {
//    override fun getUserFromFirestore(id: String): Flow<User?>{
//        return firestoreDB.collection("users")
//            .document(id)
//            .snapshots().map{ it.toObject<User>()}
//    }
//
//    override fun addUserToFirestore(email: String, password: String): Flow<Response<User?>?>{
//        return firestoreDB.collection("users")
//            .add(hashMapOf("email" to email, "password" to password))
//            .result
//            .snapshots().map{ it.toObject<User>()}
//    }
}