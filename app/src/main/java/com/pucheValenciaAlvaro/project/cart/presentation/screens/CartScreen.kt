package com.pucheValenciaAlvaro.project.cart.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pucheValenciaAlvaro.project.core.presentation.components.BottomNavItem
import com.pucheValenciaAlvaro.project.core.presentation.components.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    isLoggedIn: Boolean
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Carrito") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(selectedItem = BottomNavItem.CART)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {


            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxWidth().alpha(if (isLoggedIn) 1f else 0.6f),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Card {
                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Imagen")
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text("Gothitelle", style = MaterialTheme.typography.bodySmall)
                                    Text("0,50€", style = MaterialTheme.typography.labelSmall)
                                }

                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = "Añadir",
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }


            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    if (isLoggedIn) "Pagar" else "Iniciar sesión"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenLoggedInPreview() {
    CartScreen(isLoggedIn = true)
}

@Preview(showBackground = true)
@Composable
fun CartScreenLoggedOutPreview() {
    CartScreen(isLoggedIn = false)
}



