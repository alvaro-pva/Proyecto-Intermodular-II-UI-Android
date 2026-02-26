package com.pucheValenciaAlvaro.project.cart.domain.usecase

import com.pucheValenciaAlvaro.project.cart.domain.repository.CartRepository

class RemoveFromCartUseCase(
    private val repository: CartRepository
) {

    suspend operator fun invoke(cardId: String) {
        require(cardId.isNotBlank()) { "Card ID cannot be empty" }

        repository.removeFromCart(cardId)
    }
}