package com.example.mealsapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mealsapp.model.Category
import com.example.mealsapp.screens.DetailScreen
import com.example.mealsapp.screens.MealScreen
import com.example.mealsapp.viewModel.MainViewModel

@Composable
fun MealsNav(navHostController: NavHostController) {
    val mealViewModel: MainViewModel = viewModel()
    val viewState by mealViewModel.categoriesState

    NavHost(navController = navHostController, startDestination = Screen.MealsScreen.route ) {
        composable(route = Screen.MealsScreen.route) {
            MealScreen( modifier = Modifier,viewState = viewState, navigateToDetail = {
                navHostController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navHostController.navigate(Screen.DetailScreen.route)
            } )

        }

        composable(route = Screen.DetailScreen.route) {
            val category = navHostController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?:
            Category(idCategory = "", strCategory = "", strCategoryThumb = "", strCategoryDescription = "")
            DetailScreen(category = category ) {
                navHostController.popBackStack()
            }
        }

    }


}