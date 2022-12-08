package com.example.eventhub.feature_onboarding.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eventhub.feature_onboarding.data.UserRepositoryImpl

class LoginViewModel(userRepositoryImplementation: UserRepositoryImpl): ViewModel() {

    class LoginViewModelFactory(
    private val userRepositoryImplementation: UserRepositoryImpl
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(userRepositoryImplementation) as T
        }
    }
}