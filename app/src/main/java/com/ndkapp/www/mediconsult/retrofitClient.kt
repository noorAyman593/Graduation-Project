package com.ndkapp.www.mediconsult

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object retrofitClient {

    var retrofit = Retrofit.Builder()
        .baseUrl("http://noorayman596123.pythonanywhere.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}