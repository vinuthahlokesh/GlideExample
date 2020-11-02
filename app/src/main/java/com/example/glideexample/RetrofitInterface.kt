package com.example.glideexample

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("random")
    fun getRandomDogData(): Call<DogDataClass>

    @GET("random/30")
    fun getRandomDogList(): Call<DogDataForList>
}