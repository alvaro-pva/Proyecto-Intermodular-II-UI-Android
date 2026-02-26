package com.pucheValenciaAlvaro.project.auth.domain.usecase

import com.pucheValenciaAlvaro.project.auth.domain.model.User
import com.pucheValenciaAlvaro.project.auth.domain.repository.AuthRepository
import com.pucheValenciaAlvaro.project.auth.domain.usecase.LoginUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LoginUseCaseTest {

    private lateinit var repository: AuthRepository
    private lateinit var loginUseCase: LoginUseCase

    @BeforeEach
    fun setup() {
        repository = mockk()
        loginUseCase = LoginUseCase(repository)
    }

    @Test
    fun `should call repository when email and password are valid`() = runBlocking {
        val email = "test@mail.com"
        val password = "password123"

        coEvery { repository.login(email, password) } returns User("1", email)

        loginUseCase(email, password)

        coVerify { repository.login(email, password) }
    }

    @Test
    fun `should throw exception when email is invalid`() {
        assertThrows<IllegalArgumentException> {
            runBlocking {
                loginUseCase("invalidEmail", "password123")
            }
        }
    }
}