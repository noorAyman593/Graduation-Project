package com.ndkapp.www.mediconsult

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.github.dhaval2404.imagepicker.ImagePicker

import com.google.android.material.floatingactionbutton.FloatingActionButton

class doctor_page : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var button: FloatingActionButton
    private lateinit var editBtn: FloatingActionButton
    private lateinit var call_layout: LinearLayout
    private lateinit var appointment_layout: LinearLayout
//    private lateinit var whatsUp_layout: LinearLayout
//    private lateinit var messenger_layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_page)

//       supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.WHITE))

        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.floatingActionButton)
        editBtn = findViewById(R.id.edit_information)
        call_layout= findViewById(R.id.make_call)
//        whatsUp_layout= findViewById(R.id.open_whatsApp)
//        messenger_layout=findViewById(R.id.open_messenger)
        appointment_layout = findViewById(R.id.appointment_layout)
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

        specialistTV.text = specialist
        addressTV.text = address
        disclosurePriceTV.text = disclosurePrice.toString()
        mobileNumberTV.text = mobileNumber.toString()
        whatsUpNumberTV.text = whatsUpNumber.toString()
        messengerLinkTV.text = messengerLink
        descriptionTV.text = description

        editBtn.setOnClickListener {
            var i = Intent(this, information::class.java)
            startActivity(i)

        }
        appointment_layout.setOnClickListener {
            var i = Intent(this, appointment::class.java)
            startActivity(i)

        }

        button.setOnClickListener {
            ImagePicker.with(this)
                .crop()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start()
        }
        call_layout.setOnClickListener{
            val dialIntent=Intent(Intent.ACTION_DIAL)
            dialIntent.data= Uri.parse("tel:$mobileNumber")
            startActivity(dialIntent)
        }

//        whatsUp_layout.setOnClickListener{
//            val uri= Uri.parse("DR"+"+2001023456779")
//            val intent =Intent(Intent.ACTION_SENDTO,uri)
//            intent.setPackage("com.whatsapp")
//            if(intent.resolveActivity(this.packageManager)!=null){
//                startActivity(intent)
//            }else{
//                Toast.makeText(this,"Package is not installed",Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        messenger_layout.setOnClickListener {
//
//
//        }
//
//
//    }

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            imageView.setImageURI(data?.data)
        }

    }
}