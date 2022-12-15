package com.example.eventhub.feature_homescreen.usecases

import com.example.eventhub.feature_homescreen.data.Event
import com.example.eventhub.feature_homescreen.data.EventRepositoryImpl
import kotlinx.coroutines.flow.Flow

class GetAllEventsUseCase constructor(
    private val eventrepo: EventRepositoryImpl
    ) {
    fun execute():Flow<List<Event>>{
        return eventrepo.getEventsFromRoom()
    }
}