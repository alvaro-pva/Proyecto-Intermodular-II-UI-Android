package com.pucheValenciaAlvaro.project.catalog.domain.usecase

import com.pucheValenciaAlvaro.project.catalog.domain.model.Card
import com.pucheValenciaAlvaro.project.catalog.domain.repository.CardRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class FilterCardsUseCaseTest {

    private lateinit var repository: CardRepository
    private lateinit var useCase: FilterCardsUseCase

    @BeforeEach
    fun setup() {
        repository = mockk()
        useCase = FilterCardsUseCase(repository)
    }

    @Test
    fun `should return cards filtered by category`() = runBlocking {
        val cards = listOf(
            Card("1", "Pikachu", 10.0, "Pokemon", "")
        )

        every { repository.getCardsByCategory("Pokemon") } returns flowOf(cards)

        val result = useCase("Pokemon").first()

        assertEquals(cards, result)
    }

    @Test
    fun `should throw exception when category is blank`() {
        assertThrows<IllegalArgumentException> {
            useCase("")
        }
    }
}