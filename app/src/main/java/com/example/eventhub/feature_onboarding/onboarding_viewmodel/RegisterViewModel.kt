package com.example.eventhub.feature_onboarding.onboarding_viewmodel

import android.R.attr.password
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Matcher
import java.util.regex.Pattern


class RegisterViewModel(): ViewModel() {

    private fun validateEmail(email: TextInputEditText): Boolean{
        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        var localemail = email.text.toString()
        return EMAIL_ADDRESS_PATTERN.matcher(localemail).matches()
    }
    private fun validateName(name: TextInputEditText): Boolean{
        
        var localname = name.text.toString()
        
        if(localname.isEmpty())
        {
            return false
        }
        return true
    }
    private fun validatePassword(pass: TextInputEditText): Boolean{
        val PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$")
        var password = pass.text.toString()
        return PASSWORD_PATTERN.matcher(password).matches()
    }
    private fun samePassword(pass: TextInputEditText, confirmpass: TextInputEditText): Boolean{

        var passconfirm = confirmpass.text.toString()
        var password = pass.text.toString()

        if(passconfirm.isEmpty())
        {
            return false
        }
        else if(!passconfirm.equals(password)) return false

        return true
    }

    class RegisterViewModelFactory() : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RegisterViewModel() as T        }
    }
}
