package com.example.eventhub.feature_homescreen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.eventhub.commons.BaseViewModel
import com.example.eventhub.feature_homescreen.data.Event
import com.example.eventhub.feature_homescreen.data.EventRepositoryImpl
import com.example.eventhub.feature_homescreen.usecases.GetAllEventsUseCase
import com.google.protobuf.Empty
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeFragmentViewModel(
    private val eventRepositoryImpl: EventRepositoryImpl
) : BaseViewModel() {
    private val getAllEventsUseCase: GetAllEventsUseCase = GetAllEventsUseCase(eventRepositoryImpl)

    private val _viewState = MutableStateFlow(ViewState())
    val viewState = _viewState.asStateFlow()

    fun getAllTheEvents(){
        viewModelScope.launch {
            getAllEventsUseCase.execute().collect{
                _viewState.update {
                    viewState ->  viewState.copy(list = it)
                }
            }
        }
    }
    init{
        getAllTheEvents()
    }

    class HomeFragmentViewModelFactory(
        private val eventRepositoryImpl: EventRepositoryImpl
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeFragmentViewModel(eventRepositoryImpl) as T
        }
    }

    data class ViewState(
        val list: List<Event>? = emptyList()
    )
}