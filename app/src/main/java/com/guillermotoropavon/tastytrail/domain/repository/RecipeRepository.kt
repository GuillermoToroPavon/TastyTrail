package com.guillermotoropavon.tastytrail.domain.repository

import com.guillermotoropavon.tastytrail.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun getRecipesByName(query: String): Flow<List<Recipe>>
    suspend fun getRecipesByIngredients(ingredient: String): Flow<List<Recipe>>
    suspend fun getAllRecipes(): Flow<List<Recipe>> // Añadimos esta línea
}
