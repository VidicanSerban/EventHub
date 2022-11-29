package com.example.eventhub.feature_onboarding.onboarding_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eventhub.feature_onboarding.onboarding_data.UserRepositoryImplementation

class OnboardingViewModel(userRepositoryImplementation: UserRepositoryImplementation): ViewModel() {

    class OnboardingViewModelFactory(
        private val userRepositoryImplementation: UserRepositoryImplementation
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return OnboardingViewModel(userRepositoryImplementation) as T        }
    }
}