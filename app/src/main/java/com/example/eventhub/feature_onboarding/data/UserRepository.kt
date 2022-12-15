package com.example.eventhub.feature_onboarding.data

import kotlinx.coroutines.flow.Flow
import java.net.PasswordAuthentication

interface UserRepository {
    suspend fun addUserToRoom(user: User)

    fun getUserFromRoom(email: String, password: String): Flow<User>

}