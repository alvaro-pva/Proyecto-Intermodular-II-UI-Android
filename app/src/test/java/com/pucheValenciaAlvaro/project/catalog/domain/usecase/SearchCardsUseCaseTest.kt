package com.pucheValenciaAlvaro.project.catalog.domain.usecase

import com.pucheValenciaAlvaro.project.catalog.domain.model.Card
import com.pucheValenciaAlvaro.project.catalog.domain.repository.CardRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SearchCardsUseCaseTest {

    private lateinit var repository: CardRepository
    private lateinit var useCase: SearchCardsUseCase

    @BeforeEach
    fun setup() {
        repository = mockk()
        useCase = SearchCardsUseCase(repository)
    }

    @Test
    fun `should return filtered cards`() = runBlocking {
        val cards = listOf(Card("1", "Pikachu", 10.0, "Pokemon", ""))

        every { repository.searchCards("Pika") } returns flowOf(cards)

        val result = useCase("Pika").first()

        assertEquals(cards, result)
    }

    @Test
    fun `should throw exception when query blank`() {
        assertThrows<IllegalArgumentException> {
            useCase("")
        }
    }
}