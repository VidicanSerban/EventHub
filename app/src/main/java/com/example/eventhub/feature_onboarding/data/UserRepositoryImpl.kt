package com.example.eventhub.feature_onboarding.data

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class UserRepositoryImpl
    (private val fireAuth: FirebaseAuth,
     private val firestoreDB: FirebaseFirestore) : UserRepository {

    override suspend fun getUserFromFirestore(id: String): Flow<Response<User?>> = callbackFlow{
        val document = firestoreDB.collection("users")
            .document(id)

        val subscription = document.addSnapshotListener{
            snapshot, error ->
            val response = if(snapshot!=null) Response.Success(snapshot.toObject(User::class.java))
            else Response.Error(error.toString())
            trySend(response)
            }
        awaitClose{subscription.remove()}
    }

    override suspend fun addUserToFirestore(email: String, password: String, name: String): Flow<Response<Boolean>> = callbackFlow{
        fireAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener{
            Log.d("RegisterUser", "Created user successfully")
            val user = hashMapOf(
                "email" to email,
                "password" to password,
                "name" to name
            )
            firestoreDB.collection("users")
                .add(user)
                .addOnSuccessListener { trySend(Response.Success(true)) }
                .addOnFailureListener {
                    Log.d("LoginUser", "Failed to add user to firestore")
                    trySend(Response.Error(it.toString())) }

        }.addOnFailureListener{
            Log.d("RegisterUSer", "Failed to create user")
            trySend(Response.Error(it.toString()))
        }
        awaitClose{channel.close()}
    }
}