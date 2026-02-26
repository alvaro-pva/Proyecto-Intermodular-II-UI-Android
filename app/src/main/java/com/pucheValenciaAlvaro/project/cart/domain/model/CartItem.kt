package com.pucheValenciaAlvaro.project.cart.domain.model

import com.pucheValenciaAlvaro.project.catalog.domain.model.Card

data class CartItem(
    val card: Card,
    val quantity: Int
)