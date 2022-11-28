package com.example.eventhub.feature_onboarding.onboarding_viewmodel

import android.R.attr.password
import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Matcher
import java.util.regex.Pattern


class RegisterViewModel(): ViewModel() {

    fun validateEmail(email: String): Boolean{
        return EMAIL_ADDRESS.matcher(email).matches()
    }
    fun validateName(name: String): Boolean{

        if(name.isEmpty())
        {
            return false
        }
        return true
    }
    fun validatePassword(pass: String): Boolean{
        val PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@\$%^&*-]).{8,}\$")
        return PASSWORD_PATTERN.matcher(pass).matches()
    }
    fun samePassword(pass: String, confirmpass: String): Boolean{
        if(confirmpass.isEmpty() || !confirmpass.equals(pass)) {
            //error("Introduceti inca odata parola sau parolele nu corespund")
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
