package com.example.eventhub.feature_onboarding.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.eventhub.commons.BaseViewModel
import com.example.eventhub.feature_onboarding.data.User
import com.example.eventhub.feature_onboarding.data.UserRepositoryImpl
import com.example.eventhub.feature_onboarding.usecases.GetCurrentUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userRepositoryImpl: UserRepositoryImpl
): BaseViewModel() {
    private var loginUserUseCase: GetCurrentUserUseCase = GetCurrentUserUseCase(userRepositoryImpl)

    private val _viewState = MutableStateFlow(ViewState())
    val viewState = _viewState.asStateFlow()

    fun loginUser(email: String, password: String){
        viewModelScope.launch {
            loginUserUseCase.execute(email, password).collect{
                _viewState.update {
                    viewState ->  viewState.copy(email = it.email, password = it.password)
                }
            }
        }
    }

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
        private val userRepositoryImpl: UserRepositoryImpl
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(userRepositoryImpl) as T
        }
    }

    data class ViewState(
        val email: String? = null,
        val password: String? = null
    )
}
