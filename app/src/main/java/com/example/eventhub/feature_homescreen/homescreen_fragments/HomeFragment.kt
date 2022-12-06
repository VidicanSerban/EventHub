package com.example.eventhub.feature_homescreen.homescreen_fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.eventhub.R
import com.example.eventhub.feature_homescreen.homescreen_viewmodel.HomeFragmentViewModel
import com.example.eventhub.feature_onboarding.onboarding_viewmodel.RegisterViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var viewModel: HomeFragmentViewModel
    lateinit var dateTimeDisplay: Display
    lateinit var eventCreate: ImageButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventCreate = view.findViewById(R.id.ibEventCreate)

        initViewModel()
        initListeners()

    }
    private fun initListeners()
    {
        eventCreate.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_organizeEventFrag)
        }
    }
    private fun initViewModel() {
        val viewModelFactory: HomeFragmentViewModel.HomeFragmentViewModelFactory =
            HomeFragmentViewModel.HomeFragmentViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeFragmentViewModel::class.java]
    }

}