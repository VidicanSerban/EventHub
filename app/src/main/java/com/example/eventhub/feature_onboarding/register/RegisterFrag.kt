package com.example.eventhub.feature_onboarding.register

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
import com.example.eventhub.utils.AppContainer
import com.example.eventhub.utils.AppApplication
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterFrag : Fragment(R.layout.fragment_register) {
    private lateinit var appContainer: AppContainer
    lateinit var viewModel: RegisterViewModel

    private lateinit var loginBtn: TextView
    lateinit var registerBtn: Button
    lateinit var textName: TextInputEditText
    private lateinit var textEmail: TextInputEditText
    lateinit var textPassword: TextInputEditText
    lateinit var textConfirm: TextInputEditText
    lateinit var errorName: TextInputLayout
    private lateinit var errorEmail: TextInputLayout
    private lateinit var errorPassword:TextInputLayout
    lateinit var errorConfirm: TextInputLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appContainer = (requireActivity().application as AppApplication).myContainer
        loginBtn = view.findViewById(R.id.tvRegisterClicky)
        registerBtn = view.findViewById(R.id.btnRegister)
        textName = view.findViewById(R.id.tietName)
        textEmail = view.findViewById(R.id.tietEmail)
        textPassword = view.findViewById(R.id.tietPassword)
        textConfirm = view.findViewById(R.id.tietConfirm)
        errorName = view.findViewById(R.id.tilName)
        errorEmail = view.findViewById(R.id.tilEmail)
        errorPassword = view.findViewById(R.id.tilPassword)
        errorConfirm = view.findViewById(R.id.tilPasswordConfirm)

        initListeners()
        initViewModel()
    }
    private fun initListeners()
    {
        loginBtn.setOnClickListener{
            findNavController().navigate(R.id.action_registerFrag_to_loginFrag)
        }
        registerBtn.setOnClickListener{
            if(!viewModel.validateName(textName.text.toString()))
            {
                errorName.isErrorEnabled = true
                errorName.error = getString(R.string.nameerror)
                textName.setBackgroundResource(R.drawable.text_input_background_error)
                textEmail.setBackgroundResource(R.drawable.text_input_background)
                errorEmail.error = null
                errorEmail.isErrorEnabled = false
                textPassword.setBackgroundResource(R.drawable.text_input_background)
                errorPassword.error = null
                errorPassword.isErrorEnabled = false
                textConfirm.setBackgroundResource(R.drawable.text_input_background)
                errorConfirm.error = null
                errorConfirm.isErrorEnabled = false
            }
            else if(!viewModel.validateEmail(textEmail.text.toString()))
                    {
                        textName.setBackgroundResource(R.drawable.text_input_background)
                        errorName.error = null
                        errorName.isErrorEnabled = false
                        textName.clearFocus()
                        textEmail.requestFocus()
                        errorEmail.isErrorEnabled = true
                        errorEmail.error = getString(R.string.emailerror)
                        textEmail.setBackgroundResource(R.drawable.text_input_background_error)
                        textPassword.setBackgroundResource(R.drawable.text_input_background)
                        errorPassword.error = null
                        errorPassword.isErrorEnabled = false
                        textConfirm.setBackgroundResource(R.drawable.text_input_background)
                        errorConfirm.error = null
                        errorConfirm.isErrorEnabled = false
                    }
                    else if(!viewModel.validatePassword(textPassword.text.toString()))
                            {
                                textEmail.setBackgroundResource(R.drawable.text_input_background)
                                errorEmail.error = null
                                textEmail.clearFocus()
                                textPassword.requestFocus()
                                errorEmail.isErrorEnabled = false
                                errorPassword.isErrorEnabled = true
                                errorPassword.error = getString(R.string.passerror)
                                textPassword.setBackgroundResource(R.drawable.text_input_background_error)
                                textConfirm.setBackgroundResource(R.drawable.text_input_background)
                                errorConfirm.error = null
                                errorConfirm.isErrorEnabled = false
                            }
                            else if(!viewModel.samePassword(textPassword.text.toString(), textConfirm.text.toString()))
                                    {
                                        textPassword.setBackgroundResource(R.drawable.text_input_background)
                                        errorPassword.error = null
                                        textPassword.clearFocus()
                                        textConfirm.requestFocus()
                                        errorPassword.isErrorEnabled = false
                                        errorConfirm.isErrorEnabled = true
                                        errorConfirm.error = getString(R.string.confirmerror)
                                        textConfirm.setBackgroundResource(R.drawable.text_input_background_error)
                                    }
                                    else
                                        {
                                            textConfirm.setBackgroundResource(R.drawable.text_input_background)
                                            errorConfirm.error = null
                                            errorConfirm.isErrorEnabled = false
                                            textConfirm.clearFocus()
                                            viewModel.registerUser(textEmail.text.toString(), textPassword.text.toString(), textName.text.toString())
                                            val intent = Intent (requireActivity(), HomePage::class.java)
                                            requireActivity().startActivity(intent)
                                        }
        }
    }
    private fun initViewModel() {
        val viewModelFactory: RegisterViewModel.RegisterViewModelFactory =
            RegisterViewModel.RegisterViewModelFactory(appContainer.userRepo)
        viewModel = ViewModelProvider(this, viewModelFactory)[RegisterViewModel::class.java]
    }
}