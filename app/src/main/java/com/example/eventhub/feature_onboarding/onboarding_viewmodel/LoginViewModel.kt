package com.example.eventhub.feature_onboarding.onboarding_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoginViewModel(): ViewModel() {

    class LoginViewModelFactory(
        //private val userRepositoryImplementation: userRepositoryImplementation
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel() as T        }
    }
}
