package com.ndkapp.www.mediconsult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class patient : AppCompatActivity() {
    private lateinit var patient_appointment_layout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient)
        val mobileNumberTV = findViewById<TextView>(R.id.mobile_no_TV)
        val whatsUpNumberTV = findViewById<TextView>(R.id.whatsUp_no_TV)
        val messengerLinkTV = findViewById<TextView>(R.id.messenger_link_TV)
        val descriptionTV = findViewById<TextView>(R.id.description_TV)
        val disclosurePriceTV = findViewById<TextView>(R.id.price_TV)
        val addressTV = findViewById<TextView>(R.id.address_TV)
        val specialistTV = findViewById<TextView>(R.id.specialist_TV)

        val specialist = intent.getStringExtra("Specialist")
        val address = intent.getStringExtra("Address")
        val disclosurePrice = intent.getStringExtra("Price")
        val mobileNumber = intent.getStringExtra("MobileNumber")
        val whatsUpNumber = intent.getStringExtra("WhatsUpNumber")
        val messengerLink = intent.getStringExtra("MessengerLink")
        val description = intent.getStringExtra("Description")

//        specialistTV.text = specialist
        addressTV.text = address
        disclosurePriceTV.text = disclosurePrice.toString()
        mobileNumberTV.text = mobileNumber.toString()
        whatsUpNumberTV.text = whatsUpNumber.toString()
        messengerLinkTV.text = messengerLink
        descriptionTV.text = description

        patient_appointment_layout = findViewById(R.id.book_appointment_layout)
        patient_appointment_layout.setOnClickListener {
            var i = Intent(this, doctorAppointment::class.java)
            startActivity(i)
        }
    }
}