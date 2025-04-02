package com.guillermotoropavon.tastytrail.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.guillermotoropavon.tastytrail.presentation.receipe_list.RecipeListScreen
import com.guillermotoropavon.tastytrail.presentation.recipe_detail.RecipeDetailScreen
import com.guillermotoropavon.tastytrail.domain.model.Recipe

sealed class Screen(val route: String) {
    object RecipeList : Screen("recipe_list")
    object RecipeDetail : Screen("recipe_detail/{id}") {
        fun createRoute(id: Int): String {
            return "recipe_detail/$id"
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController, recipes: List<Recipe>) {
    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(Screen.RecipeList.route) {
            RecipeListScreen(recipes = recipes, onRecipeClick = { recipeId ->
                navController.navigate(Screen.RecipeDetail.createRoute(recipeId))
            })
        }

        composable(
            route = Screen.RecipeDetail.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType }) // Aseguramos que 'id' sea un Int
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getInt("id") // Obtenemos el ID de la receta
            val recipe = recipes.find { it.id == recipeId } // Buscamos la receta en la lista

            if (recipe != null) {
                RecipeDetailScreen(recipe) // Mostramos la pantalla de detalles solo si la receta existe
            }
        }
    }
}
