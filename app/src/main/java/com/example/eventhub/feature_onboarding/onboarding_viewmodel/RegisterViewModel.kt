package com.example.eventhub.feature_onboarding.onboarding_viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eventhub.feature_onboarding.onboarding_data.userRepositoryImplementation
import com.google.android.material.textfield.TextInputEditText

class RegisterViewModel(): ViewModel() {

    private fun validateEmail(email: TextInputEditText): Boolean{
        
        var localemail = email.text.toString()
        
        if(localemail.isEmpty())
        {
            return false
        }
        return true
    }
    private fun validateName(name: TextInputEditText): Boolean{
        
        var localname = name.text.toString()
        
        if(localname.isEmpty())
        {
            //Toast.makeText(applicationContext, "Please enter name", Toast.LENGTH_LONG).show()
            return false
        }
        //else Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
        return true
    }
    private fun validatePassword(pass: TextInputEditText): Boolean{
        
        var password = pass.text.toString()
        
        if(password.isEmpty())
        {
            //oast.makeText(applicationContext, "Please enter password", Toast.LENGTH_LONG).show()
            return false
        }
        //else Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
        return true
    }
    private fun samePassword(pass: TextInputEditText, confirmpass: TextInputEditText): Boolean{

        var passconfirm = confirmpass.text.toString()
        var password = pass.text.toString()
        
        if(passconfirm.isEmpty())
        {
            //Toast.makeText(applicationContext, "Please enter password", Toast.LENGTH_LONG).show()
            return false
        }
        else if(passconfirm.equals(password)){
                    //Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
                    return true
                }
                else
                {
                    //Toast.makeText(applicationContext, "Password does not match", Toast.LENGTH_SHORT).show()
                    return false
                }
    }

    class RegisterViewModelFactory() : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RegisterViewModel() as T        }
    }
}
