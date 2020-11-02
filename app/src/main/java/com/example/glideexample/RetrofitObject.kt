package com.example.glideexample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breeds/image/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getInstance(): Retrofit {
        return retrofit
    }
}