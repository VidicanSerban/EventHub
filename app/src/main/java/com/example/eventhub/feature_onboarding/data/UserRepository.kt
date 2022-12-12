package com.example.eventhub.feature_onboarding.data

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserFromFirestore(id: String): Flow<Response<User?>>
    suspend fun addUserToFirestore(email: String, password: String): Flow<Response<User?>>

}