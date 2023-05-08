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
import android.view.View
import android.widget.*

class activity_contact_us : AppCompatActivity() {
    var t1: TextView? = null
    var t2: TextView? = null
    var t3: TextView? = null
    var i1: ImageView? = null
    var i2: ImageView? = null
    var i3: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)
        t1 = findViewById(R.id.call_cs)
        t2 = findViewById(R.id.mail_cs)
        t3 = findViewById(R.id.map_cs)
        i1 = findViewById(R.id.final_call)
        i2 = findViewById(R.id.final_mail)
        i3 = findViewById(R.id.final_map)
        val num = "8980688666"
        t1!!.setOnClickListener(View.OnClickListener { makePhoneCall(num) })
        i1!!.setOnClickListener(View.OnClickListener { makePhoneCall(num) })
        t2!!.setOnClickListener(View.OnClickListener {
            val i = Intent(Intent.ACTION_SENDTO)
            i.type = "message/rfc822"
            i.data = Uri.parse("mailto:" + "rudra.barad@gmail.com")
            i.putExtra(Intent.EXTRA_SUBJECT, "Query or Feedback")
            try {
                startActivity(Intent.createChooser(i, "Choose an Email client :"))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this@activity_contact_us,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        i2!!.setOnClickListener(View.OnClickListener {
            val i = Intent(Intent.ACTION_SENDTO)
            i.type = "message/rfc822"
            i.data = Uri.parse("mailto:" + "rudra.barad@gmail.com")
            i.putExtra(Intent.EXTRA_SUBJECT, "Query or Feedback")
            try {
                startActivity(Intent.createChooser(i, "Choose an Email client :"))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this@activity_contact_us,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        t3!!.setOnClickListener(View.OnClickListener {
            val bIntent = Intent(Intent.ACTION_VIEW)
            bIntent.data =
                Uri.parse("https://www.google.com/maps/place/Royal+Care+Boys+Hostel/@22.597658,72.8216473,17z/data=!3m1!4b1!4m5!3m4!1s0x395e50c30bd44029:0xa7ccb7b99f760e6e!8m2!3d22.597658!4d72.823836")
            startActivity(bIntent)
        })
        i3!!.setOnClickListener(View.OnClickListener {
            val bIntent = Intent(Intent.ACTION_VIEW)
            bIntent.data =
                Uri.parse("https://www.google.com/maps/place/Royal+Care+Boys+Hostel/@22.597658,72.8216473,17z/data=!3m1!4b1!4m5!3m4!1s0x395e50c30bd44029:0xa7ccb7b99f760e6e!8m2!3d22.597658!4d72.823836")
            startActivity(bIntent)
        })
    }

    private fun makePhoneCall(num: String) {
        if (ContextCompat.checkSelfPermission(
                this@activity_contact_us,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this@activity_contact_us,
                arrayOf(Manifest.permission.CALL_PHONE),
                REQUEST_CALL
            )
        } else {
            val dial = "tel:$num"
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))
        }
    }

    companion object {
        private const val REQUEST_CALL = 1
    }
}