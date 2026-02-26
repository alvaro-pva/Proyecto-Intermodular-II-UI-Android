package com.pucheValenciaAlvaro.project.cart.domain.repository

import com.pucheValenciaAlvaro.project.cart.domain.model.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    fun getCartItems(): Flow<List<CartItem>>

    suspend fun addToCart(cardId: String)

    suspend fun removeFromCart(cardId: String)

    suspend fun clearCart()
}