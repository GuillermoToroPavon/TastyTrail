package com.guillermotoropavon.tastytrail.domain.usecase

import com.guillermotoropavon.tastytrail.domain.model.Recipe
import com.guillermotoropavon.tastytrail.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    suspend fun execute(): Flow<List<Recipe>> {
        return recipeRepository.getRecipesByName("") // Deja el query vacío para obtener todas las recetas
    }
}
