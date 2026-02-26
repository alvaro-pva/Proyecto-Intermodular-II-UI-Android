package com.pucheValenciaAlvaro.project.auth.domain.usecase

import com.pucheValenciaAlvaro.project.auth.domain.model.User
import com.pucheValenciaAlvaro.project.auth.domain.repository.AuthRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class GetCurrentUserUseCaseTest {

    private lateinit var repository: AuthRepository
    private lateinit var useCase: GetCurrentUserUseCase

    @BeforeEach
    fun setup() {
        repository = mockk()
        useCase = GetCurrentUserUseCase(repository)
    }

    @Test
    fun `should return current user flow`() = runBlocking {
        val user = User("1", "test@mail.com")

        every { repository.getCurrentUser() } returns flowOf(user)

        val result = useCase().first()

        assertEquals(user, result)
    }
}