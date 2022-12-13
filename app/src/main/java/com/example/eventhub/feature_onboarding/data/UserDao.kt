package com.example.eventhub.feature_onboarding.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface UserDao {

    @Insert
    suspend fun addUserToFirestore(email: String, password: String, name: String): Flow<Response<Boolean>>

    @Query("SELECT * FROM users")
    suspend fun getUserFromFirestore(id: String): Flow<Response<User?>>
}