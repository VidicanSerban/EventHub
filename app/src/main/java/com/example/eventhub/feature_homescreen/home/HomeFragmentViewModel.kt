package com.example.eventhub.feature_homescreen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eventhub.commons.BaseViewModel

class HomeFragmentViewModel : BaseViewModel() {

    class HomeFragmentViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeFragmentViewModel() as T
        }

    }
}