package com.pucheValenciaAlvaro.project.core.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable


enum class BottomNavItem {
    HOME,
    SEARCH,
    CART,
    PROFILE
}

@Composable
fun BottomNavigationBar(
    selectedItem: BottomNavItem
) {
    NavigationBar {
        NavigationBarItem(
            selected = selectedItem == BottomNavItem.HOME,
            onClick = {},
            icon = { Icon(Icons.Outlined.Home, contentDescription = "Home") }
        )

        NavigationBarItem(
            selected = selectedItem == BottomNavItem.SEARCH,
            onClick = {},
            icon = { Icon(Icons.Default.Search, contentDescription = "Buscar") }
        )

        NavigationBarItem(
            selected = selectedItem == BottomNavItem.CART,
            onClick = {},
            icon = { Icon(Icons.Outlined.ShoppingCart, contentDescription = "Carrito") }
        )

        NavigationBarItem(
            selected = selectedItem == BottomNavItem.PROFILE,
            onClick = {},
            icon = { Icon(Icons.Outlined.Person, contentDescription = "Perfil") }
        )
    }
}

