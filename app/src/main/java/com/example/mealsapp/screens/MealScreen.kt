package com.example.mealsapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealsapp.viewModel.MainViewModel
import com.example.mealsapp.views.CategoryScreen


@Composable
fun MealScreen(modifier: Modifier = Modifier) {
    val mealViewModel: MainViewModel = viewModel()
    val viewState by mealViewModel.categoriesState


    Box(modifier = Modifier.fillMaxSize()) {
        when{
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(alignment = Alignment.Center))
            }
            
            viewState.error != null -> {
                Text(text = "${viewState.error}",modifier.align(alignment = Alignment.Center) )
            }

            else ->{
                CategoryScreen(categories = viewState.list)
            }


        }
    }





}