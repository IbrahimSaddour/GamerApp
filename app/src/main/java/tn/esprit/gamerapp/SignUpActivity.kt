package tn.esprit.gamerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import tn.esprit.gamerapp.databinding.ActivitySignUpBinding
import java.util.jar.Attributes.Name

class SignUpActivity : AppCompatActivity() {

    lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater,null,false)
        setContentView(binding.root)

        val signupButton = findViewById<Button>(R.id.signup_button)



        // Controle de saisie sur Fullname
        var NameValid = false
        binding.signupFullnameText.addTextChangedListener{
            val name = binding.signupFullnameText.text.toString()
            if (name.isEmpty()){
                binding.signupFullnameLayout.helperText = "Must not be empty !"
                NameValid = false
            }
            else if (name.length < 4){
                binding.signupFullnameLayout.helperText = "Name is too short !"
                NameValid = false
            }
            else{
                binding.signupFullnameLayout.helperText = ""
                NameValid = true
            }
        }


        // Controle de saisie sur Email
        var EmailValid = false
        binding.signupEmailText.addTextChangedListener{
            val emailRegex = "^[a-zA-Z0-9._%+-]+@esprit\\.tn\$".toRegex()
            val email = binding.signupEmailText.text.toString()
            if (email.isEmpty()){
                binding.signupEmailLayout.helperText = "Must not be empty"
                EmailValid = false
            }
            else if (!email.matches(emailRegex)){
                binding.signupEmailLayout.helperText = "Wrong email format"
                EmailValid = false
            }
            else{
                binding.signupEmailLayout.helperText = ""
                EmailValid = true
            }
        }

        // Controle de saisie sur Password
        var PasswordValid = false
        binding.signupPasswordText.addTextChangedListener{
            val pwd = binding.signupPasswordText.text.toString()
            if (pwd.isEmpty()){
                binding.signupPasswordLayout.helperText = " Must not be empty !"
                PasswordValid = false
            }
            else if (passwordValidation(pwd) == false){
                binding.signupPasswordLayout.helperText = " Wrong password format !"
                PasswordValid = false
            }
            else if (pwd.length < 8){
                binding.signupPasswordLayout.helperText = " Password is too short !"
                PasswordValid = false
            }
            else{
                binding.signupPasswordLayout.helperText = ""
                PasswordValid = true
            }
        }

        // Controle de saisie sur Confirm Password
        var PasswordConfirmValid = false
        binding.signupPasswordConfirmText.addTextChangedListener {
            var pwdConfirm = binding.signupPasswordConfirmText.text.toString()
            val pwd = binding.signupPasswordText.text.toString()
            if (pwdConfirm.isEmpty()){
                binding.signupPasswordConfirmLayout.helperText = " Must not be empty !"
                PasswordConfirmValid = false
            }
            else if (pwdConfirm != pwd){
                binding.signupPasswordConfirmLayout.helperText = " Passwords do not match !"
                PasswordConfirmValid = false
            }
            else{
                binding.signupPasswordConfirmLayout.helperText = ""
                PasswordConfirmValid = true
            }

        }


        signupButton.setOnClickListener {
            if (NameValid && EmailValid && PasswordValid && PasswordConfirmValid){
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
                Snackbar.make(binding.root,"You have some errors in your inputs !", Snackbar.LENGTH_LONG).show()
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