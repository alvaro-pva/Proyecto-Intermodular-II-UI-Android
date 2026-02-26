package com.pucheValenciaAlvaro.project.auth.domain.usecase

import com.pucheValenciaAlvaro.project.auth.domain.repository.AuthRepository

class RegisterUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(email: String, password: String) {
        require(email.contains("@")) { "Invalid email format" }
        require(password.length in 8..16) { "Password must be between 8 and 16 characters" }

        repository.register(email, password)
    }
}