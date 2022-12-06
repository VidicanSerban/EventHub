package com.example.eventhub.feature_homescreen.homescreen_fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eventhub.R
import com.example.eventhub.feature_homescreen.homescreen_viewmodel.HomeFragmentViewModel
import com.example.eventhub.feature_homescreen.homescreen_viewmodel.OrganizeEventViewModel

class OrganizeEventFrag : Fragment() {
    private lateinit var viewModel: OrganizeEventViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        val viewModelFactory: HomeFragmentViewModel.HomeFragmentViewModelFactory =
            HomeFragmentViewModel.HomeFragmentViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[OrganizeEventViewModel::class.java]
    }

}