package com.pucheValenciaAlvaro.project.catalog.domain.repository

import com.pucheValenciaAlvaro.project.catalog.domain.model.Card
import kotlinx.coroutines.flow.Flow

interface CardRepository {

    fun getAllCards(): Flow<List<Card>>

    fun getCardsByCategory(category: String): Flow<List<Card>>

    fun searchCards(query: String): Flow<List<Card>>
}