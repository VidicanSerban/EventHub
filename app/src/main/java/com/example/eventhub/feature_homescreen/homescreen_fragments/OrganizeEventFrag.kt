package com.example.eventhub.feature_homescreen.homescreen_fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.eventhub.R
import com.example.eventhub.feature_homescreen.homescreen_viewmodel.HomeFragmentViewModel
import com.example.eventhub.feature_homescreen.homescreen_viewmodel.OrganizeEventViewModel

class OrganizeEventFrag : Fragment(R.layout.fragment_organize_event) {

    private lateinit var viewModel: OrganizeEventViewModel
    private lateinit var backButton:ImageButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backButton = view.findViewById(R.id.ibBack)
        initViewModel()
        initListeners()
    }

    private fun initListeners()
    {
        backButton.setOnClickListener{
            findNavController().popBackStack()
        }
    }
    private fun initViewModel() {
        val viewModelFactory: OrganizeEventViewModel.OrganizeEventViewModelFactory =
            OrganizeEventViewModel.OrganizeEventViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[OrganizeEventViewModel::class.java]
    }

}