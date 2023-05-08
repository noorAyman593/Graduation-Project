package com.ndkapp.www.mediconsult

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import com.ndkapp.www.mediconsult.R
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import android.content.Intent
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import android.widget.TextView
import androidx.cardview.widget.CardView
import android.text.method.LinkMovementMethod
import android.widget.Spinner
import android.content.ActivityNotFoundException
import android.os.Handler
import android.os.Looper
import android.util.Log
import java.util.*

class home : AppCompatActivity() {
    var t: Timer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        /*t = Timer()
        t!!.schedule(object : TimerTask() {
            override fun run() {
                val i1 = Intent(this@home, MainActivity::class.java)
                startActivity(i1)
                Log.d("homeactivity", "home gone")
                finish()
            }
        }, 4000)*/
        Handler(Looper.getMainLooper()).postDelayed({
            var i = Intent(this,login::class.java)
            startActivity(i)
            finish()

        },4000)
    }
}