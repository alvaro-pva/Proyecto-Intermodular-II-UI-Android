package com.pucheValenciaAlvaro.project.cart.domain.usecase

import com.pucheValenciaAlvaro.project.cart.domain.model.CartItem
import com.pucheValenciaAlvaro.project.cart.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow

class GetCartItemsUseCase(
    private val repository: CartRepository
) {

    operator fun invoke(): Flow<List<CartItem>> {
        return repository.getCartItems()
    }
}