package com.example.eventhub.feature_onboarding.onboarding_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eventhub.feature_onboarding.onboarding_data.userRepositoryImplementation

class OnboardingViewModel(userRepositoryImplementation: userRepositoryImplementation): ViewModel() {

    class OnboardingViewModelFactory(
        private val userRepositoryImplementation: userRepositoryImplementation
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return OnboardingViewModel(userRepositoryImplementation) as T        }
    }
}