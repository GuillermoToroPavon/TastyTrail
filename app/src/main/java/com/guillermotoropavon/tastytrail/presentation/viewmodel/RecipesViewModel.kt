package com.guillermotoropavon.tastytrail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guillermotoropavon.tastytrail.domain.usecase.GetAllRecipesUseCase
import com.guillermotoropavon.tastytrail.domain.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val getAllRecipesUseCase: GetAllRecipesUseCase
) : ViewModel() {

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun getAllRecipes() {
        viewModelScope.launch {
            try {
                getAllRecipesUseCase.execute().collect { recipeList ->
                    _recipes.value = recipeList
                }
            } catch (e: Exception) {
                _error.value = "Error al obtener las recetas"
            }
        }
    }
}
