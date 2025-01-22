package com.guillermotoropavon.tastytrail.domain.usecase

import com.guillermotoropavon.tastytrail.domain.model.Recipe
import com.guillermotoropavon.tastytrail.domain.repository.RecipeRepository

class SearchRecipesUseCase(private val repository: RecipeRepository) {
    suspend operator fun invoke(query: String): List<Recipe> {
        return repository.searchRecipes(query)
    }
}