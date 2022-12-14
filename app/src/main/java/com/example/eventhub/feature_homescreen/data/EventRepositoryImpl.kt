package com.example.eventhub.feature_homescreen.data

import kotlinx.coroutines.flow.Flow

class EventRepositoryImpl(
    private var eventDB: EventDatabase
): EventRepository {
    override fun addEventToRoom(event: Event) {
        return eventDB.eventDao().insertEvent(event)
    }

    override suspend fun getEventsFromRoom(): Flow<List<Event>> {
        return eventDB.eventDao().getEvents()
    }
}