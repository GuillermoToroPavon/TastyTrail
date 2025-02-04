package com.guillermotoropavon.tastytrail.data.api

import com.guillermotoropavon.tastytrail.data.model.RecipesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiService {

    // Obtener recetas por nombre
    @GET("search.php")
    suspend fun getRecipesByName(@Query("s") query: String): RecipesResponse

    // Obtener recetas por ingrediente
    @GET("filter.php")
    suspend fun getRecipesByIngredient(@Query("i") ingredient: String): RecipesResponse

    // Obtener todas las recetas (usando un query vacío)
    @GET("search.php")
    suspend fun getAllRecipes(): RecipesResponse
}
