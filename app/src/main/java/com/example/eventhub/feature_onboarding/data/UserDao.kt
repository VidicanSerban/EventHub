package com.example.eventhub.feature_onboarding.data

import androidx.room.Dao
import androidx.room.Insert
import kotlinx.coroutines.flow.Flow
@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

//    suspend fun getUserFromFirestore(id: String): Flow<Response<User?>>
//
//    suspend fun addUserToFirestore(email: String, password: String, name: String): Flow<Response<Boolean>>
}