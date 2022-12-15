package com.example.eventhub.feature_homescreen.organizeevent

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.eventhub.R
import com.example.eventhub.utils.AppApplication
import com.example.eventhub.utils.AppContainer

class OrganizeEventFrag : Fragment(R.layout.fragment_organize_event) {
    private lateinit var appContainer: AppContainer
    private lateinit var viewModel: OrganizeEventViewModel

    private lateinit var backButton: ImageButton
    private lateinit var createButton: Button
    lateinit var nameText: EditText
    lateinit var dateText: EditText
    lateinit var timeText: EditText
    lateinit var locationText: TextView
    lateinit var detailsText: EditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appContainer = (requireActivity().application as AppApplication).myContainer
        backButton = view.findViewById(R.id.ibBack)
        createButton = view.findViewById(R.id.btnCreate)

        nameText = view.findViewById(R.id.etEventName)
        dateText = view.findViewById(R.id.etDate)
        timeText = view.findViewById(R.id.etTime)
        locationText = view.findViewById(R.id.tvLocation)
        detailsText = view.findViewById(R.id.etDescription)

        initViewModel()
        initListeners()
    }

    private fun initListeners()
    {
        backButton.setOnClickListener{
            findNavController().popBackStack()
        }

        createButton.setOnClickListener{
            viewModel.addEvent(nameText.text.toString(), dateText.text.toString(), timeText.text.toString(), locationText.text.toString(),detailsText.text.toString())
            findNavController().popBackStack()
        }
    }
    private fun initViewModel() {
        val viewModelFactory: OrganizeEventViewModel.OrganizeEventViewModelFactory =
            OrganizeEventViewModel.OrganizeEventViewModelFactory(appContainer.eventRepo)
        viewModel = ViewModelProvider(this, viewModelFactory)[OrganizeEventViewModel::class.java]
    }
}