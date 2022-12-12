package com.example.eventhub.feature_onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eventhub.commons.BaseViewModel
import com.example.eventhub.feature_onboarding.data.UserRepositoryImpl

class OnboardingViewModel(userRepositoryImplementation: UserRepositoryImpl): BaseViewModel() {

    class OnboardingViewModelFactory(private val userRepositoryImplementation: UserRepositoryImpl
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return OnboardingViewModel(userRepositoryImplementation) as T        }
    }
}