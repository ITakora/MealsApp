package com.example.mealsapp.model

data class Categories(
    val idCategory : String,
    val strCategory: String,
    val strCategoryThumb : String,
    val strCategoryDescription : String

)

data class CategoriesResponse (val categories: List<Categories>)
