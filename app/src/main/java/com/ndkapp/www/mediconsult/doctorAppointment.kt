package com.ndkapp.www.mediconsult
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import com.ndkapp.www.mediconsult.R

class doctorAppointment : AppCompatActivity() {
    private lateinit var Calender: CalendarView
    var year: Int = 0
    var month: Int = 0
    var day: Int = 0
    var total : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_appointment)
        Calender =findViewById(R.id.calendarView)
        Calender.setOnDateChangeListener { calendarView, i, i2, i3 ->
            var month = i2+1
            Toast.makeText(this,"Selected Date : $i3/$month/$i", Toast.LENGTH_LONG).show()
            year = i
            month = i2+1
            day = i3
        }
    }
}