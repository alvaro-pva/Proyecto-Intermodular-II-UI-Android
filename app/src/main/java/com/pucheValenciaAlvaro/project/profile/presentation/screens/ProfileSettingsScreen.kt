package com.pucheValenciaAlvaro.project.profile.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pucheValenciaAlvaro.project.core.presentation.components.BottomNavItem
import com.pucheValenciaAlvaro.project.core.presentation.components.BottomNavigationBar

@Composable
fun ProfileSettingsScreen(
    onLogoutClick: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(selectedItem = BottomNavItem.PROFILE)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(start = 50.dp, end = 24.dp)
                .padding(top = 60.dp)
        ) {

            Text(
                text = "Ajustes de cuenta",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Ajustes de privacidad",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Métodos de pago",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Pedidos",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.weight(1f))

            TextButton(onClick = onLogoutClick) {
                Text("Cerrar sesión")
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileSettingsScreen(
        onLogoutClick = {}
    )
}

