package com.example.eventhub.feature_onboarding.onboarding_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.eventhub.R
import com.example.eventhub.feature_onboarding.onboarding_viewmodel.RegisterViewModel
import com.google.android.material.textfield.TextInputEditText

class RegisterFrag : Fragment(R.layout.fragment_register) {

    lateinit var loginBtn: TextView
    lateinit var registerBtn: Button
    lateinit var viewModel: RegisterViewModel
    lateinit var textName: TextInputEditText
    lateinit var textEmail: TextInputEditText
    lateinit var textPassword: TextInputEditText
    lateinit var textConfirm: TextInputEditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBtn = view.findViewById(R.id.tvRegisterClicky)
        registerBtn = view.findViewById(R.id.btnRegister)
        textName = view.findViewById(R.id.tiedName)
        textEmail = view.findViewById(R.id.tiedEmail)
        textPassword = view.findViewById(R.id.tiedPassword)
        textConfirm = view.findViewById(R.id.tiedConfirm)

        initListeners()
        initViewModel()

    }
    private fun initListeners()
    {
        loginBtn.setOnClickListener{
            val action =RegisterFragDirections.actionRegisterFragToLoginFrag()
            findNavController().navigate(action)
        }
        registerBtn.setOnClickListener{
            if(viewModel.validateName(textName.text.toString()) && viewModel.validateEmail(textEmail.text.toString()) && viewModel.validatePassword(textPassword.text.toString()) && viewModel.samePassword(textPassword.text.toString(), textConfirm.text.toString())){
                val action = RegisterFragDirections.actionRegisterFragToHomeFrag()
                findNavController().navigate(action)
            }


        }

    }
    private fun initViewModel() {
        val viewModelFactory: RegisterViewModel.RegisterViewModelFactory =
            RegisterViewModel.RegisterViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[RegisterViewModel::class.java]
    }
}