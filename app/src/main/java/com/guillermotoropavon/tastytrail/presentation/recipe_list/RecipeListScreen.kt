package com.guillermotoropavon.tastytrail.presentation.receipe_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.guillermotoropavon.tastytrail.domain.model.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen(
    recipes: List<Recipe>,
    onRecipeClick: (Int) -> Unit // Ahora recibe solo el ID de la receta
) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Barra de navegación superior
        TopAppBar(
            title = { Text("Tasty Trail") },
            actions = {
                IconButton(onClick = { /* Acción de búsqueda */ }) {
                    Icon(Icons.Filled.Search, contentDescription = "Buscar recetas")
                }
            }
        )

        // Si la lista está vacía, mostramos un mensaje
        if (recipes.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("No recipes found", style = MaterialTheme.typography.bodyLarge)
            }
        } else {
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                items(recipes) { recipe ->
                    RecipeCard(recipe, onRecipeClick)
                }
            }
        }
    }
}

// Composable para mostrar una receta como tarjeta
@Composable
fun RecipeCard(recipe: Recipe, onRecipeClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onRecipeClick(recipe.id) }, // Pasamos solo el ID de la receta
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(recipe.imageUrl),
                contentDescription = recipe.name,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(recipe.name, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Ingredients: ${recipe.ingredients.take(3).joinToString(", ")}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

// Vista previa de la lista con recetas de prueba
@Preview(showBackground = true)
@Composable
fun PreviewRecipeListScreen() {
    val sampleRecipes = listOf(
        Recipe(1, "Sushi", "https://www.themealdb.com/images/media/meals/g046bb1663960946.jpg", listOf("Rice", "Fish", "Seaweed"), "Instructions here..."),
        Recipe(2, "Pasta", "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg", listOf("Pasta", "Tomato", "Cheese"), "Instructions here...")
    )
    RecipeListScreen(recipes = sampleRecipes, onRecipeClick = {})
}
