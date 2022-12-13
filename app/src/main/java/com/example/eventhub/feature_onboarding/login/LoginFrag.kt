package com.example.eventhub.feature_onboarding.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.eventhub.R
import com.example.eventhub.feature_homescreen.activity.HomePage
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFrag : Fragment(R.layout.fragment_login) {
    lateinit var viewModel: LoginViewModel
    lateinit var btnLogin: Button
    lateinit var registerBtn: TextView
    lateinit var textEmail: TextInputEditText
    lateinit var textPassword: TextInputEditText
    private lateinit var errorEmail: TextInputLayout
    private lateinit var errorPassword: TextInputLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin = view.findViewById(R.id.btnLogin)
        registerBtn = view.findViewById(R.id.tvLoginClicky)
        textEmail = view.findViewById(R.id.tietEmailLogin)
        textPassword = view.findViewById(R.id.tietPassLogin)
        errorEmail = view.findViewById(R.id.tilEmail)
        errorPassword = view.findViewById(R.id.tilPassword)

        initListeners()
        initViewModel()
    }

    private fun initListeners(){
        registerBtn.setOnClickListener{
            findNavController().popBackStack()
        }

        btnLogin.setOnClickListener{
            if (!viewModel.emptyEmail(textEmail.text.toString())){
                textEmail.requestFocus()
                errorEmail.isErrorEnabled = true
                errorEmail.error = getString(R.string.emailerror)
                textEmail.setBackgroundResource(R.drawable.text_input_background_error)
                textPassword.setBackgroundResource(R.drawable.text_input_background)
                errorPassword.error = null
                errorPassword.isErrorEnabled = false
            }
            else if (!viewModel.emptyPass(textPassword.text.toString())){
                textEmail.setBackgroundResource(R.drawable.text_input_background)
                errorEmail.error = null
                textEmail.clearFocus()
                textPassword.requestFocus()
                errorEmail.isErrorEnabled = false
                errorPassword.isErrorEnabled = true
                errorPassword.error = getString(R.string.passerror)
                textPassword.setBackgroundResource(R.drawable.text_input_background_error)
            }
            else{
                textPassword.setBackgroundResource(R.drawable.text_input_background)
                errorPassword.error = null
                errorPassword.isErrorEnabled = false
                textPassword.clearFocus()
                val intent = Intent (getActivity(), HomePage::class.java)
                getActivity()?.startActivity(intent)
            }
        }
    }

    private fun initViewModel() {
        val viewModelFactory: LoginViewModel.LoginViewModelFactory =
            LoginViewModel.LoginViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]
    }
}