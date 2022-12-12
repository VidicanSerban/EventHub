package com.example.eventhub.feature_homescreen.activity

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.eventhub.R
import com.example.eventhub.R.id.bottom_nav_view
import com.example.eventhub.commons.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        var bottomNav: BottomNavigationView = findViewById(bottom_nav_view)

        val navController = this.findNavController(R.id.nav_graph_second)
        val bottomNavigationView: BottomNavigationView = findViewById(bottom_nav_view)
        bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener{
            _, destination, _ -> if(destination.id == R.id.organizeEventFrag){
            bottomNav.visibility = View.GONE
        }
            else {
                bottomNav.visibility = View.VISIBLE
            }
        }

    }



}