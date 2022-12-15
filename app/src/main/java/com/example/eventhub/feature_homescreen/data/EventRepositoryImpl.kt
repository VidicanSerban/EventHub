package com.example.eventhub.feature_homescreen.data

import kotlinx.coroutines.flow.Flow

class EventRepositoryImpl(
    private var eventDB: EventDatabase
): EventRepository {
    override suspend fun addEventToRoom(event: Event) {
        return eventDB.eventDao().insertEvent(event)
    }

    override fun getEventsFromRoom(): Flow<List<Event>> {
        return eventDB.eventDao().getEvents()
    }
}