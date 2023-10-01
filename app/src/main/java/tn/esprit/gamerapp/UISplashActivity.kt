package tn.esprit.gamerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class UISplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uisplash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@UISplashActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}