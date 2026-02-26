package com.pucheValenciaAlvaro.project.catalog.domain.usecase

import com.pucheValenciaAlvaro.project.catalog.domain.model.Card
import com.pucheValenciaAlvaro.project.catalog.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow

class FilterCardsUseCase(
    private val repository: CardRepository
) {

    operator fun invoke(category: String): Flow<List<Card>> {
        require(category.isNotBlank()) { "Category cannot be empty" }

        return repository.getCardsByCategory(category)
    }
}