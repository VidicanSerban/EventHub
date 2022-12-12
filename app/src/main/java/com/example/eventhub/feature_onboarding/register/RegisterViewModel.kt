package com.example.eventhub.feature_onboarding.register

import android.util.Patterns.EMAIL_ADDRESS
import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eventhub.commons.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.regex.Pattern


class RegisterViewModel(): BaseViewModel() {

    private val _viewState = MutableStateFlow(ViewState())
    val viewState = _viewState.asStateFlow()

//    init {
//        addUserUseCase = AddUserUseCase(userRepositoryImpl)
//    }
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

    class RegisterViewModelFactory() : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RegisterViewModel() as T
            }

    }
}
