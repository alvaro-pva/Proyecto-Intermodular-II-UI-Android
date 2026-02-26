package com.pucheValenciaAlvaro.project.auth.domain.usecase

import com.pucheValenciaAlvaro.project.auth.domain.repository.AuthRepository

class LogoutUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke() {
        repository.logout()
    }
}