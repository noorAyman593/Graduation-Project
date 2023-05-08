package com.ndkapp.www.mediconsult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val emailEditText: EditText = findViewById(R.id.ed_email_login)
        val passwordEditText: EditText = findViewById(R.id.ed_password_login)
        val loginButton: Button = findViewById(R.id.btn_login)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.trim().isEmpty() ||password.trim().isEmpty()){
                if(email.trim().isEmpty()){
                    emailEditText.error = "enter your email"
                }
                if(password.trim().isEmpty()){
                    passwordEditText.error = "enter your password"
                }
                Toast.makeText(this, "Enter Valid details", Toast.LENGTH_SHORT).show()
            }else if(!email.matches(emailPattern.toRegex())){
                emailEditText.error = "enter valid email"
                Toast.makeText(this, "Enter Valid email", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){

                    }else{
                        Toast.makeText(this, "something went wrong try again", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

            var register = findViewById<Button>(R.id.register)
            register.setOnClickListener({
                var i = Intent(this, signup::class.java)
                startActivity(i)
            })
    }
}