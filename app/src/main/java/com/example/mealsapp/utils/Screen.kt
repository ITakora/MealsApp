package com.example.mealsapp.utils

sealed class Screen(val route:String){
    data object MealsScreen:Screen("mealsScreen")
    data object DetailScreen:Screen("detailScreen")
}