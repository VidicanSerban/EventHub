package com.example.eventhub.feature_homescreen.usecases

import com.example.eventhub.feature_homescreen.data.Event
import com.example.eventhub.feature_homescreen.data.EventRepositoryImpl

class AddEventUseCase constructor(
    private val eventrepo: EventRepositoryImpl
    ) {
    suspend fun execute(event: Event){
        return eventrepo.addEventToRoom(event)
    }
}