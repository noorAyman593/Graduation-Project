package com.ndkapp.www.mediconsult

/*import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView*/

import android.content.Intent
import android.graphics.drawable.Icon
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        clickListener()
    }

    public fun clickListener(){
        var edSearch=findViewById<EditText>(R.id.editTextTextPersonName3)
        val card1= findViewById<CardView>(R.id.d1)
        val card2= findViewById<CardView>(R.id.d2)
        val card3= findViewById<CardView>(R.id.d3)
        val card4= findViewById<CardView>(R.id.d4)
        val card5= findViewById<CardView>(R.id.d5)
        val card6= findViewById<CardView>(R.id.d6)

        edSearch.setOnClickListener{
            openBrowsingAction()
        }

        card1.setOnClickListener{
            openFirstCard()
        }
        card2.setOnClickListener{
            openSecondCard()
        }
        card3.setOnClickListener{
            openThirdCard()
        }
        card4.setOnClickListener{
            openFourthCard()
        }
        card5.setOnClickListener{
            openFifthCard()
        }
        card6.setOnClickListener{
            openSixthCard()
        }
    }
    public fun openBrowsingAction(){
        val browsingIntent= Intent(Intent.ACTION_VIEW)
        browsingIntent.data = Uri.parse("https://www.google.com")
        browsingIntent.setPackage("com.opera.browser")
        if (browsingIntent.resolveActivity(packageManager) !=null){
            startActivity(browsingIntent)
        }else{
            Toast.makeText(this,"No Activity found to handle this action", Toast.LENGTH_SHORT).show()
        }
    }

    public fun openFirstCard(){
        //startActivity(Intent(this,D1Activity::class.java))
        var i = Intent(this, D1Activity::class.java)
        startActivity(i)
    }
    public fun openSecondCard(){
        startActivity(Intent(this,D2Activity::class.java))
    }

    public fun openThirdCard(){
        startActivity(Intent(this,D3Activity::class.java))
    }
    public fun openFourthCard(){
        startActivity(Intent(this,D4Activity::class.java))
    }
    public fun openFifthCard(){
        startActivity(Intent(this,D5Activity::class.java))
    }
    public fun openSixthCard(){
        startActivity(Intent(this,D6Activity::class.java))
    }
}