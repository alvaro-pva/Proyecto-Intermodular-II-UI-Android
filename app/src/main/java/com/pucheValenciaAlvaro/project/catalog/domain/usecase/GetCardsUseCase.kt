package com.pucheValenciaAlvaro.project.catalog.domain.usecase

import com.pucheValenciaAlvaro.project.catalog.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow

class GetCardsUseCase(
    private val repository: CardRepository
) {

    operator fun invoke(): Flow<List<com.pucheValenciaAlvaro.project.catalog.domain.model.Card>> {
        return repository.getAllCards()
    }
}