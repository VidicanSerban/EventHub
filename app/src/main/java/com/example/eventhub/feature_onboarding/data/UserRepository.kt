package com.example.eventhub.feature_onboarding.data

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun addUserToRoom(user: User)

    suspend fun getUserFromRoom(email: String): Flow<User>

}