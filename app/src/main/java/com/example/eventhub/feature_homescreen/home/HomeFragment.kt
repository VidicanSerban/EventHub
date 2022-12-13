package com.example.eventhub.feature_homescreen.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventhub.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var viewModel: HomeFragmentViewModel
    lateinit var eventCreate: ImageButton
    lateinit var dateText: TextView

    private var layoutManagerTop10: RecyclerView.LayoutManager? = null
    private var adaptertop10: RecyclerView.Adapter<RecyclerAdapterTop10.ViewHolder>? = null
    private lateinit var top10: RecyclerView

    private var layoutManagerPopular: RecyclerView.LayoutManager? = null
    private var adapterpopular: RecyclerView.Adapter<RecyclerAdapterPopular.ViewHolder>? = null
    private lateinit var popular: RecyclerView

    private var layoutManagerNearYou: RecyclerView.LayoutManager? = null
    private var adapternearyou: RecyclerView.Adapter<RecyclerAdapterPopular.ViewHolder>? = null
    private lateinit var nearyou: RecyclerView

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eventCreate = view.findViewById(R.id.ibEventCreate)
        dateText = view.findViewById(R.id.tvDate)

        layoutManagerTop10 = LinearLayoutManager(this.requireActivity())
        top10 = view.findViewById(R.id.rvTopTen)

        layoutManagerPopular = LinearLayoutManager(this.requireActivity())
        popular = view.findViewById(R.id.rvPopular)

        layoutManagerNearYou = LinearLayoutManager(this.requireActivity())
        nearyou = view.findViewById(R.id.rvNearYou)

        val calendar = Calendar.getInstance().time
        val df: DateFormat = SimpleDateFormat("EEEE, dd, MMM")
        val date = df.format(calendar)
        dateText.text = date.toString()

        initViewModel()
        initListeners()
        initAdapters()
    }
    private fun initListeners()
    {
        eventCreate.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_organizeEventFrag)
        }
    }

    private fun initAdapters(){
        layoutManagerTop10 = LinearLayoutManager(this.requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        top10.layoutManager = layoutManagerTop10
        adaptertop10 = RecyclerAdapterTop10()
        top10.adapter = adaptertop10

        layoutManagerPopular = LinearLayoutManager(this.requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        popular.layoutManager = layoutManagerPopular
        adapterpopular = RecyclerAdapterPopular()
        popular.adapter = adapterpopular

        layoutManagerNearYou = LinearLayoutManager(this.requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        nearyou.layoutManager = layoutManagerNearYou
        adapternearyou = RecyclerAdapterPopular()
        nearyou.adapter = adapternearyou
    }
    private fun initViewModel() {
        val viewModelFactory: HomeFragmentViewModel.HomeFragmentViewModelFactory =
            HomeFragmentViewModel.HomeFragmentViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeFragmentViewModel::class.java]
    }
}