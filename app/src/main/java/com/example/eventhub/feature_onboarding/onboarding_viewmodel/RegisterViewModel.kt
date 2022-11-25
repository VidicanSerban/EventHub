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
        
        lateinit var email: String
        
        if(email.isEmpty())
        {
            Toast.makeText(applicationContext, "Please enter email address", Toast.LENGTH_LONG).show()
        }
        else Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
        return true
    }
    private fun validateName(): Boolean{
        
        lateinit var name: String
        
        if(name.isEmpty())
        {
            Toast.makeText(applicationContext, "Please enter name", Toast.LENGTH_LONG).show()
        }
        else Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
        return true
    }
    private fun validatePassword(): Boolean{
        
        lateinit var password: String
        
        if(password.isEmpty())
        {
            Toast.makeText(applicationContext, "Please enter password", Toast.LENGTH_LONG).show()
        }
        else Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
        return true
    }
    private fun samePassword(): Boolean{

        lateinit var passconfirm: String
        lateinit var password: String
        
        if(passconfirm.isEmpty())
        {
            Toast.makeText(applicationContext, "Please enter password", Toast.LENGTH_LONG).show()
            return false
        }
        else if(passconfirm.equals(password)){
                    Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
                    return true
                }
                else 
                {
                    Toast.makeText(applicationContext, "Password does not match", Toast.LENGTH_SHORT).show()
                    return false
                }
        return true
    }

    class RegisterViewModelFactory() : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RegisterViewModel() as T        }
    }
}
