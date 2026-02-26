package com.pucheValenciaAlvaro.project.cart.domain.usecase

import com.pucheValenciaAlvaro.project.cart.domain.repository.CartRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RemoveFromCartUseCaseTest {

    private lateinit var repository: CartRepository
    private lateinit var useCase: RemoveFromCartUseCase

    @BeforeEach
    fun setup() {
        repository = mockk(relaxed = true)
        useCase = RemoveFromCartUseCase(repository)
    }

    @Test
    fun `should call repository when cardId is valid`() = runBlocking {
        useCase("123")

        coVerify { repository.removeFromCart("123") }
    }

    @Test
    fun `should throw exception when cardId is blank`() {
        assertThrows<IllegalArgumentException> {
            runBlocking {
                useCase("")
            }
        }
    }
}