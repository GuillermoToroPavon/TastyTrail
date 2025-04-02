package com.guillermotoropavon.tastytrail.data.model

import com.guillermotoropavon.tastytrail.domain.model.Recipe

data class RecipeDto(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strInstructions: String?,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strIngredient10: String?
)

// La base de datos trae los ingredientes implementados de esta manera por eso se pasan a una lista
fun RecipeDto.toDomain(): Recipe {
    val ingredients = listOfNotNull(
        strIngredient1, strIngredient2, strIngredient3, strIngredient4,
        strIngredient5, strIngredient6, strIngredient7, strIngredient8,
        strIngredient9, strIngredient10
    ).filter { it.isNotBlank() }

    return Recipe(
        id = idMeal.toInt(),
        name = strMeal,
        imageUrl = strMealThumb,
        ingredients = ingredients,
        instructions = strInstructions ?: ""
    )
}
