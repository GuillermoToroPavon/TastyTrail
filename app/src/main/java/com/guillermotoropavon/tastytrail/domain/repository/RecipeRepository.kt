package com.guillermotoropavon.tastytrail.domain.repository

import com.guillermotoropavon.tastytrail.domain.model.Recipe

interface RecipeRepository {
    suspend fun getAllRecipes(): List<Recipe>
    suspend fun searchRecipes(query: String): List<Recipe>
}