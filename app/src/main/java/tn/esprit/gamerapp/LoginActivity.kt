package tn.esprit.gamerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import tn.esprit.gamerapp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        binding = ActivityLoginBinding.inflate(layoutInflater,null,false)
        setContentView(binding.root)



        val loginButton = findViewById<Button>(R.id.login_button)
        val registerButton = findViewById<TextView>(R.id.register_button)
        val forgotPasswordButton = findViewById<TextView>(R.id.forgot_password_button)
        val signInWithFbBtn = findViewById<ImageView>(R.id.signin_with_fb_bn)
        val signInWithGmailBtn = findViewById<ImageView>(R.id.signin_with_gmail_bn)


        binding.signinEmailText.addTextChangedListener{
            val emailRegex = "^[a-zA-Z0-9._%+-]+@esprit\\.tn\$".toRegex()
            val email = binding.signinEmailText.text.toString()
            if (email.isEmpty()){
                binding.signinEmailLayout.helperText = "Must not be empty"
            }
            else if (!email.matches(emailRegex))
                binding.signinEmailLayout.helperText = "Wrong email format"
            else
                binding.signinEmailLayout.helperText = null
        }


        signInWithFbBtn.setOnClickListener {
            Snackbar.make(binding.root,"Coming soon :)",Snackbar.LENGTH_LONG).show()
        }

        signInWithGmailBtn.setOnClickListener {
            Snackbar.make(binding.root,"Coming soon :)",Snackbar.LENGTH_LONG).show()
        }

        loginButton.setOnClickListener {
            Toast.makeText(this, "LOGIN IN PROGRESS", Toast.LENGTH_LONG).show()
        }


        forgotPasswordButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, ValidationActivity::class.java)

            startActivity(intent)
        }
        registerButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
            //finish()
        }

    }


}