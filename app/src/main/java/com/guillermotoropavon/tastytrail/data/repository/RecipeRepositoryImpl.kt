package com.guillermotoropavon.tastytrail.data.repository

import com.guillermotoropavon.tastytrail.data.model.RecipeDto
import com.guillermotoropavon.tastytrail.data.model.RecipesResponse
import com.guillermotoropavon.tastytrail.domain.model.Recipe
import com.guillermotoropavon.tastytrail.domain.repository.RecipeRepository
import com.guillermotoropavon.tastytrail.data.api.MealApiService
import com.guillermotoropavon.tastytrail.data.model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val mealApiService: MealApiService
) : RecipeRepository {

    override suspend fun getRecipesByName(query: String): Flow<List<Recipe>> = flow {
        try {
            val response: RecipesResponse = mealApiService.getRecipesByName(query)
            emit(response.meals?.map { it.toDomain() } ?: emptyList())
        } catch (e: Exception) {
            emit(emptyList())
        }
    }

    override suspend fun getRecipesByIngredients(ingredient: String): Flow<List<Recipe>> = flow {
        try {
            val response: RecipesResponse = mealApiService.getRecipesByIngredient(ingredient)
            emit(response.meals?.map { it.toDomain() } ?: emptyList())
        } catch (e: Exception) {
            emit(emptyList())
        }
    }

    // Método para obtener todas las recetas
    override suspend fun getAllRecipes(): Flow<List<Recipe>> = flow {
        try {
            // Llamada a la API para obtener todas las recetas
            val response: RecipesResponse = mealApiService.getAllRecipes()
            // Convertir el DTO a la entidad de dominio (Recipe) y emitir la lista
            emit(response.meals?.map { it.toDomain() } ?: emptyList())
        } catch (e: Exception) {
            // Emitimos una lista vacía si ocurre un error
            emit(emptyList())
        }
    }
}
