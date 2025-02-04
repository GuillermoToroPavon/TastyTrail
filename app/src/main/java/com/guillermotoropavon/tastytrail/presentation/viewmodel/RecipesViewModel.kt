package com.guillermotoropavon.tastytrail.presentation.viewmodel

import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guillermotoropavon.tastytrail.domain.model.Recipe
import com.guillermotoropavon.tastytrail.domain.usecase.GetAllRecipesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipesViewModel @Inject constructor(
    private val getAllRecipesUseCase: GetAllRecipesUseCase // Nueva dependencia para obtener todas las recetas
) : ViewModel() {

    // Estado para las recetas
    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes

    // Estado para manejar errores
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    // Obtener todas las recetas
    fun getAllRecipes() {
        viewModelScope.launch {
            try {
                // Llama a execute() en lugar de invoke()
                getAllRecipesUseCase.execute().collect { recipeList ->
                    _recipes.value = recipeList
                }
            } catch (e: Exception) {
                _error.value = "Error al obtener las recetas"
            }
        }
    }
}
