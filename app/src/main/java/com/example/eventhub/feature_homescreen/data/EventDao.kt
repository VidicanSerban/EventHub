package com.example.eventhub.feature_homescreen.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

    @Insert
    suspend fun insertEvent(event: Event)

    @Query("Select * FROM events")
    fun getEvents(): Flow<List<Event>>
}