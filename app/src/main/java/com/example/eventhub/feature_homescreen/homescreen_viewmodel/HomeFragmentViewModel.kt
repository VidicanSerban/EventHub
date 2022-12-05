package com.example.eventhub.feature_homescreen.homescreen_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eventhub.feature_onboarding.onboarding_viewmodel.RegisterViewModel

class HomeFragmentViewModel : ViewModel() {
    class HomeFragmentViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeFragmentViewModel() as T
        }

    }
}