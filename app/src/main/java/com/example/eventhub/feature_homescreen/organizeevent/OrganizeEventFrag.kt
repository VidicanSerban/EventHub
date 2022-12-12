package com.example.eventhub.feature_homescreen.organizeevent

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.eventhub.R
import java.util.Calendar

class OrganizeEventFrag : Fragment(R.layout.fragment_organize_event) {

    private lateinit var viewModel: OrganizeEventViewModel
    private lateinit var backButton: ImageButton
    private lateinit var createButton: Button
    lateinit var dateText: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backButton = view.findViewById(R.id.ibBack)
        createButton = view.findViewById(R.id.btnCreate)
        dateText = view.findViewById(R.id.etDate)

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

//        dateText.setOnClickListener {
//            val calendar: Calendar = Calendar.getInstance()
//            val year = calendar.get(Calendar.YEAR)
//            val month = calendar.get(Calendar.MONTH)
//            val day = calendar.get(Calendar.DAY_OF_MONTH)
//
//            val datePickerDialog = DatePickerDialog(this.requireContext(),
//                {
//                view; year; month; day ->
//                    val dat = (day + "/" + (month + 1) + "/" + year)
//                    dateText.setText(dat)
//            },
//            year,
//            month,
//            day)
//            datePickerDialog.show()
//
//        }
    }
    private fun initViewModel() {
        val viewModelFactory: OrganizeEventViewModel.OrganizeEventViewModelFactory =
            OrganizeEventViewModel.OrganizeEventViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[OrganizeEventViewModel::class.java]
    }

}