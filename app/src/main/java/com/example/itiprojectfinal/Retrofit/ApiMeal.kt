package com.example.itiproject.Retrofit

import com.example.itiproject.Models.CategoryList
import com.example.itiproject.Models.MealList
import com.example.itiproject.Models.Meal
import com.example.itiproject.Models.MealsByCategoryList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMeal {

   @GET("random.php")
    fun getRandomMeal() : Call<MealList>

    @GET("lookup.php?")
    fun getMealDetails(@Query("i") id:String):Call<MealList>

    @GET("filter.php?")
    fun getMealsByCategory(@Query("c") category:String):Call<MealsByCategoryList>

    @GET("categories.php")
    fun getCategories() : Call<CategoryList>

}