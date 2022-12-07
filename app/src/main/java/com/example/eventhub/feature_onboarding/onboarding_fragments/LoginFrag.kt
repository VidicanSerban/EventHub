package com.example.eventhub.feature_onboarding.onboarding_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.eventhub.R

class LoginFrag : Fragment(R.layout.fragment_login) {
    lateinit var registerBtn: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerBtn = view.findViewById(R.id.tvLoginClicky)

        registerBtn.setOnClickListener{
            findNavController().popBackStack()
        }
    }

}