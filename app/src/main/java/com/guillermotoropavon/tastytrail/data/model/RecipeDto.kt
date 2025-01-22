package com.guillermotoropavon.tastytrail.data.model

import com.guillermotoropavon.tastytrail.domain.model.Recipe

data class RecipeDto(
    val id: Int,
    val name: String,
    val ingredients: String,
    val instructions: String
)

fun RecipeDto.toDomain(): Recipe {
    return Recipe(
        id = this.id,
        name = this.name,
        ingredients = this.ingredients.split(","),
        instructions = this.instructions
    )
}
