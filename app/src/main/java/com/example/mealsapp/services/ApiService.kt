package com.example.mealsapp.services

import com.example.mealsapp.model.CategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ApiService {

    @GET("categories.php")
    suspend fun getApi (): CategoriesResponse

}

val mealsService = retrofit.create(ApiService::class.java)
