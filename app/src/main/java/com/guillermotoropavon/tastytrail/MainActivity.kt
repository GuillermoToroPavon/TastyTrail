package com.guillermotoropavon.tastytrail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import com.guillermotoropavon.tastytrail.presentation.viewmodel.RecipesViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: RecipesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a getAllRecipes al iniciar
            viewModel.getAllRecipes()

            val recipes = viewModel.recipes.collectAsState(emptyList()).value

            // Muestra la UI con las recetas obtenidas
            RecipesScreen(recipes)
        }
    }
}

@Composable
fun RecipesScreen(recipes: List<com.guillermotoropavon.tastytrail.domain.model.Recipe>) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Verifica si hay recetas
        if (recipes.isNotEmpty()) {
            LazyColumn {
                items(recipes) { recipe ->
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(recipe.name, style = MaterialTheme.typography.titleLarge)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Ingredients:", style = MaterialTheme.typography.bodyMedium)
                        recipe.ingredients.forEach { ingredient ->
                            Text(ingredient, style = MaterialTheme.typography.bodyMedium)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Instructions:", style = MaterialTheme.typography.bodyMedium)
                        Text(recipe.instructions, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        } else {
            Text("No recipes found", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipesScreen(recipes = listOf()) // Preview con lista vacía
}
