package com.example.eventhub.feature_onboarding.register

import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.eventhub.commons.BaseViewModel
import com.example.eventhub.feature_onboarding.usecases.RegisterUserUseCase
import com.example.eventhub.feature_onboarding.data.User
import com.example.eventhub.feature_onboarding.data.UserRepositoryImpl
import kotlinx.coroutines.launch
import java.util.regex.Pattern


class RegisterViewModel(
    private val userRepositoryImpl: UserRepositoryImpl
): BaseViewModel() {
    private var registerUserUseCase: RegisterUserUseCase = RegisterUserUseCase(userRepositoryImpl)

    fun registerUser(email: String, name: String, password: String){
        viewModelScope.launch {
            registerUserUseCase.execute(User(email, name, password))
        }
    }

    fun validateName(name: String): Boolean{

        if(name.isEmpty())
        {
            return false
        }
        return true
    }

    fun validateEmail(email: String): Boolean{
        return EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validatePassword(pass: String): Boolean{
        val passwordpattern = Pattern.compile(
            "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@\$%^&*-]).{8,}\$")
        return passwordpattern.matcher(pass).matches()
    }

    fun samePassword(pass: String, confirmpass: String): Boolean{
        if(confirmpass.isEmpty() || !confirmpass.equals(pass)) {
            return false
        }
        return true
    }

    class RegisterViewModelFactory(
        private val userRepositoryImpl: UserRepositoryImpl
        ) : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RegisterViewModel(userRepositoryImpl) as T
            }
    }
}
