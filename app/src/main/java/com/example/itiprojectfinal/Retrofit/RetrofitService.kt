package com.example.itiproject.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val api:ApiMeal by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiMeal::class.java)
    }
}