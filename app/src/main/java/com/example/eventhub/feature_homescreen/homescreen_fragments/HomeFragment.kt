package com.example.eventhub.feature_homescreen.homescreen_fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eventhub.R
import com.example.eventhub.feature_homescreen.homescreen_viewmodel.HomeFragmentViewModel
import com.example.eventhub.feature_onboarding.onboarding_viewmodel.RegisterViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var viewModel: HomeFragmentViewModel
    lateinit var dateTimeDisplay: Display

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        val viewModelFactory: HomeFragmentViewModel.HomeFragmentViewModelFactory =
            HomeFragmentViewModel.HomeFragmentViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeFragmentViewModel::class.java]
    }

}