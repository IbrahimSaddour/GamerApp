package tn.esprit.gamerapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class ValidationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validation)

        val container = findViewById<LinearLayout>(R.id.container)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val backButton = toolbar.findViewById<ImageView>(R.id.back_button)

        val editText1 = container.findViewById<EditText>(R.id.edt1)
        val editText2 = container.findViewById<EditText>(R.id.edt2)
        val editText3 = container.findViewById<EditText>(R.id.edt3)
        val editText4 = container.findViewById<EditText>(R.id.edt4)

        val editTextList = listOf(editText1, editText2, editText3, editText4)

        for (i in 0 until editTextList.size) {
            val editText = editTextList[i]
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    // Automatically move to the next EditText after typing one letter
                    if (s.length == 1 && i < editTextList.size - 1) {
                        editTextList[i + 1].requestFocus()
                    } else if (s.isEmpty() && i != 0) {
                        editTextList[i - 1].requestFocus()
                    } else if (s.length > 1){
                        // Do nothing
                    }
                }

                override fun afterTextChanged(s: Editable) {}
            })
        }

        val verify = findViewById<Button>(R.id.reset_verify_button)

        verify.setOnClickListener {
            val intent = Intent(this@ValidationActivity, ResetPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}