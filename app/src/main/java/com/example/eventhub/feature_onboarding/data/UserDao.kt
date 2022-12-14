package com.example.eventhub.feature_onboarding.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface UserDao {

    @Insert
    fun registerUser(user: User)

    @Query("SELECT * FROM users WHERE email = :email")
    fun getUser(email: String): Flow<User>
}