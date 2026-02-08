package com.pucheValenciaAlvaro.project.catalog.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pucheValenciaAlvaro.project.core.presentation.components.BottomNavItem
import com.pucheValenciaAlvaro.project.core.presentation.components.BottomNavigationBar
import com.pucheValenciaAlvaro.project.R

data class CardItem(
    val name: String,
    val price: String,
    val imageRes: Int
)

@Composable
fun HomeScreen(
    cards: List<CardItem>,
    selectedFilter: String,
    onFilterSelected: (String) -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(selectedItem = BottomNavItem.HOME)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Pokemon",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("Todo", "Pokémon", "Magic", "LaLiga").forEach { filter ->
                    FilterChip(
                        selected = selectedFilter == filter,
                        onClick = { onFilterSelected(filter) },
                        label = { Text(filter) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(cards) { card ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {

                            // --- CUADRO ROSA (IMAGEN) ---
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                                    .padding(bottom = 6.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = card.imageRes),
                                    contentDescription = card.name,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            // --- TEXTO + ICONO ---
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = card.name,
                                        style = MaterialTheme.typography.bodySmall,
                                        maxLines = 1
                                    )
                                    Text(
                                        text = card.price,
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                }

                                IconButton(onClick = { /* nada */ }) {
                                    Icon(
                                        imageVector = Icons.Outlined.ShoppingCart,
                                        contentDescription = "Añadir al carrito"
                                    )
                                }
                            }
                        }
                    }


                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        cards = listOf(
            CardItem("Gothitelle", "0,50€", R.drawable.gothitelle),
            CardItem("Flapple", "10,0€", R.drawable.flappe),
            CardItem("Mega Absol ex", "1,33€", R.drawable.mega_absol_ex),
            CardItem("Mimikyu", "5,00€", R.drawable.mimikyu),
            CardItem("Mega Lucario ex", "1,00€", R.drawable.mega_lucario_ex),
            CardItem("Palafin", "0,80€", R.drawable.palafin),
            CardItem("Pikachu", "500,0€", R.drawable.pikachu),
            CardItem("Venasaur", "15,0€", R.drawable.venasaur),
            CardItem("Mega Diancie ex", "15,0€", R.drawable.mega_diancie_ex)
        ),
        selectedFilter = "Pokémon",
        onFilterSelected = {}
    )
}
