package com.ndkapp.www.mediconsult

/*import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout*/

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.palette.graphics.Palette
import com.google.android.material.appbar.CollapsingToolbarLayout
import java.util.*

class D3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d3)

        //val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val collapsingToolbarLayout =
            findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout)
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.heart_rate4)
        Palette.from(bitmap).generate { palette ->
            if (palette != null) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(androidx.appcompat.R.attr.colorPrimary))
            }
        }
    }
}