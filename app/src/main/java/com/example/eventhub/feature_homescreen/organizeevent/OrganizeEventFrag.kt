package com.example.eventhub.feature_homescreen.organizeevent

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.eventhub.R

class OrganizeEventFrag : Fragment(R.layout.fragment_organize_event) {

    private lateinit var viewModel: OrganizeEventViewModel
    private lateinit var backButton: ImageButton
    private lateinit var createButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backButton = view.findViewById(R.id.ibBack)
        createButton = view.findViewById(R.id.btnCreate)
        initViewModel()
        initListeners()
    }

    private fun initListeners()
    {
        backButton.setOnClickListener{
            findNavController().popBackStack()
        }

        createButton.setOnClickListener{
            Toast.makeText(context, "Ati create un eveniment", Toast.LENGTH_LONG).show()
        }
    }
    private fun initViewModel() {
        val viewModelFactory: OrganizeEventViewModel.OrganizeEventViewModelFactory =
            OrganizeEventViewModel.OrganizeEventViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[OrganizeEventViewModel::class.java]
    }

}