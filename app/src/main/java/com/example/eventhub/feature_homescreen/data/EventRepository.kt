package com.example.eventhub.feature_homescreen.data

import android.content.Context
import kotlinx.coroutines.flow.Flow

interface EventRepository {

    suspend fun addEventToRoom(event: Event)

    fun getEventsFromRoom(): Flow<List<Event>>
}