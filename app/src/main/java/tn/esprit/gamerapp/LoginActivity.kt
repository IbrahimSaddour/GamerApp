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
import com.google.android.material.textfield.TextInputLayout
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

        // Controle de saisie sur Email
        var EmailValid = false
        binding.signinEmailText.addTextChangedListener{
            val emailRegex = "^[a-zA-Z0-9._%+-]+@esprit\\.tn\$".toRegex()
            val email = binding.signinEmailText.text.toString()
            if (email.isEmpty()){
                binding.signinEmailLayout.helperText = "Must not be empty"
                EmailValid = false
            }
            else if (!email.matches(emailRegex)){
                binding.signinEmailLayout.helperText = "Wrong email format"
                EmailValid = false
            }
            else{
                binding.signinEmailLayout.helperText = ""
                EmailValid = true
            }
        }

        // Controle de saisie sur Password
        var PasswordValid = false
        binding.signinPasswordText.addTextChangedListener{
            val pwd = binding.signinPasswordText.text.toString()
            if (pwd.isEmpty()){
                binding.signinPasswordLayout.helperText = " Must not be empty !"
                PasswordValid = false
            }
            else if (passwordValidation(pwd) == false){
                binding.signinPasswordLayout.helperText = " Wrong password format !"
                PasswordValid = false
            }
            else if (pwd.length < 8){
                binding.signinPasswordLayout.helperText = " Password is too short !"
                PasswordValid = false
            }
            else{
                binding.signinPasswordLayout.helperText = ""
                PasswordValid = true
            }
        }


        signInWithFbBtn.setOnClickListener {
            Snackbar.make(binding.root,"Coming soon :)",Snackbar.LENGTH_LONG).show()
        }

        signInWithGmailBtn.setOnClickListener {
            Snackbar.make(binding.root,"Coming soon :)",Snackbar.LENGTH_LONG).show()
        }

        loginButton.setOnClickListener {
            if (EmailValid && PasswordValid){
                //Toast.makeText(this, "LOGIN Success", Toast.LENGTH_LONG).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            else
                //Toast.makeText(this, "LOGIN FAILED", Toast.LENGTH_LONG).show()
                Snackbar.make(binding.root,"You have some errors in your inputs !",Snackbar.LENGTH_LONG).show()
        }


        forgotPasswordButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        registerButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
            //finish()
        }

    }


    private fun passwordValidation(pwd :String) :Boolean {

        if (pwd.filter { it.isDigit() }.firstOrNull() == null)
            return false
        if (pwd.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null)
            return false
        if (pwd.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null)
            return false

        return true
    }


}