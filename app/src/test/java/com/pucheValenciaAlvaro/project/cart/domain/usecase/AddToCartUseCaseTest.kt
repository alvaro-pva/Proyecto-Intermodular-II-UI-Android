package com.pucheValenciaAlvaro.project.cart.domain.usecase

import com.pucheValenciaAlvaro.project.cart.domain.repository.CartRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AddToCartUseCaseTest {

    private lateinit var repository: CartRepository
    private lateinit var useCase: AddToCartUseCase

    @BeforeEach
    fun setup() {
        repository = mockk(relaxed = true)
        useCase = AddToCartUseCase(repository)
    }

    @Test
    fun `should call repository when cardId is valid`() = runBlocking {
        useCase("123")

        coVerify { repository.addToCart("123") }
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