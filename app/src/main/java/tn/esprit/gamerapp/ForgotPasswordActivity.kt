package tn.esprit.gamerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)



        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val backButton = toolbar.findViewById<ImageView>(R.id.back_button)

        backButton.setOnClickListener {
            finish()
        }
    }
}