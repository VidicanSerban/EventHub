package com.example.eventhub.feature_homescreen.organizeevent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OrganizeEventViewModel : ViewModel() {

    class OrganizeEventViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return OrganizeEventViewModel() as T
        }
    }
}