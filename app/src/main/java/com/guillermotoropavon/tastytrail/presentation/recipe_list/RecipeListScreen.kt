package com.guillermotoropavon.tastytrail.presentation.receipe_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.guillermotoropavon.tastytrail.domain.model.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen(
    recipes: List<Recipe>,
    onRecipeClick: (Int) -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) } // Estado para mostrar u ocultar búsqueda

    // Filtrar recetas según el texto de búsqueda
    val filteredRecipes = recipes.filter { recipe ->
        recipe.name.contains(searchText, ignoreCase = true) ||
                recipe.ingredients.any { it.contains(searchText, ignoreCase = true) }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Barra de navegación superior con icono de búsqueda
        TopAppBar(
            title = {
                if (isSearching) {
                    // Campo de búsqueda cuando está activado
                    TextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        placeholder = { Text("Search...") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    // Título normal cuando no está buscando
                    Text("Tasty Trail")
                }
            },
            actions = {
                if (isSearching) {
                    // Botón para cerrar búsqueda
                    IconButton(onClick = { isSearching = false; searchText = "" }) {
                        Icon(Icons.Filled.Close, contentDescription = "Cerrar búsqueda")
                    }
                } else {
                    // Botón para activar búsqueda
                    IconButton(onClick = { isSearching = true }) {
                        Icon(Icons.Filled.Search, contentDescription = "Buscar recetas")
                    }
                }
            }
        )

        // Si la lista filtrada está vacía, mostramos un mensaje
        if (filteredRecipes.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("No recipes found", style = MaterialTheme.typography.bodyLarge)
            }
        } else {
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                items(filteredRecipes) { recipe ->
                    RecipeCard(recipe, onRecipeClick)
                }
            }
        }
    }
}

@Composable
fun RecipeCard(recipe: Recipe, onRecipeClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onRecipeClick(recipe.id) },
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
