package com.example.eventhub.feature_spashscreen.activity

import android.content.Intent
import android.os.Bundle
import com.example.eventhub.R
import com.example.eventhub.commons.BaseActivity
import com.example.eventhub.feature_onboarding.activity.OnboardingActivity

@Suppress("DEPRECATION")
class SplashScreen : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val intent = Intent(this, OnboardingActivity::class.java)
        startActivity(intent)
        finish()
    }
}