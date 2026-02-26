package com.pucheValenciaAlvaro.project.catalog.domain.usecase

import com.pucheValenciaAlvaro.project.catalog.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow

class SearchCardsUseCase(
    private val repository: CardRepository
) {

    operator fun invoke(query: String): Flow<List<com.pucheValenciaAlvaro.project.catalog.domain.model.Card>> {
        require(query.isNotBlank()) { "Query cannot be empty" }
        return repository.searchCards(query)
    }
}