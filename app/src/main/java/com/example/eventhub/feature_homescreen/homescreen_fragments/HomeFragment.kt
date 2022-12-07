package com.example.eventhub.feature_homescreen.homescreen_fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.format.DateFormat.format
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.eventhub.R
import com.example.eventhub.feature_homescreen.homescreen_viewmodel.HomeFragmentViewModel
import com.google.type.Date
import java.lang.String.format
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar

class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var viewModel: HomeFragmentViewModel
    lateinit var eventCreate: ImageButton
    lateinit var dateText: TextView

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventCreate = view.findViewById(R.id.ibEventCreate)
        dateText = view.findViewById(R.id.tvDate)
        initViewModel()
        initListeners()

        val calendar = Calendar.getInstance().time
        val df: DateFormat = SimpleDateFormat("EEEE, dd, MMM")
        val date = df.format(calendar)

        dateText.text = date.toString()

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