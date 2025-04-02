package com.guillermotoropavon.tastytrail.presentation.recipe_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.guillermotoropavon.tastytrail.domain.model.Recipe

@Composable
fun RecipeDetailScreen(recipe: Recipe) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(recipe.imageUrl),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(recipe.name, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Ingredients:", style = MaterialTheme.typography.bodyMedium)
        recipe.ingredients.forEach { ingredient ->
            Text("- $ingredient", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("Instructions:", style = MaterialTheme.typography.bodyMedium)
        Text(recipe.instructions, style = MaterialTheme.typography.bodySmall)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeDetailScreen() {
    RecipeDetailScreen(
        recipe = Recipe(
            id = 1,
            name = "Example Recipe",
            imageUrl = "https://www.themealdb.com/images/media/meals/58oia61564916529.jpg",
            ingredients = listOf("Ingredient 1", "Ingredient 2"),
            instructions = "Some cooking instructions."
        )
    )
}
