package com.example.eventhub.feature_homescreen.homescreen_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.eventhub.R
import com.example.eventhub.R.id.bottom_nav_view
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        var bottomNav: BottomNavigationView = findViewById(bottom_nav_view)

        val navController = this.findNavController(R.id.nav_graph_second)
        val bottomNavigationView: BottomNavigationView = findViewById(bottom_nav_view)
        bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener{
            _, destination, _ -> if(destination.id == R.id.clCreateEventFrag){
            bottomNav.visibility = View.GONE
            Log.d("HomePage", "Bottom Nav View is invisible")
        }
            else {
                bottomNav.visibility = View.VISIBLE
            }
        }

    }

}