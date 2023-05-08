package com.ndkapp.www.mediconsult

import retrofit2.Call
import retrofit2.http.GET

interface userApi {

    @GET("/predict")
    fun getPredict(): Call<predict>

}