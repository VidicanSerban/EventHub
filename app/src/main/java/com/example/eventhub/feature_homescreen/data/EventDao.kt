package com.example.eventhub.feature_homescreen.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface EventDao {

    @Insert
    fun insertEvent(event: Event)
}