package com.pucheValenciaAlvaro.project.catalog.domain.model

data class Card(
    val id: String,
    val name: String,
    val price: Double,
    val category: String,
    val imageUrl: String
)