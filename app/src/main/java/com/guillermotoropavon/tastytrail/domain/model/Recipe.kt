package com.guillermotoropavon.tastytrail.domain.model

data class Recipe(
    val id: Int,
    val name: String,
    val ingredients: List<String>,
    val instructions: String
)