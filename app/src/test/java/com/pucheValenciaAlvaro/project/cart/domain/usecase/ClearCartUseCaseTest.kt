package com.pucheValenciaAlvaro.project.cart.domain.usecase

import com.pucheValenciaAlvaro.project.cart.domain.repository.CartRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ClearCartUseCaseTest {

    private lateinit var repository: CartRepository
    private lateinit var useCase: ClearCartUseCase

    @BeforeEach
    fun setup() {
        repository = mockk(relaxed = true)
        useCase = ClearCartUseCase(repository)
    }

    @Test
    fun `should call repository clearCart`() = runBlocking {
        useCase()

        coVerify { repository.clearCart() }
    }
}