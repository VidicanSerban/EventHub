package com.example.eventhub.feature_onboarding.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eventhub.feature_onboarding.data.UserRepositoryImpl
import java.util.regex.Pattern

class LoginViewModel(): ViewModel() {

    fun emptyEmail(email: String): Boolean{

        if(email.isEmpty())
        {
            return false
        }
        return true
    }

    fun emptyPass(pass: String): Boolean{
        if(pass.isEmpty())
        {
            return false
        }
        return true
    }

    class LoginViewModelFactory(
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel() as T
        }
    }
}
