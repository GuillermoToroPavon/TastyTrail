package com.guillermotoropavon.tastytrail.data.model

import com.guillermotoropavon.tastytrail.domain.model.Recipe

data class RecipesResponse(
    val meals: List<RecipeDto>?
)