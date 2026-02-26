package com.pucheValenciaAlvaro.project.auth.domain.usecase

import com.pucheValenciaAlvaro.project.auth.domain.model.User
import com.pucheValenciaAlvaro.project.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentUserUseCase(
    private val repository: AuthRepository
) {

    operator fun invoke(): Flow<User?> {
        return repository.getCurrentUser()
    }
}