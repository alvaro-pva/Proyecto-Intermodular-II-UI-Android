package com.pucheValenciaAlvaro.project.auth.domain.repository

import com.pucheValenciaAlvaro.project.auth.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun getCurrentUser(): Flow<User?>

    suspend fun login(email: String, password: String): User

    suspend fun register(email: String, password: String): User

    suspend fun logout()
}