package com.example.eventhub.feature_homescreen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeFragmentViewModel : ViewModel() {

    class HomeFragmentViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeFragmentViewModel() as T
        }

    }
}