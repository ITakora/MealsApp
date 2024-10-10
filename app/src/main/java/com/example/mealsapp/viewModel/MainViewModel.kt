package com.example.mealsapp.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealsapp.model.Category
import com.example.mealsapp.services.mealsService
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {

    private val _categoriesState = mutableStateOf(MealsState())
    val categoriesState : State<MealsState> = _categoriesState


   init {
       getCategories()
   }

    private fun getCategories () {
        viewModelScope.launch {
            try {
                val response = mealsService.getApi()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }catch (e: Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error: ${e.message}"
                )
            }

        }
    }


    data class MealsState (
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )


}