package com.guillermotoropavon.tastytrail.presentation.recipe_list

data class Recipe(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val ingredients: List<String>,
    val instructions: String
)