package feature_onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventhub.R

class Onboarding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val Lgnfrag = LoginFrag()
        val RegFrag = RegisterFrag()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frglgnreg, RegFrag)
            commit()
        }


    }
}