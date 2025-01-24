package com.ernestgichiri.farmhub.domain.entity.product

data class DetailProductEntity(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val imageUrl: List<String>,
    val rating: String,
)
