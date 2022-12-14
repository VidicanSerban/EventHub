package com.example.eventhub.feature_onboarding.data

import android.util.Log
import androidx.annotation.WorkerThread
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private var userDB: UserDatabase
) : UserRepository {

    @WorkerThread
    override fun addUserToRoom(user: User) {
        return userDB.userDao().registerUser(user)
    }

    override suspend fun getUserFromRoom(email: String): Flow<User> {
        return userDB.userDao().getUser(email)
    }
}