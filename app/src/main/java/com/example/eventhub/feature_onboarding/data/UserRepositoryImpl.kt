package com.example.eventhub.feature_onboarding.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.snapshots
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

abstract class UserRepositoryImpl @Inject constructor
    (private val fireAuth: FirebaseAuth,
     private val firestoreDB: FirebaseFirestore) : UserRepository {
    
//    override suspend fun getUserFromFirestore(id: String): Flow<Response<User>> {
//        try {
//            emit(Response.Loading)
//            return firestoreDB.collection("users")
//                .document(id)
//                .snapshots().map { it.toObject() }
//        }
//        catch (e: Exception){
//            emit(Error(e.message?: e.toString()))
//        }
//    }
//
//    override suspend fun addUserToFirestore(email: String, password: String): Flow<Response<User>>{
//        try {
//            return firestoreDB.collection("users")
//                .add(hashMapOf("email" to email, "password" to password))
//                .result
//                .snapshots().map{ it.toObject()}
//        }
//        catch (e: Exception){
//            emit(Error(e.message?: e.toString()))
//        }
//    }

//    override suspend fun addUserToFirestore(
//        email: String,
//        password: String
//    ) = flow<Response<User>> {
//        emit(Response.Loading)
//        val result = fireAuth.createUserWithEmailAndPassword(email, password).await()
//        if (result != null) {
//            emit(Response.Success(result.result?.user))
//        } else {
//            emit(Response.Error(result.exception))
//
//    }
}