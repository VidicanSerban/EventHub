package com.example.eventhub.feature_onboarding.register

import android.util.Log
import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.eventhub.commons.BaseViewModel
import com.example.eventhub.feature_onboarding.data.RegisterUserUseCase
import com.example.eventhub.feature_onboarding.data.UserRepositoryImpl
import kotlinx.coroutines.launch
import java.util.regex.Pattern


class RegisterViewModel(
    private val userRepositoryImpl: UserRepositoryImpl
): BaseViewModel() {
    private var registerUserUseCase: RegisterUserUseCase = RegisterUserUseCase(userRepositoryImpl)

    fun registerUser(email: String, password: String, name: String){
        viewModelScope.launch {
            registerUserUseCase.execute(email, password, name)
                .collect{
                    Log.d("RegisterViewModel", "Response $it")
                }
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
        val PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@\$%^&*-]).{8,}\$")
        return PASSWORD_PATTERN.matcher(pass).matches()
    }

    fun samePassword(pass: String, confirmpass: String): Boolean{
        if(confirmpass.isEmpty() || !confirmpass.equals(pass)) {
            return false
        }
        return true
    }

    class RegisterViewModelFactory(private val userRepositoryImpl: UserRepositoryImpl) : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RegisterViewModel(userRepositoryImpl) as T
            }

    }
}
