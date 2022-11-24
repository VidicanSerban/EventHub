package com.example.eventhub.feature_onboarding.onboarding_viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eventhub.feature_onboarding.onboarding_data.userRepositoryImplementation

class RegisterViewModel(): ViewModel() {

    private val emailLiveData = MutableLiveData<String>()
    private val nameLiveData = MutableLiveData<String>()
    private val passwordLiveData = MutableLiveData<String>()
    private val passwordconfirmLiveData = MutableLiveData<String>()

    private fun validateEmail(): Boolean{

        return true
    }
    private fun validateName(): Boolean{

        return true
    }
    private fun validatePassword(): Boolean{

        return true
    }
    private fun samePassword(): Boolean{

        return true
    }

    class RegisterViewModelFactory() : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RegisterViewModel() as T        }
    }
}