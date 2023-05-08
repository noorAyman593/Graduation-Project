package com.ndkapp.www.mediconsult

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StatFs
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView

class rays : AppCompatActivity() {

    private var our_request_code : Int = 123
    private var image_request_code : Int = 122

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rays)
    }

    fun showResult(view: View){

        val intent =Intent(this, com.ndkapp.www.mediconsult.result::class.java)
        startActivity(intent)

    }

    fun choosePhoto(view: View){

        val intent = Intent(Intent.ACTION_PICK)
        intent.type ="image/*"
        startActivityForResult(intent,image_request_code)
    }

    fun takePhoto(view: View){

        val intent =Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if(intent.resolveActivity(packageManager)!=null){
            startActivityForResult(intent,our_request_code)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == our_request_code && resultCode == RESULT_OK ){
            val imageView : ImageView =findViewById(R.id.image)
            val bitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(bitmap)


        } else if (requestCode == image_request_code){


            val imageView : ImageView =findViewById(R.id.image)
            imageView.setImageURI(data?.data)


        }



    }
}