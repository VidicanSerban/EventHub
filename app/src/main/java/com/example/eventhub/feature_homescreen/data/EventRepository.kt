package com.example.eventhub.feature_homescreen.data

import android.content.Context
import kotlinx.coroutines.flow.Flow

interface EventRepository {

    fun addEventToRoom(event: Event)

    suspend fun getEventsFromRoom(): Flow<List<Event>>
}