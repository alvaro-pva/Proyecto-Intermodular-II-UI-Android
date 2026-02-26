package com.pucheValenciaAlvaro.project.cart.domain.usecase

import com.pucheValenciaAlvaro.project.cart.domain.model.CartItem
import com.pucheValenciaAlvaro.project.cart.domain.repository.CartRepository
import com.pucheValenciaAlvaro.project.catalog.domain.model.Card
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GetCartItemsUseCaseTest {

    private lateinit var repository: CartRepository
    private lateinit var useCase: GetCartItemsUseCase

    @BeforeEach
    fun setup() {
        repository = mockk()
        useCase = GetCartItemsUseCase(repository)
    }

    @Test
    fun `should return cart items from repository`() = runBlocking {
        val card = Card("1", "Pikachu", 10.0, "Pokemon", "http://image.com")
        val items = listOf(
            CartItem(card, 1)
        )

        every { repository.getCartItems() } returns flowOf(items)

        val result = useCase().first()

        assertEquals(items, result)
    }
}