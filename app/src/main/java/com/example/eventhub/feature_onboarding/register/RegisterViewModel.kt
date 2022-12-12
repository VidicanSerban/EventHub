package com.example.eventhub.feature_onboarding.register

import android.util.Log
import android.util.Patterns.EMAIL_ADDRESS
import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.eventhub.commons.BaseViewModel
import com.example.eventhub.feature_onboarding.data.AddUserUseCase
import com.example.eventhub.feature_onboarding.data.UserRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.regex.Pattern


class RegisterViewModel(
    private val userRepositoryImpl: UserRepositoryImpl
): BaseViewModel() {


    private val _viewState = MutableStateFlow(ViewState())
    val viewState = _viewState.asStateFlow()
    private var registerUserUseCase: AddUserUseCase = AddUserUseCase(userRepositoryImpl)

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
