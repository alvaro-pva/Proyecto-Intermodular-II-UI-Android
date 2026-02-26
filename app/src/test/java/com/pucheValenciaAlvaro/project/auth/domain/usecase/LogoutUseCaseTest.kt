package com.pucheValenciaAlvaro.project.auth.domain.usecase

import com.pucheValenciaAlvaro.project.auth.domain.repository.AuthRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LogoutUseCaseTest {

    private lateinit var repository: AuthRepository
    private lateinit var logoutUseCase: LogoutUseCase

    @BeforeEach
    fun setup() {
        repository = mockk()
        logoutUseCase = LogoutUseCase(repository)
    }

    @Test
    fun `should call repository logout`() = runBlocking {
        coEvery { repository.logout() } returns Unit

        logoutUseCase()

        coVerify { repository.logout() }
    }
}