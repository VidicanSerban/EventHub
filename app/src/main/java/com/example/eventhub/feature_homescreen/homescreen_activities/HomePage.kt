package com.example.eventhub.feature_homescreen.homescreen_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.eventhub.R
import com.example.eventhub.feature_homescreen.homescreen_fragments.HomeFragment
import com.example.eventhub.feature_homescreen.homescreen_fragments.ProfileFragment
import com.example.eventhub.feature_homescreen.homescreen_fragments.SearchFragment

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val firstfrag = HomeFragment()
        val secondfrag = SearchFragment()
        val thirdfrag = ProfileFragment()
    }
    private fun initListeners()
    {

    }


}