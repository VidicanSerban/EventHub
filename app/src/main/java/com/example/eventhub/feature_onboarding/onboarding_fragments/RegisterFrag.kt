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

class RegisterFrag : Fragment(R.layout.fragment_register) {

    lateinit var loginBtn: TextView
    lateinit var registerBtn: Button
    lateinit var viewModel: ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBtn = view.findViewById(R.id.tvRegisterClicky)
        registerBtn = view.findViewById(R.id.btnRegister)

        initListeners()

    }
    private fun initListeners()
    {
        loginBtn.setOnClickListener{
            val action =RegisterFragDirections.actionRegisterFragToLoginFrag()
            findNavController().navigate(action)
        }
        registerBtn.setOnClickListener{
            val action = RegisterFragDirections.actionRegisterFragToHomeFrag()
            findNavController().navigate(action)
        }
    }
    private fun initViewModel() {
        val viewModelFactory: RegisterViewModel.RegisterViewModelFactory =
            RegisterViewModel.RegisterViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[RegisterViewModel::class.java]
    }
}