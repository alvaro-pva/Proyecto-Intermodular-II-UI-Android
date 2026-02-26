package com.pucheValenciaAlvaro.project.auth.domain.usecase

import com.pucheValenciaAlvaro.project.auth.domain.repository.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(email: String, password: String) {
        require(email.contains("@")) { "Invalid email" }
        require(password.length >= 8) { "Password too short" }

        repository.login(email, password)
    }
}