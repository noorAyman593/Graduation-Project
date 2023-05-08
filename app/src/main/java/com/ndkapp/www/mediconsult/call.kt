package com.ndkapp.www.mediconsult

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ndkapp.www.mediconsult.R
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import android.content.Intent
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.cardview.widget.CardView
import android.text.method.LinkMovementMethod
import android.content.ActivityNotFoundException
import android.net.Uri
import android.widget.*

class call : AppCompatActivity() {
    private var mEditTextNumber: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        mEditTextNumber = findViewById(R.id.editText2)
        val imageCall = findViewById<ImageView>(R.id.imageView3)
        imageCall.setOnClickListener { makePhoneCall() }
    }

    private fun makePhoneCall() {
        val number = mEditTextNumber!!.text.toString()
        if (number.trim { it <= ' ' }.length > 0) {
            if (ContextCompat.checkSelfPermission(
                    this@call,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@call,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    REQUEST_CALL
                )
            } else {
                val dial = "tel:$number"
                startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))
            }
        } else {
            Toast.makeText(this@call, "Enter VALID Phone Number", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall()
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val REQUEST_CALL = 1
    }
}