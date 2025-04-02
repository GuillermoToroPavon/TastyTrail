package com.guillermotoropavon.tastytrail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import com.guillermotoropavon.tastytrail.presentation.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint
import com.guillermotoropavon.tastytrail.presentation.viewmodel.RecipesViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: RecipesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            // Llama a getAllRecipes al iniciar
            viewModel.getAllRecipes()
            val recipes = viewModel.recipes.collectAsState(emptyList()).value

            // Inicia la navegación
            AppNavigation(navController, recipes)
        }
    }
}
