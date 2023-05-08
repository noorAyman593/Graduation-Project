package com.ndkapp.www.mediconsult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page_decision : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_decision)
        var btnsinup = findViewById<Button>(R.id.sinup)

        btnsinup.setOnClickListener{
            var i = Intent(this, login::class.java)
            startActivity(i)

            }
    }
}