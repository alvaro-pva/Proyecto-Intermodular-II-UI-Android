package com.pucheValenciaAlvaro.project.auth.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.pucheValenciaAlvaro.project.core.presentation.components.BottomNavItem
import com.pucheValenciaAlvaro.project.core.presentation.components.BottomNavigationBar


@Composable
fun LoginScreen(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(BottomNavItem.PROFILE)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Iniciar sesión o Registrarse",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                value = email,
                onValueChange = onEmailChange,
                label = { Text("Correo electrónico") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = password,
                onValueChange = onPasswordChange,
                label = { Text("Contraseña") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            val annotatedText = buildAnnotatedString {
                append("Si no tiene una cuenta, pulse ")

                pushStringAnnotation(
                    tag = "REGISTER",
                    annotation = "register"
                )
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Medium,
                        textDecoration = TextDecoration.None
                    )
                ) {
                    append("Registrarse")
                }
                pop()
            }

            ClickableText(
                text = annotatedText,
                style = MaterialTheme.typography.bodySmall,
                onClick = { offset ->
                    annotatedText.getStringAnnotations(
                        tag = "REGISTER",
                        start = offset,
                        end = offset
                    ).firstOrNull()?.let {
                        onRegisterClick()
                    }
                }
            )


            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onLoginClick) {
                Text("Iniciar sesión")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        email = "test@mail.com",
        password = "123456",
        onEmailChange = {},
        onPasswordChange = {},
        onRegisterClick = {},
        onLoginClick = {}
    )
}
