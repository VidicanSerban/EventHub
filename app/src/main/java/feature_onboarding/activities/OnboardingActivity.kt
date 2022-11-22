package feature_onboarding.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventhub.R
import feature_onboarding.fragments.RegisterFrag

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        //val Lgnfrag = LoginFrag()
        //val RegFrag = RegisterFrag()
        //val loginbtn = findViewById<Button>(R.id.regbtnfrg1)

//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.nav_host_fragment, RegFrag)
//            commit()}

        /*loginbtn.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                if(loginbtn.text == getString(R.string.autentifica_te)) {
                    replace(R.id.frglgnreg, Lgnfrag)
                    loginbtn.text = getString(R.string.inregistreaza_te)
                    commit()
                }
                else
                {
                    replace(R.id.frglgnreg, RegFrag)
                    loginbtn.text = getString(R.string.autentifica_te)
                    commit()
                }
            }
        }*/



    }
}