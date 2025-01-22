package com.ernestgichiri.farmhub.data.mapper

import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.domain.mapper.ProductListMapper
import com.ernestgichiri.farmhub.data.dto.Product
import javax.inject.Inject

class ProductEntityMapper @Inject constructor() :
    ProductListMapper<Product, ProductEntity> {
    override fun map(input: List<Product>): List<ProductEntity> {
        return input.map {
            ProductEntity(
                id = it.id,
                title = it.title,
                description = it.description,
                price = it.price.toString(),
                imageUrl = it.images[0],
                rating = it.rating,
            )
        }
    }
}
