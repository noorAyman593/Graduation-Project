package com.ndkapp.www.mediconsult

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
import android.view.View
import android.widget.*

class activity_symptoms : AppCompatActivity() {
    var dis: Button? = null
    var s1: Spinner? = null
    var s2: Spinner? = null
    var s3: Spinner? = null
    var s4: Spinner? = null
    var s5: Spinner? = null
    var s6: Spinner? = null
    var s7: Spinner? = null
    var d = arrayOfNulls<String>(7)
    var diarrhoea = arrayOf("Stomach Ache", "Nausea", "Vomiting", "Fever", "Sudden Weight Loss")
    var malaria = arrayOf("Fever", "Vomiting", "Sweating", "Muscle And Body Pain", "Headaches")
    var typhoid = arrayOf(
        "Fever",
        "Headaches",
        "Weakness/Fatigue",
        "Abdominal Pain",
        "Muscle Pain",
        "Dry Cough",
        "Diarrhoea/Constipation"
    )
    var diabetes = arrayOf(
        "Frequent Urination",
        "Hunger",
        "Thirsty Than Usual",
        "Sudden Weight Loss",
        "Blurred Vision",
        "Skin Itching"
    )
    var blood_pressure = arrayOf(
        "Headaches",
        "Blurred Vision",
        "Chest Pain",
        "Shortness in Breath",
        "Dizziness",
        "Nausea",
        "Vomiting"
    )
    var cardio_disease = arrayOf(
        "Shortness in Breath",
        "Fast Heartbeat",
        "Indigestion",
        "Pressure Or Heaviness In Chest",
        "Anxiety"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)
        dis = findViewById(R.id.disease)
        s1 = findViewById(R.id.syp1)
        s2 = findViewById(R.id.syp2)
        s3 = findViewById(R.id.syp3)
        s4 = findViewById(R.id.syp4)
        s5 = findViewById(R.id.syp5)
        s6 = findViewById(R.id.syp6)
        s7 = findViewById(R.id.syp7)
        val name = intent.getStringExtra("name")
        val gender = intent.getStringExtra("gender")
        dis!!.setOnClickListener(View.OnClickListener {
            val c = IntArray(6)
            d[0] = s1!!.getSelectedItem().toString()
            d[1] = s2!!.getSelectedItem().toString()
            d[2] = s3!!.getSelectedItem().toString()
            d[3] = s4!!.getSelectedItem().toString()
            d[4] = s5!!.getSelectedItem().toString()
            d[5] = s6!!.getSelectedItem().toString()
            d[6] = s7!!.getSelectedItem().toString()
            for (i in 0..6) {
                for (j in 1..6) {
                    when (j) {
                        1 -> {
                            var l = 0
                            l = diarrhoea.size
                            var k = 0
                            while (k < l) {
                                if (d[i] == diarrhoea[k]) {
                                    c[0]++
                                }
                                k++
                            }
                        }
                        2 -> {
                            var l = 0
                            l = malaria.size
                            var k = 0
                            while (k < l) {
                                if (d[i] == malaria[k]) {
                                    c[1]++
                                }
                                k++
                            }
                        }
                        3 -> {
                            var l = 0
                            l = typhoid.size
                            var k = 0
                            while (k < l) {
                                if (d[i] == typhoid[k]) {
                                    c[2]++
                                }
                                k++
                            }
                        }
                        4 -> {
                            var l = 0
                            l = diabetes.size
                            var k = 0
                            while (k < l) {
                                if (d[i] == diabetes[k]) {
                                    c[3]++
                                }
                                k++
                            }
                        }
                        5 -> {
                            var l = 0
                            l = blood_pressure.size
                            var k = 0
                            while (k < l) {
                                if (d[i] == blood_pressure[k]) {
                                    c[4]++
                                }
                                k++
                            }
                        }
                        6 -> {
                            var l = 0
                            l = cardio_disease.size
                            var k = 0
                            while (k < l) {
                                if (d[i] == cardio_disease[k]) {
                                    c[5]++
                                }
                                k++
                            }
                        }
                    }
                }
            }
            var max = c[0]
            for (m in 0..5) {
                if (c[m] > max) max = c[m]
            }
            val dis_page = Intent(this@activity_symptoms, activity_disease::class.java)
            dis_page.putExtra("name", name)
            dis_page.putExtra("gender", gender)
            dis_page.putExtra("max", max)
            dis_page.putExtra("c", c)
            startActivity(dis_page)
        })
    }
}