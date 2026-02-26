package com.pucheValenciaAlvaro.project.cart.domain.usecase

import com.pucheValenciaAlvaro.project.cart.domain.repository.CartRepository

class ClearCartUseCase(
    private val repository: CartRepository
) {

    suspend operator fun invoke() {
        repository.clearCart()
    }
}