package com.pucheValenciaAlvaro.project.auth.domain.usecase

import com.pucheValenciaAlvaro.project.auth.domain.model.User
import com.pucheValenciaAlvaro.project.auth.domain.repository.AuthRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RegisterUseCaseTest {

    private lateinit var repository: AuthRepository
    private lateinit var registerUseCase: RegisterUseCase

    @BeforeEach
    fun setup() {
        repository = mockk()
        registerUseCase = RegisterUseCase(repository)
    }

    @Test
    fun `should call repository when data is valid`() = runBlocking {
        val email = "test@mail.com"
        val password = "Password123"

        coEvery { repository.register(email, password) } returns User("1", email)

        registerUseCase(email, password)

        coVerify { repository.register(email, password) }
    }

    @Test
    fun `should throw exception when password too short`() {
        assertThrows<IllegalArgumentException> {
            runBlocking {
                registerUseCase("test@mail.com", "123")
            }
        }
    }
}