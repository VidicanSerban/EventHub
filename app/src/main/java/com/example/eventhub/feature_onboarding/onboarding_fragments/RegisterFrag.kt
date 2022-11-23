package com.example.eventhub.feature_onboarding.onboarding_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.eventhub.R

class RegisterFrag : Fragment(R.layout.fragment_register) {

    lateinit var loginBtn: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBtn = view.findViewById(R.id.tvRegisterClicky)

        loginBtn.setOnClickListener{
            val action =RegisterFragDirections.actionRegisterFragToLoginFrag()
            findNavController().navigate(action)
        }
    }
}