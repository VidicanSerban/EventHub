package com.example.eventhub.feature_homescreen.organizeevent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.eventhub.commons.BaseViewModel
import com.example.eventhub.feature_homescreen.data.Event
import com.example.eventhub.feature_homescreen.data.EventRepositoryImpl
import com.example.eventhub.feature_homescreen.usecases.AddEventUseCase
import kotlinx.coroutines.launch

class OrganizeEventViewModel(
    private val eventRepositoryImpl: EventRepositoryImpl
) : BaseViewModel() {
    private var addEventUseCase: AddEventUseCase = AddEventUseCase(eventRepositoryImpl)

    fun addEvent(name: String, date: String, time: String, location: String, description: String){
        viewModelScope.launch {
            addEventUseCase.execute(Event(name, date, time, location, description))
        }
    }

    class OrganizeEventViewModelFactory(
        private val eventRepositoryImpl: EventRepositoryImpl
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return OrganizeEventViewModel(eventRepositoryImpl) as T
        }
    }
}