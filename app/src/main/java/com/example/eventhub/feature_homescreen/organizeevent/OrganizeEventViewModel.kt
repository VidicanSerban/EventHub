package com.example.eventhub.feature_homescreen.organizeevent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eventhub.commons.BaseViewModel

class OrganizeEventViewModel : BaseViewModel() {

    class OrganizeEventViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return OrganizeEventViewModel() as T
        }
    }
}