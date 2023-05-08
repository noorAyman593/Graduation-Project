package com.ndkapp.www.mediconsult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class information : AppCompatActivity() {
    private lateinit var SaveBtn:Button
    private lateinit var specialistEt:EditText
    private lateinit var addressEt:EditText
    private lateinit var disclosurePriceEt:EditText
    private lateinit var mobileNumberEt:EditText
    private lateinit var whatsUpNumberEt:EditText
    private lateinit var messengerLinkEt:EditText
    private lateinit var descriptionEt: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        SaveBtn =findViewById(R.id.save_Btn)
        specialistEt=findViewById(R.id.specialist_ET)
        addressEt=findViewById(R.id.address_ET)
        disclosurePriceEt=findViewById(R.id.price_ET)
        mobileNumberEt=findViewById(R.id.mobile_no_ET)
        whatsUpNumberEt=findViewById(R.id.whatsUp_no_ET)
        messengerLinkEt=findViewById(R.id.messenger_link_ET)
        descriptionEt=findViewById(R.id.description_ET)

        SaveBtn.setOnClickListener{
            val specialist =specialistEt.text.toString()
            val address = addressEt.text.toString()
            val disclosurePrice = disclosurePriceEt.text.toString()
            val mobileNumber = mobileNumberEt.text.toString()
            val whatsUpNumber = whatsUpNumberEt.text.toString()
            val messengerLink = messengerLinkEt.text.toString()
            val description = descriptionEt.text.toString()

            var i = Intent(this,doctor_page::class.java)

            i.putExtra("Specialist",specialist)
            i.putExtra("Address",address)
            i.putExtra("Price",disclosurePrice)
            i.putExtra("MobileNumber",mobileNumber)
            i.putExtra("WhatsUpNumber",whatsUpNumber)
            i.putExtra("MessengerLink",messengerLink)
            i.putExtra("Description",description)
            startActivity(i)
        }

    }

    }
