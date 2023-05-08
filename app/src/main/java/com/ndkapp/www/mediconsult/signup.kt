package com.ndkapp.www.mediconsult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class signup : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        val nameEditText: EditText = findViewById(R.id.ed_name)
        val emailEditText: EditText = findViewById(R.id.ed_email)
        val passwordEditText: EditText = findViewById(R.id.ed_password)
        val confirmPasswordEditText: EditText = findViewById(R.id.ed_confirm_password)
        val doctorRadioButton: RadioButton = findViewById(R.id.radio_male)
        val signUpButton: Button = findViewById(R.id.next)

        signUpButton.setOnClickListener{
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()
            val isDoctor = doctorRadioButton.isChecked
            val image = null

            if (name.trim().isEmpty() ||email.trim().isEmpty() ||password.trim().isEmpty() ||confirmPassword.trim().isEmpty()){
                if(name.trim().isEmpty()){
                    nameEditText.error = "enter your name"
                }
                if(email.trim().isEmpty()){
                    emailEditText.error = "enter your email"
                }
                if(password.trim().isEmpty()){
                    passwordEditText.error = "enter your password"
                }
                if(confirmPassword.trim().isEmpty()){
                    confirmPasswordEditText.error = "confirm your password correctly"
                }
                Toast.makeText(this, "Enter Valid details", Toast.LENGTH_SHORT).show()
            }else if(!email.matches(emailPattern.toRegex())){
                emailEditText.error = "enter valid email"
                Toast.makeText(this, "Enter Valid email", Toast.LENGTH_SHORT).show()
            }else if(password.length < 8){
                passwordEditText.error = "enter valid password"
                Toast.makeText(this, "Enter Valid password", Toast.LENGTH_SHORT).show()
            }else if(password != confirmPassword){
                confirmPasswordEditText.error = "confirm your password correctly"
                Toast.makeText(this, "confirm passwoed didn't match with password", Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val databaseRef = database.reference.child("users").child(auth.currentUser!!.uid)
                        val users : UserData = UserData(name, email, password, image, isDoctor)

                        databaseRef.setValue(users).addOnCompleteListener{
                            if(it.isSuccessful){
                                if (isDoctor) {
                                    startActivity(Intent(this, doctor_page::class.java))
                                } else {
                                    startActivity(Intent(this, MainActivity::class.java))
                                }
                            }else{
                                Toast.makeText(this, "something went wrong try again", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        Toast.makeText(this, "something went wrong try again", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        var register = findViewById<Button>(R.id.login)
        register.setOnClickListener({
            var i = Intent(this, login::class.java)
            startActivity(i)
        })

    }
}