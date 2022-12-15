package com.example.eventhub.feature_onboarding.data

import android.util.Log
import androidx.annotation.WorkerThread
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private var userDB: UserDatabase
) : UserRepository {

    override suspend fun addUserToRoom(user: User) {
        return userDB.userDao().registerUser(user)
    }

    override fun getUserFromRoom(email: String, password: String): Flow<User> {
        return userDB.userDao().getUser(email, password)
    }
}