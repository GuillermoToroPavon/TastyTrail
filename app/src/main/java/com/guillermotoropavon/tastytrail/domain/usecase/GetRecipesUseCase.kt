package com.guillermotoropavon.tastytrail.domain.usecase

import com.guillermotoropavon.tastytrail.domain.model.Recipe
import com.guillermotoropavon.tastytrail.domain.repository.RecipeRepository

class GetRecipesUseCase(private val repository: RecipeRepository) {
    suspend operator fun invoke(): List<Recipe> {
        return repository.getAllRecipes()
    }
}